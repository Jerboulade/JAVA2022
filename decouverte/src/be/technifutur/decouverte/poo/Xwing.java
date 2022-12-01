package be.technifutur.decouverte.poo;

public class Xwing extends VaisseauAncetre
{
    public Xwing(int nbRocket)
    {
        super(nbRocket);
    }

    @Override
    public void showAffiliation(){
        System.out.println("I belong to the Empire");
    }
}
