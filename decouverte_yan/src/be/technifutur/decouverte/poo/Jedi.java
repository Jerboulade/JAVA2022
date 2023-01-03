package be.technifutur.decouverte.poo;

public class Jedi extends Rebelle implements Force{
    public Jedi(String nom) {
        super(nom);
    }

    @Override
    public String combattre() {
        return("je combat comme un Jedi");
    }

    @Override
    public void utiliserForce() {
        System.out.println("j'utilise le bon coté de la force");
    }
}
