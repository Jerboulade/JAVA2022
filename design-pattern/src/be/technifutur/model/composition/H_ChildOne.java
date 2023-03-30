package be.technifutur.model.composition;

public class H_ChildOne extends H_Commun {
//class qui incrémente de 1
    public int next() {
        inc(1);
        return getVal();
    }
}
