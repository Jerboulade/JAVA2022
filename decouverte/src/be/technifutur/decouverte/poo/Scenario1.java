package be.technifutur.decouverte.poo;

public class Scenario1
{
    public static void main(String[] args)
    {
        VaisseauStructure v1 = new VaisseauStructure();
        VaisseauStructure v2 = new VaisseauStructure();
        VaisseauStructure v3 = v1;

        v1.pilote = "Luke";
        v1.name = "XWing";
        v2.pilote = "Dark Vador";
        v2.name = "TFighter";

        System.out.println(v1.name);
        System.out.println(v2.name);
        v1.name = "Millenium";
        System.out.println(v3.name);

    }
}
