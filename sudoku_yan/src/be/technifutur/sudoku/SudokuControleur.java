package be.technifutur.sudoku;

import be.technifutur.sudoku.sudo9x9.SudokuModel9x9;

import java.io.FileNotFoundException;

public interface SudokuControleur {
    void start();
    void init(String path) throws FileNotFoundException, SudokuValueException, SudokuPositionException;
}
