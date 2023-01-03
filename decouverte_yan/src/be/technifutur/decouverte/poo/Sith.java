package be.technifutur.decouverte.poo;

public class Sith extends Empire implements Force{
    public Sith(String nom  ) {
        super(nom);
    }

    @Override
    public String combattre() {
        return "Je combat comme un Sith";
    }

    @Override
    public void utiliserForce() {
        System.out.println("j'utilise le coté obscure de la force");
    }
}
