package be.technifutur.model.abstractMazeFactory.garden;

import be.technifutur.model.abstractMazeFactory.Wall;

public class GardenWall implements Wall {
    @Override
    public String description() {
        return "Garden Wall";
    }
}
