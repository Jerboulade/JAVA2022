package be.technifutur.decouverte.poo;

public class VaisseauMethode
{
    // Variables d'instance
    private int         nbRocket;
    private static int          flyingCount;
    final int           maxRocket = 20;
    private boolean     grounded = true;

    // Methode de classe
    public  VaisseauMethode(int nbRocket)
    {
        if (nbRocket >= 0)
            this.nbRocket = nbRocket;
    }
    public VaisseauMethode()
    {
        nbRocket = 5;
    }
    // Methode d'instance
    public void shoot()
    {
        if (nbRocket > 0)
        {
            System.out.println("BAM");
            nbRocket--;
        }
        else
            System.out.println("POUF");
    }

    public void reload(int rocket)
    {
        if (rocket > 0)
            nbRocket += rocket;
        if (rocket > maxRocket)
            nbRocket = maxRocket;
    }

    public int getNbRocket()
    {
        return (nbRocket);
    }

    public void showRocketLeft()
    {
        System.out.printf("%d missile left!\n", nbRocket);
    }

    public void takeOff()
    {
        if (grounded)
        {
            grounded = false;
            System.out.println("Take off successfull!");
            flyingCount++;
        }
        else
            System.out.println("Already flying!");
    }

    // fonction 'land' : pratique
    //    this. ->              variable d'instance
    //    VaisseauMethode. ->   variable de classe
    //    si omis, le compilateur va chisir le bon
    public void land()
    {
        if (!grounded)
        {
            this.grounded = true;
            System.out.println("Landing successfull!");
            VaisseauMethode.flyingCount--;
        }
        else
            System.out.println("Already grounded!");
    }

    public void showState()
    {
        if (grounded)
            System.out.println("Ship is not flying currently");
        else
            System.out.println("Ship is currently flying");
    }

    static public void showFlyingCount()
    {
        System.out.printf("There is currently %d ship(s) flying!\n", VaisseauMethode.flyingCount);
    }
}
