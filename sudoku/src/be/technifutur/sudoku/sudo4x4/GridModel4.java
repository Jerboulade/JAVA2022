package be.technifutur.sudoku.sudo4x4;

import be.technifutur.sudoku.GridModel;

public class GridModel4 implements GridModel
{
    char[][] grid = new char[4][4];
    //public static final Character EMPTY = '0';
    String  format = """
            +-------+-------+
            |  %c  %c  |  %c  %c  |
            |  %c  %c  |  %c  %c  |
            |  %c  %c  |  %c  %c  |
            +-------+-------+
            |  %c  %c  |  %c  %c  |
            |  %c  %c  |  %c  %c  |
            |  %c  %c  |  %c  %c  |
            +-------+-------+
            """;

    @Override
    public void setValue(int i, int j, char val) {
        if (i > 0 && i < 5 && j > 0 && j < 5)
            grid[i - 1][j - 1] = val;
    }

    @Override
    public char getValue(int i, int j) {

        return(grid[i - 1][j - 1]);
    }

    @Override
    public void deleteValue(int i, int j) {
        setValue(i, j, EMPTY);
    }

    @Override
    public Boolean isValidPosition(int i, int j){
        return (false);
    }

    @Override
    public Boolean isValidValue(char c){
        return (false);
    }

    public void fillGrid(char[][] tab)
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
                grid[i][j] = tab[i][j];
        }
    }
}
