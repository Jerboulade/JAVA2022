package be.technifutur.decouverte.poo;

public abstract class Personnage {
    private final String nom;

    public Personnage(String nom) {
        this.nom = nom;
    }
    
    public String getNom(){
        return nom;
    }

    public abstract void afficheCamps();

    public abstract String combattre();

    public abstract boolean getCamp() ;
}
