package be.technifutur.decouverte.poo;

public abstract class Empire extends Personnage {
    public Empire(String nom) {
        super(nom);
    }

    @Override
    public void afficheCamps() {
        System.out.println("Je suis fidèle à l'empire");
    }

    @Override
    public boolean getCamp() {
        return true;
    }


}
