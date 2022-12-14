package be.technifutur.sudoku;

import be.technifutur.sudoku.menu.MenuController;
import be.technifutur.sudoku.samurai.GridModelSamurai;
import be.technifutur.sudoku.sudo9x9.GridModel9;
import be.technifutur.sudoku.sudo9x9.GridView9;
import be.technifutur.sudoku.samurai.GridViewSamurai;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        GridModel9 nine_mod = new GridModel9();
        GridView9 nine_view = new GridView9(nine_mod);
        GridModelSamurai sam_mod = new GridModelSamurai();
        GridViewSamurai sam_view = new GridViewSamurai(sam_mod);
        MenuController menu = new MenuController();

        Character[] tab =  {'.','2','.','4','5','6','.','8','9',
                            '.','2','3','4','.','6','7','.','9',
                            '1','.','3','.','5','.','7','8','9',
                            '.','2','.','4','5','6','7','8','.',
                            '.','.','3','4','.','6','.','8','9',
                            '1','2','.','4','5','.','.','.','9',
                            '.','.','.','4','5','.','7','.','9',
                            '1','2','3','.','5','6','7','.','9',
                            '1','2','3','.','.','.','.','k','9'};
        Character[] tabSam = {  '.','2','.','4','5','6','.','8','9', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '.','2','3','4','.','6','7','.','9', '.','2','.','4','5','6','.','8','9','5','6','7',
                                '1','.','3','.','5','.','7','8','9', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '.','2','.','4','5','6','7','8','.', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '.','.','3','4','.','6','.','8','9', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '1','2','.','4','5','.','.','.','9', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '.','.','.','4','5','.','7','.','9', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '1','2','3','.','5','6','7','.','9', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '1','2','3','.','.','.','.','k','9', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '.','2','.','4','5','6','.','8','9', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '.','2','3','4','.','6','7','.','9', '.','2','.','4','5','6','.','8','9','5','6','7',
                                '1','.','3','.','5','.','7','8','9', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '.','2','.','4','5','6','7','8','.', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '.','.','3','4','.','6','.','8','9', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '1','2','.','4','5','.','.','.','9', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '.','.','.','4','5','.','7','.','9', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '1','2','3','.','5','6','7','.','9', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '1','2','3','.','.','.','.','s','9', '1','2','.','4','5','.','.','.','9','5','6','p',
                                '.','.','.','4','5','.','7','.','9', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '1','2','3','.','5','6','7','.','9', '1','2','.','4','5','.','.','.','9','5','6','7',
                                '1','2','3','.','.','.','.','k','9', '1','2','.','4','5','.','.','.','9','5','6','l',

        };
        int     option = 0;
        int     line;
        int     col;
        char     val;
        String  input = null;
        Scanner scan = new Scanner(System.in);

        while (option == 0)
        {
            System.out.println("Enter line index: ");
            try {
                input = scan.nextLine();
                line = Integer.parseInt(input);
            }
            catch (NumberFormatException e)
            {
                System.out.printf("'%s' is not a number\n", input);
                continue;
            }
            catch (NoSuchElementException | IllegalStateException e)
            {
                System.out.println("An error occured");
            }
            option = 1;
        }
        //nine_view.showEmptyGrid();
        //nine_view.showGrid();
        //nine_mod.setValue(2, 2, '1');
        //nine_view.showGrid();
        //nine_mod.fillGrid(tab);
        //nine_view.showGrid();
        //nine_view.showEmptyGrid();
        //nine_view.showGrid();
        //System.out.println(nine_mod.getValue(9, 8));
        //GridViewSamurai sam = new GridViewSamurai();
        //sam_mod.fillGrid(tabSam);
        //sam_view.showGrid();
        //sam_mod.setValue(21, 21, '1');
        //sam_view.showGrid();
        //sam_view.showEmptyGrid();

        //menu.launch();
    }


}
