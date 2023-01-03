package be.technifutur.decouverte.poo;

public class Clone extends Empire {
    public Clone() {
        this("Clone");
    }

    public Clone(String nom){
        super(nom);
    }

    @Override
    public String combattre() {
        return ("je combat comme Clone");
    }
}
