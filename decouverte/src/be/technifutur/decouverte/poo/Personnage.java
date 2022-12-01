package be.technifutur.decouverte.poo;

public abstract class Personnage
{
    private final String  nom;

    public Personnage(String nom){
        this.nom = nom;
    }

    public String getName(){
        return (this.nom);
    }

    public abstract void showAffiliation();

    public abstract void fight();

}
