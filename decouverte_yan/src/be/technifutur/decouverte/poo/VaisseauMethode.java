package be.technifutur.decouverte.poo;

public class VaisseauMethode {
    // variables de classes
    private static int nbEnvol = 0;
    // variables d'instances
    private int nbMisille = 5;
    private boolean enVol =false;

    // constructeur
    public VaisseauMethode(int nbMisille) {
        if(nbMisille>=0) {
            this.nbMisille = nbMisille;
        }
    }

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
            VaisseauMethode.nbEnvol++;
        }else{
            System.out.println("je suis déjà en vol");
        }
    }

    public void atterrir() {
        if(enVol) {
            System.out.println("me voila au sol");
            enVol = false;
            VaisseauMethode.nbEnvol--;
        }else {
            System.out.println("je suis déjà au sol");
        }
    }
}
