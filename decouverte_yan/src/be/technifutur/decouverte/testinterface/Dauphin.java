package be.technifutur.decouverte.testinterface;

public class Dauphin implements Mammifere, Aquatique{
    @Override
    public String identity() {
        return "Flipper";
    }

    @Override
    public String type(){
        return Mammifere.super.type()+ " et "+ Aquatique.super.type();
    }
}
