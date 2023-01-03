package be.technifutur.decouverte.poo;

public class Xwing extends VaisseauAncetre{

    public Xwing(int nbMisille) {
        super(nbMisille);
    }

    @Override
    public void afficherCamps() {
        System.out.println("je suis un vaisseau de l'empire");
    }
}
