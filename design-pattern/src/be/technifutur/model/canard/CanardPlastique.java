package be.technifutur.model.canard;

public class CanardPlastique extends CanardStrategy {


    public CanardPlastique() {
        super(new NePasVoler(), new Muted());
    }

    @Override
    public void afficher() {
        System.out.println("Je suis un canard en plastique");
    }

    @Override
    public void nager() {
        System.out.println("Je ne nage pas, je flotte");
    }
}
