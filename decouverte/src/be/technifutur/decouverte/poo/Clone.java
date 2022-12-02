package be.technifutur.decouverte.poo;

public class Clone extends Empire
{
    public Clone(){
        this("Clone");
    }
    public Clone(String nom){
        super(nom);
    }

    @Override
    public void fight() {
        System.out.println("I fight like a clone!");
    }
}
