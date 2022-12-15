package be.technifutur.sudoku;

import java.util.*;

public abstract class AbstractSudokuModel implements SudokuModel {

    private Cell[][] grille;
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
}
