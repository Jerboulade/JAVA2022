package be.technifutur.decouverte.poo;

public class DeathStar {

    public void attractShip(VaisseauAncetre v){
        if (v instanceof Millenium)
            attractShip((Millenium) v);
        else if (v instanceof Xwing)
            attractShip((Xwing) v);
        else
        {
            System.out.println("\nDeathStar\n-------------------------------");
            v.land();
            v.showAffiliation();
            v.shoot();
            v.takeOff();
            System.out.println("-------------------------------");
        }
    }

    public void attractShip(Millenium m){
        System.out.println("\nDeathStar\n-------------------------------");
        m.land();
        m.showAffiliation();
        System.out.println("Obi-Wan! Help!");
        m.takeOff();
        m.lightSpeed();
        System.out.println("-------------------------------");

    }

    public void attractShip(Xwing m){
        System.out.println("\nDeathStar\n-------------------------------");
        m.land();
        m.showAffiliation();
        System.out.println("Roger Vaddy!");
        m.takeOff();
        System.out.println("-------------------------------");

    }
}
