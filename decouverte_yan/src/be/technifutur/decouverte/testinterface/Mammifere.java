package be.technifutur.decouverte.testinterface;

@FunctionalInterface
public interface Mammifere extends Animal{


    @Override
    default String type(){
        return "Mammifère";
    }
}
