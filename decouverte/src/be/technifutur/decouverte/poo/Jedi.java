package be.technifutur.decouverte.poo;

public class Jedi extends Rebelle implements Force
{
    public Jedi(String nom){
        super(nom);
    }

    @Override
    public void fight(){
        System.out.println("I fight like a Jedi!");
    }

    @Override
    public void useForce(){
        System.out.println("I use the light side of The Force");
    }
}
