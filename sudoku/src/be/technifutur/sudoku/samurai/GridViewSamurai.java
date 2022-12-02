package be.technifutur.sudoku.samurai;

import be.technifutur.sudoku.SudokuView;

import java.util.Arrays;

public class GridViewSamurai implements SudokuView
{
    GridModelSamurai mod;
    public GridViewSamurai(GridModelSamurai mod){
       this.mod = mod;
    }
    public void  showGrid() {
        Character[] tmp = new Character[(21 * 21) - (8 * 9)];

        for (int i = 0, j = 0; i < (21 * 21); i++) {
            if (mod.isValidPosition(i / 21, i % 21))
                tmp[j++] = mod.grid[i];
        }
        System.out.println(String.format(mod.format, tmp));
    }
    public void  showEmptyGrid(){
        Character[] tmp = new Character[(21 * 21)-(8 * 9)];

        Arrays.fill(tmp, '.');
        System.out.println(String.format(mod.format, tmp));
    }

}
