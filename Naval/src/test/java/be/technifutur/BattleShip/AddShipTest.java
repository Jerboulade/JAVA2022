package be.technifutur.BattleShip;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

public class AddShipTest {

    private Grid grid;

    @BeforeEach
    void initGrid(){
        grid = new Grid();
    }

    @DisplayName("Check if adding Ship works")
    @ParameterizedTest
    @ValueSource(strings = {"D5", "E5", "F5"})
    void testAddTrue(String pos){
        //System.out.println(pos);
        boolean isAdded = grid.add(ShipType.CRUISER, "D5", Direction.HORIZONTAL);
        Optional<ShipType> ship = grid.get(pos);
        assertAll(
                () -> assertTrue(ship.isPresent()),
                () -> assertTrue(isAdded),
                () -> assertEquals(ShipType.CRUISER, ship.get()),
                () -> assertFalse(grid.isEmpty(pos))
                );
    }

    @DisplayName("Check if adding Ship fails")
    @ParameterizedTest
    @ValueSource(strings = {"DD4", "", " ", "G5", "H5", "J55", "Z55"})
    void testAddFalse(String pos){
        System.out.println(pos);
        boolean isAdded = grid.add(ShipType.CRUISER, "D5", Direction.HORIZONTAL);
        Optional<ShipType> ship = grid.get(pos);
        System.out.println(ship);
        assertAll(
                () -> assertFalse(ship.isPresent()),
                () -> assertFalse(isAdded),
                () -> assertTrue(grid.isEmpty(pos))
        );
    }




}
