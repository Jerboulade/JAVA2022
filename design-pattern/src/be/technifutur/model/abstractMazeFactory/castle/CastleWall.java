package be.technifutur.model.abstractMazeFactory.castle;

import be.technifutur.model.abstractMazeFactory.Wall;

public class CastleWall implements Wall {
    @Override
    public String description() {
        return "Castle Wall";
    }
}
