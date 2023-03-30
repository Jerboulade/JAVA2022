package be.technifutur.model.abstractMazeFactory.builder;

public interface MazeBuilder {
    MazeBuilder start();
    MazeBuilder addWall(int line, int col);
    MazeBuilder addDoor(int line, int col);
    MazeBuilder addRoom(int line, int col);
}
