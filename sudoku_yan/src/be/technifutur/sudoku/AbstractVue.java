package be.technifutur.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractVue implements SudokuVue{
    private String format;
    private SudokuModel model;

    public AbstractVue(String format, SudokuModel model) {
        this.format = format;
        this.model = model;
    }

    public void afficherGrille() {
        afficherGrille(model);
        if(message != null){
            System.out.println(message);
            message = null;
        }
    }

    private String message;
    public void setMessage(String message) {
        this.message = message;
    }

    public void afficherGrille(SudokuModel model) {
        int nbValue = model.getNbvalues();
        int size = model.getMaxSize();

        //Character[] vect = new Character[nbValue];
        List<Character> vect= new ArrayList<>();

        int pos=0;
         for (int lig = 0; lig < size; lig++) {
            for (int col = 0; col < size; col++) {
                if (model.isPositionValid(lig, col)) {
                    try {
                        vect.add(model.getValue(lig, col) == SudokuModel.EMPTY ? '.' : model.getValue(lig, col));
                        /*if (model.getValue(lig, col) == SudokuModel.EMPTY) {
                            //vect[pos++] = '.';
                            vect.add('.');
                        } else {
                            //vect[pos++] = model.getValue(lig, col);
                            vect.add(model.getValue(lig, col));
                        }*/
                    } catch (SudokuPositionException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
         afficherVecteur(vect);
         //for (Character c : listChar)
             //System.out.println("--> " + c);
    }
    private void afficherVecteur(List<Character> vect) {
        System.out.printf(this.format, vect.toArray());
    }

}
