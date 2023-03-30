package be.technifutur.model.abstractMazeFactory;

import be.technifutur.model.abstractMazeFactory.castle.CastleMazeFactory;
import be.technifutur.model.abstractMazeFactory.garden.GardenMazeFactory;

public  abstract class AbstractMazeFactory {

    public static AbstractMazeFactory getFactory(String type) {
        return switch (type){
            case "castle" -> new CastleMazeFactory();
            case "garden" -> new GardenMazeFactory();
            default -> null;
        };
    }

    public abstract Door createDoor();
    public abstract Wall createWall();
    public abstract Room createRoom();
}
