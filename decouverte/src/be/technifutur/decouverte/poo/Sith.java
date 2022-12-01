package be.technifutur.decouverte.poo;

public class Sith extends Empire implements Force
{
    public Sith(String nom){
        super(nom);
    }

    @Override
    public void fight(){
        System.out.println("I fight like a Sith!");
    }

    @Override
    public void useForce(){
        System.out.println("I use the dark side of The Force");
    }
}
