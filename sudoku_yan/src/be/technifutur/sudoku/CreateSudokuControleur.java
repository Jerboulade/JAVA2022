package be.technifutur.sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateSudokuControleur implements SudokuControleur {
    private final SudokuModel sudoku;
    private final SudokuVue vue;
    private       Queue<HistoryItem> history = new LinkedList<>();
    private final Input input;

    private Pattern pattern = Pattern.compile("([1-9][0-9]*)\\.([1-9][0-9]*)(\\..)?");

    public CreateSudokuControleur(SudokuModel sudoku, SudokuVue vue, Input input) {
        this.sudoku = sudoku;
        this.vue = vue;
        this.input = input;
    }

    public CreateSudokuControleur(SudokuModel sudoku, SudokuVue vue) {
        this(sudoku, vue, new ScannerInput());
    }

    public void start() {
        vue.afficherGrille();
        String request = input.read("Modififier (lig.col.valeur), supprimer (lig.col), quitter (q) :");
        while (!request.equalsIgnoreCase("q")) {
            Matcher matcher = pattern.matcher(request);
            if (matcher.matches()) {
                int lig = Integer.parseInt(matcher.group(1)) - 1;
                int col = Integer.parseInt(matcher.group(2)) - 1;
                String value = matcher.group(3);
                try {
                    if (value != null) {
                        char val = value.charAt(1);
                        sudoku.setValue(lig, col, val);
                    } else {
                        sudoku.deleteValue(lig, col);
                    }
                } catch (SudokuLockException e) {
                    vue.setMessage("Cell ["+(e.getLine()+1)+"]"+"["+(e.getCol()+1)+"] is locked");
                } catch (SudokuException e) {
                    vue.setMessage(e.getMessage());
                }

            } else {
                vue.setMessage("entrée non valide");
            }
            vue.afficherGrille();
            request = input.read("Modififier (lig.col.valeur), supprimer (lig.col), quitter (q) :");
        }
    }

    public void init(String path) throws FileNotFoundException, SudokuException{
        File file = new File(path);

        try (Scanner scan = new Scanner(file)) {
            //while (scan.hasNext())
            //    System.out.println(scan.nextLine());
            this.parseFile(scan);
        }
    }

    public void parseFile(Scanner scan) throws SudokuException {
        int li = 0;

        try {
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String[] tab = line.split(",");
                for (int col = 0; col < sudoku.getMaxSize(); col++) {
                    char val = tab[col].charAt(0);
                    //if (s.length() > 1) --> throw 'SudokuException'
                    if (sudoku.isValueValid(val))
                        sudoku.setValue(li, col++, val);
                }
                li++;
            }
            sudoku.lockGrid();
        }
        catch (SudokuException e){
            throw (new RuntimeException(e));
        }
    }
}
