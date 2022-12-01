package be.technifutur.sudoku.sudo9x9;
import java.util.Arrays;
import java.lang.reflect.Array;

public class GridView9
{
    //char[][] grid= new char[9][9];
    //char[] line

    public void  showGrid(GridModel9 grid)
    {
        for (int i = 0; i < 9; i++)
        {
            if ((i % 3) == 0)
                System.out.printf(" +--------+--------+--------+ \n");
            for (int j = 0; j < 9; j++)
            {
                if ((j % 3) == 0)
                    System.out.printf(" | ");
                if (grid.grid[i][j] == 0 || grid.grid[i][j] == '0')
                    System.out.printf(" .");
                else
                    System.out.printf(" %c", grid.grid[i][j]);
            }
            System.out.printf(" | \n");
        }
        System.out.printf(" +--------+--------+--------+ \n");
    }

    public void  showEmptyGrid(GridModel9 grid)
    {
        Arrays.fill(grid.grid, '.');
        System.out.println(String.format(grid.format, grid.grid));

    }

/*    public void setValue(int i, int j, char val)
    {
        if (i > 1 && i < 10 && j > 1 && j < 10)
            grid[i - 1][j - 1] = val;
    }*/


}
