package be.technifutur.sudoku;

public interface SudokuModel {
    char EMPTY = 0;

    char getValue(int lig, int col) throws SudokuPositionException;

    void setValue(int lig, int col, char value)
            throws SudokuException;

    void deleteValue(int lig, int col) throws SudokuException;

    boolean isValueValid(char value);

    boolean isPositionValid(int lig, int col);

    int getNbvalues();

    int getMaxSize();

    void lockGrid();
}
