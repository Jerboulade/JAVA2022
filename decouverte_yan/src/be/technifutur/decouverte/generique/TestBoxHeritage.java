package be.technifutur.decouverte.generique;

import be.technifutur.decouverte.poo.VaisseauAncetre;
import be.technifutur.decouverte.poo.Xwing;
import be.technifutur.decouverte.poo.autre.Millenium;

public class TestBoxHeritage {

    public static void main(String[] args) {
        Millenium millenium = new Millenium();
        Box<VaisseauAncetre> vaisseauAncetreBox = new Box<>(millenium);

        // Millenium v1 = boitevaisseauAncetreBox.getValue();

        Box<Millenium> milleniumBox = new Box<>(new Millenium());


        // boite de vaisseau ancêtre est une boite de millenium ?
        // milleniumBox = boitevaisseauAncetreBox;

        // boite de millenium est une boite de vaisseau ancêtre ?
        // boitevaisseauAncetreBox = milleniumBox;

        vaisseauAncetreBox.setValue(new Xwing(2));

        utiliseBoiteVaisseau1(vaisseauAncetreBox);
        //utiliseBoiteVaisseau1(milleniumBox);

        //utiliseBoiteVaisseau2(vaisseauAncetreBox);
        utiliseBoiteVaisseau2(milleniumBox);

        utiliseBoiteVaisseau3(vaisseauAncetreBox);
        utiliseBoiteVaisseau3(milleniumBox);

        Millenium m = test(millenium);
        //Millenium m2 = test(new Xwing(2));
    }

    static void utiliseBoiteVaisseau1(Box<VaisseauAncetre> box) {
        box.getValue().tirer();
        //box.getValue().vitesseLumiere();
        Millenium mi = new Millenium();
        box.setValue(mi);
        Xwing xwing = new Xwing(3);
        box.setValue(xwing);
    }

    static void utiliseBoiteVaisseau2(Box<Millenium> box) {
        box.getValue().tirer();
        box.getValue().vitesseLumiere();
        box.setValue(new Millenium());
        //box.setValue(new Xwing(3));
    }

    static void utiliseBoiteVaisseau3(Box<? extends VaisseauAncetre> box) {
        box.getValue().tirer();
        //box.getValue().vitesseLumiere();
        //box.setValue(new Millenium());
        //box.setValue(new Xwing(3));
    }

    static void remplirBoite1(Millenium millenium, Box<Millenium> boite){
        if(!millenium.isEnVol()){
            boite.setValue(millenium);
        }
    }

    static void remplirBoite2(Millenium millenium, Box<VaisseauAncetre> boite){
        if(!millenium.isEnVol()){
            boite.setValue(millenium);
        }
    }

    static void remplirBoite3(Millenium millenium, Box<Object> boite){
        if(!millenium.isEnVol()){
            boite.setValue(millenium);
        }
    }

    static void remplirBoite4(Millenium millenium, Box<String> boite){
        if(!millenium.isEnVol()){
            //boite.setValue(millenium);
        }
    }

    static void remplirBoite(Millenium millenium, Box<? super Millenium> boite){
        if(!millenium.isEnVol()){
            boite.setValue(millenium);
        }
    }

    static <E extends VaisseauAncetre> E test(E monVaisseau){
        monVaisseau.tirer();
        return monVaisseau;
    }
}
