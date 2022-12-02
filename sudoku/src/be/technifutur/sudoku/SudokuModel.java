package be.technifutur.sudoku;

public interface SudokuModel
{
    char EMPTY = '.';

    void setValue(int i, int j, char val);
    char getValue(int i, int j);
    void deleteValue(int i, int j);
    Boolean isValidPosition(int i, int j);
    Boolean isValidValue(char c);
}
