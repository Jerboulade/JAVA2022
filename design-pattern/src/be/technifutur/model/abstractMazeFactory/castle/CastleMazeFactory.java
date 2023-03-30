package be.technifutur.model.abstractMazeFactory.castle;

import be.technifutur.model.abstractMazeFactory.AbstractMazeFactory;
import be.technifutur.model.abstractMazeFactory.Door;
import be.technifutur.model.abstractMazeFactory.Room;
import be.technifutur.model.abstractMazeFactory.Wall;

public class CastleMazeFactory extends AbstractMazeFactory {
    @Override
    public Door createDoor() {
        return new CastleDoor();
    }

    @Override
    public Wall createWall() {
        return new CastleWall();
    }

    @Override
    public Room createRoom() {
        return new CastleRoom();
    }
}
