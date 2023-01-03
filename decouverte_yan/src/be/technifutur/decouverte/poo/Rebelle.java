package be.technifutur.decouverte.poo;

public abstract class Rebelle extends Personnage {
    public Rebelle(String nom) {
        super(nom);
    }

    @Override
    public void afficheCamps() {
        System.out.println("je suis un rebelle");
    }

    @Override
    public boolean getCamp() {
        return false;
    }
}
