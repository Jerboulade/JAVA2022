package be.technifutur.decouverte.poo;

public class Soldat extends Rebelle
{
    public Soldat(String nom){
        super(nom);
    }

    @Override
    public void fight(){
        System.out.println("I fight like a soldier!");
    }
}
