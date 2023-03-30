package be.technifutur.model.abstractMazeFactory.builder;

import be.technifutur.model.abstractMazeFactory.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class TestBuilder {

    public static void main(String[] args) {
        AbstractMazeFactory abstractMazeFactory = AbstractMazeFactory.getFactory("castle");
        MazeElement[][] maze = TestFactory.getMaze(abstractMazeFactory);

        StringMazeBuilder builder = new StringMazeBuilder();
        makeFromArray(builder, maze);
        System.out.println("----");
        System.out.println(builder.build());

        ElemMazeBuilder elemMazeBuilder = new ElemMazeBuilder(abstractMazeFactory);
        makeFromFile(elemMazeBuilder, "maze_01.txt");
        MazeElement[][] maze2 = elemMazeBuilder.build();


        Arrays.stream( maze2 ).forEach( line -> {
                    Arrays.stream( line ).forEach( elem -> {
                            System.out.print(elem.description());
                            System.out.print(",");
                    });
                    System.out.print("\n");
                });
// something wrong here above, each line are printed nb_col times

        Arrays.stream(maze2).flatMap(Arrays::stream)
                .map(e->e.description())
                .forEach(System.out::println);
    }

    public static void makeFromFile(MazeBuilder mazeBuilder, String filePath) {
        try (Scanner scan = new Scanner(new File(filePath))) {
            mazeBuilder.start();
            int line = 0;
            while (scan.hasNextLine()) {
                String row = scan.nextLine();
                for (int col = 0; col < row.length(); col++) {
                    char c = row.charAt(col);
                    switch (c) {
                        case 'w' -> mazeBuilder.addWall(line, col);
                        case 'd' -> mazeBuilder.addDoor(line, col);
                        case '.' -> mazeBuilder.addRoom(line, col);
                    }
                }
                line++;
            }
        } catch (FileNotFoundException err) {
            throw new RuntimeException(err);
        }
    }


    public static void makeFromArray(MazeBuilder mazeBuilder, MazeElement[][] mazeElementsArray) {
        mazeBuilder.start();
        for (int line = 0; line < mazeElementsArray.length; line++) {
            for (int col = 0; col < mazeElementsArray[line].length; col++) {
                if (mazeElementsArray[line][col] instanceof Room)
                    mazeBuilder.addRoom(line, col);
                else if (mazeElementsArray[line][col] instanceof Wall)
                    mazeBuilder.addWall(line, col);
                else if (mazeElementsArray[line][col] instanceof Door)
                    mazeBuilder.addDoor(line, col);
            }
        }
    }
}
