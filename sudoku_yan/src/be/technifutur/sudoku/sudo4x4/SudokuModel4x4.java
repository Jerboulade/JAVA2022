package be.technifutur.sudoku.sudo4x4;

import be.technifutur.sudoku.*;

import java.time.ZoneId;
import java.util.HashSet;

public class SudokuModel4x4 extends AbstractSudokuModel implements SudokuModel {

    public SudokuModel4x4() {
        super(createGrid(4));
    }

    @SuppressWarnings("unchecked")
    private static Cell[][] createGrid(int size) {
        Cell[][] grille = new Cell[size][size];

        HashSet<Character>[] colZone = new HashSet[size];
        for (int x = 0; x < size; x++)
            colZone[x] = new HashSet<>();
        HashSet<Character>[] sqrZone = new HashSet[size];
        for (int x = 0; x < size; x++)
            sqrZone[x] = new HashSet<>();
        for (int i = 0; i < size; i++) {
            HashSet<Character> lineZone = new HashSet<>();
            for (int j = 0; j < size; j++) {
                grille[i][j] = new Cell();
                grille[i][j].addZone("line" + i, lineZone);
                System.out.print("line" + i);
                grille[i][j].addZone("col" + j, colZone[j]);
                System.out.print(" - col" + j);
                int zoneIndex = j / (int)Math.sqrt(size) + (i / (int)Math.sqrt(size) * (int)Math.sqrt(size));
                System.out.println(" - sqr" + zoneIndex);
                grille[i][j].addZone("sqr" + zoneIndex, sqrZone[zoneIndex]);
            }
        }
        return (grille);
    }

    @Override
    public boolean isValueValid(char value) {
        return value >= '1' && value <= '4';
    }

    @Override
    public boolean isPositionValid(int lig, int col) {
        return lig >= 0 &&
                lig < 4 &&
                col >= 0 &&
                col < 4;
    }

    @Override
    public int getNbvalues() {
        return 4*4;
    }

}
