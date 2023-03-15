package be.technifutur.model.canard;

public class Mandarin extends CanardStrategy {
    public Mandarin() {
        super(new VolerAvecDesAiles(), new Coincoin());
    }

    @Override
    public void afficher() {
        System.out.println("Je suis un Mandarin");
    }

    @Override
    public void nager() {
        System.out.println("Plif plif");
    }
}
