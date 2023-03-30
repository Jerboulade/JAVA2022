package be.technifutur.model.abstractMazeFactory.garden;

import be.technifutur.model.abstractMazeFactory.Door;

public class GardenDoor implements Door {
    @Override
    public String description() {
        return "Garden Door";
    }
}
