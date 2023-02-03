package be.technifutur.java.timairport.exception;

public class RessourceNotFoundException extends RuntimeException {

    public RessourceNotFoundException(){
        super("The requested source was not found");
    }

    public RessourceNotFoundException(Throwable cause){
        super("The requested source was not found", cause);
    }

    public RessourceNotFoundException(String message) {
        super(message);
    }
}
