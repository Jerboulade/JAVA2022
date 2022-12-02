package be.technifutur.decouverte.poo;

public class Scenario4
{
    public static void main(String[] args) {
        Personnage[] p = {
                new Soldat("Léon"),
                new Jedi("Luke"),
                new Clone(),
                new Clone("Jango_012"),
                new Sith("Anakin")
        };
        Force force;

        for (Personnage tmp : p)
        {
            System.out.println("--> I'am " + tmp.getName());
            if (tmp instanceof Force) {
                force = (Force) tmp;
                force.useForce();
            }
            tmp.showAffiliation();
            tmp.fight();
        }
    }
}
