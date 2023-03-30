package be.technifutur.model.composition;

public class C_ChildTwo {
    private H_Commun common = new H_Commun();

    public void inc(int nb) {
        common.inc(nb);
    }

    public int getVal() {
        return common.getVal();
    }

    public int next() {
        inc(2);
        return getVal();
    }
}