package be.technifutur.decouverte.generique;

import be.technifutur.decouverte.poo.VaisseauMethode;

public class TestBox {
    public static void main(String[] args) {
        Box<VaisseauMethode> box = new Box<>(new VaisseauMethode(11));
        VaisseauMethode boxValue = box.getValue();
        Box box1 = new Box(boxValue);
        Box<String> box2 = new Box<>("coucou");
        boxValue.showRocketLeft();

        String box2Value =  (String)box2.getValue().toString(); // if box1 value is "coucou" and if not cast, getValue will return an Object--> ast  or .toString()

        System.out.println(box2Value);
        useBox(box);
        useBox(box);
        //useBox(box2); won't compile because useBox takes <VaisseauMethode> as generic but box2 as <String> ----> if box1 is used (no generic assigned) it will compile but raise un exeception error

        }

        static void useBox(Box<VaisseauMethode> box){
            box.getValue().shoot();
        }
}
