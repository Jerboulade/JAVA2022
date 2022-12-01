package be.technifutur.sudoku.menu;

public class MenuView {
    public void show(String[] tab){
        for (int i = 0; i < tab.length; i++)
            System.out.printf("%2d: %s\n", i, tab[i]);
    }
}
