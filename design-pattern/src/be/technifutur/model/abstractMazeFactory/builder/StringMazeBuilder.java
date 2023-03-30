package be.technifutur.model.abstractMazeFactory.builder;

public class StringMazeBuilder implements MazeBuilder{

    private String  maze ;
    private int     line;

    public String build(){
        return maze;
    }

    @Override
    public MazeBuilder start() {
        line = 0;
        maze = "";
        return this;
    }

    @Override
    public MazeBuilder addWall(int line, int col) {
        if (this.line != line){
            maze = maze.concat("\n");
            this.line = line;
        }
        maze = maze.concat("w");
        return this;
    }

    @Override
    public MazeBuilder addDoor(int line, int col) {
        if (this.line != line){
            maze = maze.concat("\n");
            this.line = line;
        }
        maze = maze.concat("d");
        return this;
    }

    @Override
    public MazeBuilder addRoom(int line, int col) {
        if (this.line != line){
            maze = maze.concat("\n");
            this.line = line;
        }
        maze = maze.concat(".");
        return this;
    }
}
