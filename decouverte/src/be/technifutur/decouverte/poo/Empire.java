package be.technifutur.decouverte.poo;

public abstract class Empire extends Personnage
{
    public Empire(String nom){
        super(nom);
    }
    public void showAffiliation(){
        System.out.println("I belong to the Empire");
    }

    public abstract void fight();
}
