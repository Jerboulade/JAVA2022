package be.technifutur.model.abstractMazeFactory.castle;

import be.technifutur.model.abstractMazeFactory.Door;

public class CastleDoor implements Door {
    @Override
    public String description() {
        return "Castle Door";
    }
}
