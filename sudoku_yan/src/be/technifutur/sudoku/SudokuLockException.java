package be.technifutur.sudoku;

public class SudokuLockException extends SudokuException {
    private int  line;
    private int col;

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public SudokuLockException() {
    }

    public SudokuLockException(String message) {
        super(message);
    }

    public SudokuLockException(String message, Throwable cause) {
        super(message, cause);
    }

    public SudokuLockException(Throwable cause) {
        super(cause);
    }

    public SudokuLockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
