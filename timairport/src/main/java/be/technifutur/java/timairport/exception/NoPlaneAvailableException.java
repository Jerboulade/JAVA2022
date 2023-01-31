package be.technifutur.java.timairport.exception;

public class NoPlaneAvailableException extends RuntimeException{
    public NoPlaneAvailableException() {
        super ("No plane available!");
    }

    public NoPlaneAvailableException(Throwable cause) {
        super("No plane available!", cause);
    }
}
