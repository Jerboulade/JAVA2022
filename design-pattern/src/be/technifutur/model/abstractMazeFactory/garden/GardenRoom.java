package be.technifutur.model.abstractMazeFactory.garden;

import be.technifutur.model.abstractMazeFactory.Room;

public class GardenRoom implements Room {
    @Override
    public String description() {
        return "Garden Room";
    }
}
