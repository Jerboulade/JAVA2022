package be.technifutur.decouverte.poo;

public abstract class Rebelle extends Personnage
{

    public Rebelle(String nom){
        super(nom);
    }

    public void showAffiliation(){
        System.out.println("I belong to the Rebellion");
    }

    public abstract void fight();
}
