package be.technifutur.decouverte.poo;

public class Scenario3 {
    public static void main(String[] args) {
        Millenium       v1 = new Millenium();
        Xwing           v2 = new Xwing(0);
        VaisseauAncetre v3 = v1;
        Xwing           v4 = new Xwing(0);
        Xwing           v5 = new Xwing(0);
        DeathStar       ds = new DeathStar();

        v1.shoot();
        v1.lightSpeed();
        v2.shoot();
        // v2.lightSpeed(); nope
        v3.showRocketLeft();
        v3 = v2;
        v3.showRocketLeft();
        if (v3 instanceof Millenium){
            ((Millenium)v3).lightSpeed();
        } else {
            System.out.println("Nope, I'm a X-Wing!");
        }
        v1.showAffiliation();
        v2.showAffiliation();
        v3.showAffiliation();
        ds.attractShip(v1);
        ds.attractShip(v2);
        ds.attractShip(v3);

        // Object methods
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3.toString());
        System.out.println(v2.equals(v3));
        System.out.println(v2.equals(v1));
        System.out.println(v4.equals(v5));
        System.out.println(v1.hashCode());
        System.out.println(v2.hashCode());
        System.out.println(v3.hashCode());


    }
}
