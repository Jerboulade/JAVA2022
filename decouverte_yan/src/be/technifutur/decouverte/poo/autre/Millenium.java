package be.technifutur.decouverte.poo.autre;

import be.technifutur.decouverte.poo.VaisseauAncetre;

public class Millenium extends VaisseauAncetre {

    public Millenium(){
        super(10);
    }

    public void vitesseLumiere(){
        System.out.println("je passe à la vitesse lumière");
    }

    @Override
    public void afficherCamps() {
        System.out.println("je suis un Vaisseau rebelle");
    }

    @Override
    public void tirer(){
        super.tirer();
        if(this.nbMisille > 0) {
            super.tirer();
        }
    }

    @Override
    public String toString(){
        return "Millenium{ nbMisille:"+ nbMisille+", enVol:"+ isEnVol()+"}";
    }

}
