package be.technifutur.decouverte.poo;

import java.util.Objects;

public abstract class VaisseauAncetre {
    // variables de classes
    private static int nbEnvol = 0;
    // variables d'instances
    protected int nbMisille = 5;
    private boolean enVol =false;

    private String name = "test";

    // constructeur
    public VaisseauAncetre(int nbMisille) {
        if(nbMisille>=0) {
            this.nbMisille = nbMisille;
        }
    }

    // accesseur
    public boolean isEnVol(){
        return enVol;
    }
    public abstract void afficherCamps();

    // méthodes d'instances
    public void tirer(){
        if(this.nbMisille > 0){
            System.out.println("PAN");
            this.nbMisille =this.nbMisille - 1;
        }else{
            System.out.println("POUF");
        }
    }

    // accesseur en lecture
    public int getNbMissiles() {
        return nbMisille;
    }

    public void addMissiles(int nbMissile) {
        if(this.nbMisille + nbMissile >=0){
            this.nbMisille += nbMissile;
        }
    }

    public void decoller() {
        if(! enVol) {
            System.out.println("je décolle");
            enVol = true;
            VaisseauAncetre.nbEnvol++;
        }else{
            System.out.println("je suis déjà en vol");
        }
    }

    public void atterrir() {
        if(enVol) {
            System.out.println("me voila au sol");
            enVol = false;
            VaisseauAncetre.nbEnvol--;
        }else {
            System.out.println("je suis déjà au sol");
        }
    }

    @Override
    public String toString() {
        return "VaisseauAncetre{" +
                "nbMisille=" + nbMisille +
                ", enVol=" + enVol +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VaisseauAncetre that = (VaisseauAncetre) o;

        if (nbMisille != that.nbMisille) return false;
        if (enVol != that.enVol) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = nbMisille;
        result = 31 * result + (enVol ? 1 : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
