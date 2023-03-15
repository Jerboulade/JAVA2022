package be.technifutur.model.canard;

public class Colvert extends CanardStrategy {

    public Colvert() {
        super(new VolerAvecDesAiles(), new Cancan());
    }

    @Override
    public void afficher() {
        System.out.println("Je suis un Colvert");
    }

    @Override
    public void nager() {
        System.out.println("Plouf plouf");

    }
}
