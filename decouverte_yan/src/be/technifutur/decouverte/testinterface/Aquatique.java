package be.technifutur.decouverte.testinterface;

public interface Aquatique extends Animal{

    @Override
    default String type() {
        return "aquatique";
    }
}
