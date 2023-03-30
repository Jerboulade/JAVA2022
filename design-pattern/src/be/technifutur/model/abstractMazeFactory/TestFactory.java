package be.technifutur.model.abstractMazeFactory;

public class TestFactory {

    public static void main(String[] args) {
        AbstractMazeFactory factory = AbstractMazeFactory.getFactory("garden");
        MazeElement[][] maze = getMaze(factory);

        for ( MazeElement elem : maze[1]){
            System.out.println(elem.description());
        }
    }

    public static MazeElement[][] getMaze(AbstractMazeFactory factory) {
        MazeElement[][] maze = new MazeElement[3][3];
        maze[0][0] = factory.createWall();
        maze[0][1] = factory.createWall();
        maze[0][2] = factory.createWall();
        maze[1][0] = factory.createDoor();
        maze[1][1] = factory.createRoom();
        maze[1][2] = factory.createDoor();
        maze[2][0] = factory.createWall();
        maze[2][1] = factory.createWall();
        maze[2][2] = factory.createWall();
        return maze;
    }
}
