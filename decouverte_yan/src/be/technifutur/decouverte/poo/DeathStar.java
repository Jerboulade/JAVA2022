package be.technifutur.decouverte.poo;

import be.technifutur.decouverte.poo.autre.Millenium;

public class DeathStar {

    public void attireVaisseau(VaisseauAncetre v){
        if(v instanceof Millenium){
            this.attireVaisseau( (Millenium)v);
        } else if (v instanceof Xwing x) {
            attireVaisseau(x);
        } else {
            System.out.println("DeathStar.attireVaisseau");
            v.atterrir();
            v.afficherCamps();
            v.tirer();
            v.decoller();
        }
    }

    public void attireVaisseau(Millenium m){
        m.atterrir();
        m.afficherCamps();
        System.out.println("A l'aide Obiwan");
        m.decoller();
        m.vitesseLumiere();
    }

    public void attireVaisseau(Xwing m){
        m.atterrir();
        m.afficherCamps();
        System.out.println("A vos ordres Darkvador");
        m.decoller();
     }
}
