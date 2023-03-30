package be.technifutur.model.composition;

public class H_Commun {

    private int val = 0;

    public void inc(int nb) {
        val += nb;
    }

    protected int getVal() {
        return val;
    }
}
