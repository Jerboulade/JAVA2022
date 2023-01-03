package be.technifutur.decouverte.testinterface;

/**
 * Interface ancêtre
 */
@FunctionalInterface
public interface Animal {

    /**
     * méthode abstraite à redéfinir dans les descendants.
     *
     * @return
     */
    public abstract String identity();

    /**
     * méthode par défaut
     * @return
     */
    public default String type() {

        return "Animal : "+this.identity();
    }

    default String UnPetitMot(){
        return "Un petit mot";
    }

    /**
     * méthode de classe
     * @return
     */
    static String methodeStatic(){
        return "code static";
    }

}
