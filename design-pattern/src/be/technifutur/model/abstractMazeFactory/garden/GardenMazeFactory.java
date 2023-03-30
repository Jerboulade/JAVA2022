package be.technifutur.model.abstractMazeFactory.garden;

import be.technifutur.model.abstractMazeFactory.AbstractMazeFactory;
import be.technifutur.model.abstractMazeFactory.Door;
import be.technifutur.model.abstractMazeFactory.Room;
import be.technifutur.model.abstractMazeFactory.Wall;

public class GardenMazeFactory extends AbstractMazeFactory {
    private GardenWall gardenWall;
    @Override
    public Door createDoor() {
        return new GardenDoor();
    }

    @Override
    public Wall createWall() {
        if (gardenWall == null) {
            gardenWall = new GardenWall();
        }
        return gardenWall;
    }

    @Override
    public Room createRoom() {
        return new GardenRoom();
    }
}
