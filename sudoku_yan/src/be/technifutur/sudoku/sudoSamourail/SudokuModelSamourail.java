package be.technifutur.sudoku.sudoSamourail;

import be.technifutur.sudoku.*;

public class SudokuModelSamourail extends AbstractSudokuModel implements SudokuModel {

    public SudokuModelSamourail() {
        super(createGrid(21));
    }

    private static Cell[][] createGrid(int size) {
        Cell[][] grille = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isPositionValid1(i, j))
                    grille[i][j] = new Cell();
            }
        }
        return (grille);
    }

    @Override
    public boolean isValueValid(char value) {
        return value >= '1' && value <= '9';
    }

    @Override
    public boolean isPositionValid(int lig, int col){
        return (isPositionValid1(lig, col));
    }

    public static boolean isPositionValid1(int lig, int col) {
        return isPositionInSudoku(lig, col, 0, 0) ||
                isPositionInSudoku(lig, col, 0, 9 + 3) ||
                isPositionInSudoku(lig, col, 6, 6) ||
                isPositionInSudoku(lig, col, 9 + 3, 0) ||
                isPositionInSudoku(lig, col, 9 + 3, 9 + 3);
    }


    @Override
    public int getNbvalues() {
        return 21*21 - 4* 3 * 6;
    }

    private static boolean isPositionInSudoku(int lig, int col, int lig0, int col0) {
        return lig >= lig0 &&
                lig < 9 + lig0 &&
                col >= col0 &&
                col < 9 + col0;
    }
}
