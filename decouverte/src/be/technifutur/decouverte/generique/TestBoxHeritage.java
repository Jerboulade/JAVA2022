package be.technifutur.decouverte.generique;

import be.technifutur.decouverte.poo.Millenium;
import be.technifutur.decouverte.poo.VaisseauAncetre;
import be.technifutur.decouverte.poo.Xwing;

public class TestBoxHeritage {
    public static void main(String[] args) {
        Box<VaisseauAncetre> boxShipAncestor = new Box<>(new Millenium());
        //Millenium ship1 = boxShipAncestor.getValue(); // won't work because boxShip will return a VaisseauAncetre
        Box<Millenium> boxShipMill = new Box<>(new Millenium());

        //is boxShipAncestor is a box of Millenium
        //boxShipMill = boxShipAncestor; // nope
        //is boxShipMill is a box of VaisseauAncetre;
        //boxShipAncestor = boxShipMill; // nope

        useBoxAncestor(boxShipAncestor);
        // useBoxAncestor(boxShipMill); // won't compile

        useBoxMill(boxShipMill);
        // useBoxMill(boxShipAncestor); // won't compile

        useBoxTinkiete(boxShipMill);
        useBoxTinkiete(boxShipMill);

        Millenium m = test(new Millenium());
        // m = test(new Xwing(3)); won't compile because test will return a Xwing

    }
    static void useBoxAncestor(Box<VaisseauAncetre> boxAncestor)
    {
        boxAncestor.getValue().shoot();
        // boxAncestor.getValue().lightSpeed(); //  won't compile...lightspeed is child method
        boxAncestor.setValue(new Millenium());
        boxAncestor.setValue(new Xwing(3));
    }

    static void useBoxMill(Box<Millenium> boxMill)
    {
        boxMill.getValue().shoot();
        boxMill.getValue().lightSpeed();
        boxMill.setValue(new Millenium());
        // boxMill.setValue(new Xwing(3)); // Xwing != Millenium
    }

    static void useBoxTinkiete(Box<? extends VaisseauAncetre> boxTinkiete)
    {
        boxTinkiete.getValue().shoot(); // every ancestor can shoot
        // boxTinkiete.getValue().lightSpeed(); // won't compile...lightspeed is child method...only Millenium has it
        // boxTinkiete.setValue(new Millenium()); // won't compile... the method has no permission to set the value of a box without knowing its exact type it receive
        // boxTinkiete.setValue(new Xwing(3)); // idem

    }

    static void fillBox(Millenium mill, Box<? super Millenium> boBox){ // soit Millenium, soit Ancetre
        if (mill.getNbRocket() != 0)
            boBox.setValue((mill));
    }

    static void fillBox1(Millenium mill, Box<Millenium> boBox){
        if (mill.getNbRocket() != 0)
            boBox.setValue((mill));
    }

    static void fillBox2(Millenium mill, Box<VaisseauAncetre> boBox){
        if (mill.getNbRocket() != 0)
            boBox.setValue((mill));
    }

    static void fillBox3(Millenium mill, Box<Object> boBox){
        if (mill.getNbRocket() != 0)
            boBox.setValue((mill));
    }

    static void fillBox4(Millenium mill, Box<String> boBox){
        if (mill.getNbRocket() != 0){
            //boBox.setValue((mill));
        }
    }

    static <E extends VaisseauAncetre> E test(E ship){ // contrainte sur E qui doit extends VaisseauAncetre --> va accepter/return n'importe quel type qui extends VaisseauAncetre
        ship.shoot(); // si on enleve extension de E, marchera pas
        return (ship);
    }
}
