package be.technifutur.model.abstractMazeFactory.builder;

import be.technifutur.model.abstractMazeFactory.AbstractMazeFactory;
import be.technifutur.model.abstractMazeFactory.MazeElement;

import java.util.ArrayList;
import java.util.Arrays;

public class ElemMazeBuilder implements MazeBuilder{

    private ArrayList<ArrayList<MazeElement>> mazeList;
    private int line;
    private AbstractMazeFactory abstractMazeFactory;

    public ElemMazeBuilder(AbstractMazeFactory abstractMazeFactory) {
        this.abstractMazeFactory = abstractMazeFactory;
    }



    public MazeElement[][] build(){
        MazeElement[][] result = new MazeElement[mazeList.size()][];
        ArrayList<MazeElement>[] tab =  mazeList.toArray(new ArrayList[0]);
        for (int i = 0; i < tab.length; i++){
            result[i] = tab[i].toArray(new MazeElement[0]);
        }
        return result;
    }

    @Override
    public MazeBuilder start() {
        mazeList = new ArrayList<ArrayList<MazeElement>>();
        line = -1;
        return this;
    }


    public ArrayList<MazeElement> getRow(int line){
        if (this.line != line)
            return new ArrayList<MazeElement>();
        return mazeList.get(mazeList.size() - 1);
    }
    @Override
    public MazeBuilder addWall(int line, int col) {
        ArrayList<MazeElement> row = getRow(line);
        row.add(abstractMazeFactory.createWall());
        mazeList.add(row);
        this.line = line;
        return this;
    }

    @Override
    public MazeBuilder addDoor(int line, int col) {
        ArrayList<MazeElement> row = getRow(line);
        row.add(abstractMazeFactory.createDoor());
        mazeList.add(row);
        this.line = line;
        return this;

    }

    @Override
    public MazeBuilder addRoom(int line, int col) {
        ArrayList<MazeElement> row = getRow(line);
        row.add(abstractMazeFactory.createRoom());
        mazeList.add(row);
        this.line = line;
        return this;

    }
}
