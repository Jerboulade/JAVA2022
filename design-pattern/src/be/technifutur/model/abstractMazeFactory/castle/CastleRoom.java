package be.technifutur.model.abstractMazeFactory.castle;

import be.technifutur.model.abstractMazeFactory.Room;

public class CastleRoom implements Room {
    @Override
    public String description() {
        return "Castle Room";
    }
}
