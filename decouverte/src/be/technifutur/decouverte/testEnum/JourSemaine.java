package be.technifutur.decouverte.testEnum;

public enum JourSemaine {
    LUNDI("null"), MARDI("null"), MERCREDI("null"), JEUDI("null"), VENDREDI("null"), SAMEDI("cool"), DIMANCHE("cool");

    public String message;

    private JourSemaine(String message){
        this.message = message;
    }

    public String getMessage(){
        return (message);
    }
}
