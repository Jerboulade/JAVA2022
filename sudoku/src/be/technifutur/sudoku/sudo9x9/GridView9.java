package be.technifutur.sudoku.sudo9x9;
import be.technifutur.sudoku.SudokuView;

import java.util.Arrays;
import java.lang.reflect.Array;

public class GridView9 implements SudokuView
{
    //char[][] grid= new char[9][9];
    //char[] line
    GridModel9 mod;

    public GridView9(GridModel9 mod){
        this.mod = mod;
    }
    public void  showGrid()
    {
        System.out.println(String.format(mod.format, mod.grid));
    }

    public void  showEmptyGrid()
    {
        Character[] tmp = new Character[81];

        Arrays.fill(tmp, '.');
        System.out.println(String.format(mod.format, tmp));
    }

/*    public void setValue(int i, int j, char val)
    {
        if (i > 1 && i < 10 && j > 1 && j < 10)
            grid[i - 1][j - 1] = val;
    }*/


}
