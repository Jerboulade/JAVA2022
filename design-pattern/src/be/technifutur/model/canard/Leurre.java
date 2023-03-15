package be.technifutur.model.canard;

public class Leurre extends CanardStrategy {

    public Leurre() {
        super(new NePasVoler(), new Muted());
    }
    @Override
    public void afficher() {
        System.out.println("Je suis un Leurre");
    }

    @Override
    public void nager() {
        System.out.println("Je coule");

    }
}
