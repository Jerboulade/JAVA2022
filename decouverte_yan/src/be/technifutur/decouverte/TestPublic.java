package be.technifutur.decouverte;

import be.technifutur.decouverte.poo.VaisseauStructure;

public class TestPublic {

    public static void main(String[] args) {
        VaisseauStructure v1 = new VaisseauStructure();
        VaisseauStructure v2 = new VaisseauStructure();

        //v1.pilote = "Luc";   //'pilote' is not public in 'be.technifutur.decouverte.poo.Vaisseau'. Cannot be accessed from outside package
        v1.nom = "Xwing";
        //v2.pilote = "Darkvador"; //'pilote' is not public in 'be.technifutur.decouverte.poo.Vaisseau'. Cannot be accessed from outside pa
        v2.nom = "Millenium";

    }
}
