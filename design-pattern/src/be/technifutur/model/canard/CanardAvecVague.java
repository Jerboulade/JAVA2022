package be.technifutur.model.canard;

public class CanardAvecVague implements Canard{
    private final Canard canard;

    public CanardAvecVague(Canard canard) {
        this.canard = canard;
    }

    @Override
    public void afficher() {
        System.out.print(" o< [ ");
        canard.afficher();
        System.out.println(" ]\n()\n~~~~~~~~~~~~~~" );
    }

    @Override
    public void nager() {
        canard.nager();
    }

    @Override
    public void effectuerCanCan() {
        canard.effectuerCanCan();
    }

    @Override
    public void effectuerVol() {
        canard.effectuerVol();
    }
}
