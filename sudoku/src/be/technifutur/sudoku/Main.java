package be.technifutur.sudoku;

import be.technifutur.sudoku.menu.MenuController;
import be.technifutur.sudoku.sudo9x9.GridModel9;
import be.technifutur.sudoku.sudo9x9.GridView9;
import be.technifutur.sudoku.samurai.GridViewSamurai;

public class Main
{
    public static void main(String[] args)
    {
        GridView9 view = new GridView9();
        GridModel9 mod = new GridModel9();
        MenuController menu = new MenuController();

        char[][] tab = {{0,'2', 0,'4','5','6', 0,'8','9'},
                {0,'2','3','4', 0,'6','7', 0,'9'},
                {'1',0,'3',0,'5',0,'7','8','9'},
                {0,'2',0,'4','5','6','7','8',0},
                {0,0,'3','4',0,'6',0,'8','9'},
                {'1','2',0,'4','5', 0, 0, 0,'9'},
                {0, 0, 0,'4','5', 0,'7', 0,'9'},
                {'1','2','3',0,'5','6','7', 0,'9'},
                {'1','2','3', 0, 0, 0, 0,'k','9'}};
        view.showEmptyGrid(mod);
        view.showGrid(mod);
        mod.setValue(2, 2, '1');
        view.showGrid(mod);
        mod.fillGrid(tab);
        view.showGrid(mod);
        System.out.println(mod.getValue(9, 8));
        GridViewSamurai sam = new GridViewSamurai();
        sam.showGrid();

        menu.launch();
    }


}
