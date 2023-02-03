package be.technifutur.BattleShip;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestGrid {

    private Grid grid;

    @BeforeEach
    void init(){
        grid = new Grid();
        // ici on peut configurer la grille avant test;
    }

    @Test
    void testCreateGrid(){
        assertAll(
                () -> assertEquals(10, grid.width()),
                () -> assertEquals(10, grid.height())
        );
    }

    @Test
    void testNewEmptyGrid(){
        //Grid g = new Grid();
        for (char i = 0; i < grid.width(); i++){
            char col = (char)('A' + i);
            for (int j = 0; j < grid.height(); j++) {
                String pos = "" + col + (j + 1);
                assertTrue(grid.isEmpty(pos), () -> String.format("case %s isn't empty", pos));
            }
        }
    }

    @ParameterizedTest(name = "test {index} : position [{0}]")
    @ValueSource( strings = {"A1", "A10", "D5", "J1", "J10"})
    @DisplayName("Les positions sont valides")
    void testValidityTrue(String pos){
        Grid grid = new Grid();
        assertTrue(grid.isValid(pos), () -> String.format("Position %s isn't valid", pos));
    }

    @ParameterizedTest(name = "test {index} : position [{0}]")
    @ValueSource( strings = {"", " ", ".", "-^", "AA", "C11", "B", "A0", "F21", "B-1", "11"})
    @DisplayName("Les positions sont invalides")
    void testValidityFalse(String pos){
        Grid grid = new Grid();
        assertFalse(grid.isValid(pos), () -> String.format("Position %s is valid but should not", pos));
    }

    @Test
    @DisplayName("isEmpty() throw Exception")
    void testIsEmptyException(){
        Grid grid = new Grid();
        /*
        try {
            grid.isEmpty("toto");
            fail("pas d'exception soulevée"); // si j'arrive ici, c'est que mon code qui devait soulevé une exception n'en soulève pas
        }
        catch (IndexOutOfBoundsException e){
        }
        */

        // façon plus facile de faire le code ci-dessous
        assertThrows(IndexOutOfBoundsException.class, ()->grid.isEmpty("toto"));
    }

}
