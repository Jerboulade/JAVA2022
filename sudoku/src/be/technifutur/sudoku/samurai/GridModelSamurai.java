package be.technifutur.sudoku.samurai;

import be.technifutur.sudoku.SudokuModel;

import java.util.Arrays;

public class GridModelSamurai implements SudokuModel {
    Character[]    grid = new Character[(21 * 21)];
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

    public GridModelSamurai(){
        Arrays.fill(grid, '.');
    }

    @Override
    public void setValue(int i, int j, char val){
        i--;
        j--;
        if (isValidPosition(i, j) && isValidValue(val))
            grid[(i * 21) + j] = val;
    }

    @Override
    public char getValue(int i, int j) {
        i--;
        j--;
        return(isValidPosition(i, j) ? grid[(i * 21) + j] : 0);
    }

    @Override
    public void deleteValue(int i, int j) {
        setValue(i, j, EMPTY);
    }

    @Override
    public Boolean isValidPosition(int i, int j){

        //System.out.printf("i = %d, j = %d\n", i, j);
        return (!((((i >= 0 && i <= 5) || (i >= 15 && i <= 20)) && (j >= 9 && j <= 11)) ||
                ((i >= 9 && i <= 11) && ((j >= 0 && j <= 5) || (j >= 15 && j <= 20)))));
    }

    @Override
    public Boolean isValidValue(char c){

        return ((c >= '1' && c <= '9') || c == EMPTY);
    }

    public void fillGrid(Character[] tab)
    {
        for (int i = 0; i < (21 * 21); i++)
            grid[i]= tab[i];
    }


}
