package be.technifutur.sudoku.sudo4x4;

import be.technifutur.sudoku.SudokuModel;
import be.technifutur.sudoku.SudokuView;
import be.technifutur.sudoku.sudo9x9.GridModel9;

import java.util.Arrays;

public class GridView4 implements SudokuView {
    GridModel4 mod;

    public GridView4(GridModel4 mod){
        this.mod = mod;
    }
    public void  showGrid()
    {
        System.out.println(String.format(mod.format, mod.grid));
    }

    public void  showEmptyGrid()
    {
        Character[] tmp = new Character[16];

        Arrays.fill(tmp, '.');
        System.out.println(String.format(mod.format, tmp));
    }
}
