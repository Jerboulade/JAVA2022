package be.technifutur.sudoku.sudo9x9;

import be.technifutur.sudoku.*;

public class SudokuModel9x9 extends AbstractSudokuModel implements SudokuModel {

    public SudokuModel9x9() {
        super(createGrid(9));
    }

    private static Cell[][] createGrid(int size) {
        Cell[][] grille = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                grille[i][j] = new Cell();
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
