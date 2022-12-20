package be.technifutur.sudoku;

import java.math.BigInteger;
import java.util.*;

public abstract class AbstractSudokuModel implements SudokuModel {

    private Cell[][] grille;
    //public Queue<BigInteger> history = new LinkedList<>();

    public AbstractSudokuModel(Cell[][] grille){
        this.grille = grille;
    }

    public char getValue(int lig, int col) throws SudokuPositionException {
        testPosition(lig, col);
        return this.grille[lig][col].getValue();
    }

    private void testPosition(int lig, int col) throws SudokuPositionException {
        if (!isPositionValid(lig, col)) {
            throw new SudokuPositionException(String.format("la position %s, %s n'est pas valide", lig, col));
        }
    }

    public abstract boolean isPositionValid(int lig, int col);

    public void setValue(int lig, int col, char value) throws SudokuException {
        testPosition(lig, col);
        testValue(value);
        try {
            this.grille[lig][col].setValue(value);
        }
        catch (SudokuLockException e){
            e.setCol(col);
            e.setLine(lig);
            throw e;
        }
    }

    private void testValue(char value) throws SudokuValueException {
        if (!isValueValid(value)) {
            throw new SudokuValueException(String.format("la valeur %s n'est pas valide", value));
        }
    }

    public int getMaxSize() {
        return this.grille.length;
    }

    public void deleteValue(int lig, int col) throws SudokuException {
        testPosition(lig, col);
        grille[lig][col].clear();
    }

    public abstract boolean isValueValid(char value);

    @Override
    public void lockGrid()
    {
        for (Cell[] line : grille){
            for (Cell cell : line)
                cell.lock();
        }
    }

    public Optional<BigInteger> getMemento(){
        //BigInteger bi = new BigInteger("0");

        return Arrays.stream(grille)
                .flatMap(map -> Arrays.stream(map))
                .filter(cell -> !cell.isLock())
                .map(cell -> new BigInteger(cell.isEmpty() ? "0" : String.valueOf(cell.getValue())))
                .reduce((prev, current) -> prev.shiftLeft(4).add(current));
        /*
        for (Cell[] c_tab : grille)
        {
            for (Cell c : c_tab)
            {
                if (!c.isLock())
                    bi.shiftLeft(4).add(new BigInteger(String.valueOf(c.getValue())));
            }
        }
        */
    }

    public void setMemento(BigInteger bi){
        int length = grille.length;
        Character[] grid = new Character[length];

        //while (--length != 0)
            //grid[length] =

    }
}
