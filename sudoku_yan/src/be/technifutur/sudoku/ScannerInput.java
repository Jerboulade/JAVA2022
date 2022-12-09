package be.technifutur.sudoku;

import java.util.Scanner;

public class ScannerInput implements Input {

    private Scanner scan = new Scanner(System.in);
    public String read(String message) {
        System.out.print(message);
        return scan.nextLine();
    }


}
