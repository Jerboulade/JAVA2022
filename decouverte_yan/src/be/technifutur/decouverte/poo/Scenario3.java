package be.technifutur.decouverte.poo;

import be.technifutur.decouverte.poo.autre.Millenium;

public class Scenario3 {
    public static void main(String[] args) {
        Millenium v1 = new Millenium();
        Xwing v2 = new Xwing(0);
        VaisseauAncetre v3 = v2;
        //VaisseauAncetre v4  = new VaisseauAncetre(0);
        VaisseauAncetre v4  = new Millenium();
        DeathStar ds = new DeathStar();

        //v1 = v4;
        v4 = v1;

        v1.tirer();
        v2.tirer();
        v1.vitesseLumiere();
        //v2.vitesseLumiere();
        if(v3 instanceof Millenium) {
            ((Millenium)v3).vitesseLumiere();
        }
        v1.afficherCamps();
        v2.afficherCamps();
        v3.afficherCamps();
        v4.afficherCamps();

        System.out.println("----------------------");
        ds.attireVaisseau(v1);
        System.out.println("----------------------");
        ds.attireVaisseau(v2);
        System.out.println("----------------------");
        ds.attireVaisseau(v3);

        System.out.println(v1.toString());
        System.out.println(v1.hashCode());

        Millenium v10 = new Millenium();
        Millenium v11 = new Millenium();
        Xwing v12 = new Xwing(10);

        System.out.println(v10.equals(v11));
        System.out.println(v10.equals(v12));
    }
}
