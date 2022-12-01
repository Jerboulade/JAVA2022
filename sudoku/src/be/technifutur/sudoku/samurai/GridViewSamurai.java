package be.technifutur.sudoku.samurai;

import java.util.Arrays;

public class GridViewSamurai
{
    Character[]    grid = new Character[(21 * 21) - (8 * 9)];
    String      format =    """
                            +----------+----------+----------+          +----------+-----------+---------+
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |          |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |          |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |          |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            +----------+----------+----------+          +----------+-----------+---------+
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |          |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |          |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |          |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            +----------+----------+----------+----------+----------+----------+----------+
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            +----------+----------+----------+----------+----------+----------+----------+
                                                  |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |              
                                                  |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |              
                                                  |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |              
                            +----------+----------+----------+----------+----------+----------+----------+
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            +----------+----------+----------+----------+----------+----------+----------+
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |          |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |          |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |          |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            +----------+----------+----------+          +----------+-----------+---------+
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |          |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |          |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |          |  %c  %c  %c |  %c  %c  %c |  %c  %c  %c |
                            +----------+----------+----------+          +----------+-----------+---------+
                            """;
    //char[] line

    public void  showGrid()
    {
        Arrays.fill(grid, '.');
        System.out.println(String.format(format, grid));
    }

    /*public void putValue(int i, int j, char val)
    {
        if (i > 1 && i < 10 && j > 1 && j < 10)
            grid[i - 1][j - 1] = val;
    }

    public void fillGrid(char[][] tab)
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
                grid[i][j] = tab[i][j];
        }
    }*/
}
