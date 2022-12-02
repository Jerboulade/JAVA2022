package be.technifutur.sudoku.sudo9x9;

import be.technifutur.sudoku.SudokuModel;

import java.util.Arrays;

public class GridModel9 implements SudokuModel
{
    public Character[] grid = new Character[9 * 9];
    public String  format = """
            +----------+----------+----------+
            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
            +----------+----------+----------+
            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
            +----------+----------+----------+
            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
            +----------+----------+----------+
            """;

    public GridModel9(){
        Arrays.fill(grid, '.');
    }

    @Override
    public void setValue(int i, int j, char val) {
        i--;
        j--;
        if (isValidPosition(i, j) && isValidValue(val))
            grid[(i * 9) + j] = val;
    }

    @Override
    public char getValue(int i, int j) {
        i--;
        j--;
        return(isValidPosition(i, j) ? grid[(i * 9) + j] : 0);
    }

    @Override
    public void deleteValue(int i, int j) {
        setValue(i, j, EMPTY);
    }

    @Override
    public Boolean isValidPosition(int i, int j){

        return (i >= 1 && i <= 9 && j >= 1 && j <= 9);
    }

    @Override
    public Boolean isValidValue(char c){

        return ((c >= '1' && c <= '9') || c == EMPTY);
    }

    public void fillGrid(Character[] tab)
    {
        for (int i = 0; i < 81; i++)
                grid[i]= tab[i];
    }


}
