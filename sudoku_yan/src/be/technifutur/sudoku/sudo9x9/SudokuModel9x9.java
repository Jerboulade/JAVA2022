package be.technifutur.sudoku.sudo9x9;

import be.technifutur.sudoku.*;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class SudokuModel9x9 extends AbstractSudokuModel implements SudokuModel {

    public SudokuModel9x9() {
        super(createGrid(9));
    }

    private static Cell[][] createGrid(int size) {
        Cell[][] grille = new Cell[size][size];

        HashSet<Character>[] colZone = new HashSet[size];
        for (int x = 0; x < size; x++)
            colZone[x] = new LinkedHashSet<>();
        HashSet<Character>[] sqrZone = new HashSet[size];
        for (int x = 0; x < size; x++)
            sqrZone[x] = new LinkedHashSet<>();
        for (int i = 0; i < size; i++) {
            HashSet<Character> lineZone = new HashSet<>();
            for (int j = 0; j < size; j++) {
                grille[i][j] = new Cell();
                grille[i][j].addZone("line" + i, lineZone);
                grille[i][j].addZone("col" + j, colZone[j]);
                int zoneIndex = (int)Math.sqrt(size) + (i / (int)Math.sqrt(size) * (int)Math.sqrt(size));
                grille[i][j].addZone("sqr" + zoneIndex, sqrZone[zoneIndex]);
            }
        }
        return (grille);
    }

    @Override
    public boolean isValueValid(char value) {
        return value >= '1' && value <= '9';
    }

    @Override
    public boolean isPositionValid(int lig, int col) {
        return lig >= 0 &&
                lig < 9 &&
                col >= 0 &&
                col < 9;
    }

    @Override
    public int getNbvalues() {
        return 9*9;
    }


}
