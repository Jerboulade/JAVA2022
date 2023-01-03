package be.technifutur.decouverte.poo;

public class Soldat extends Rebelle {
    public Soldat(String nom) {
        super(nom);
    }

    @Override
    public String combattre() {
       return("je combat comme un soldat");
    }
}
