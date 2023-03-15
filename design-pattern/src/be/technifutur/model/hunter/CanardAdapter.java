package be.technifutur.model.hunter;

import be.technifutur.model.canard.CanardStrategy;

public class CanardAdapter implements Animal{
    private CanardStrategy canard;

    public CanardAdapter(CanardStrategy canard) {
        this.canard = canard;
    }

    @Override
    public void scream() {
        canard.effectuerCanCan();
    }

    @Override
    public void flee() {
        canard.effectuerVol();
    }

    @Override
    public void show() {
        canard.afficher();
    }

}
