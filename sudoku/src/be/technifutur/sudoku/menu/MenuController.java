package be.technifutur.sudoku.menu;

import java.util.Scanner;

public class MenuController
{
    public int option = 0;
    MenuModel menu_mod = new MenuModel();
    MenuView menu_view = new MenuView();

    public void launch(){
        menu_view.show(menu_mod.menu[option]);
        do
            menuLoop();
        while (option != 5);
        System.out.println("Bye!");
    }

    public void menuLoop(){
        Scanner scan = new Scanner(System.in);
        int     input;

        System.out.printf("Choose option: ");
        option = scan.nextInt();

    }


}
