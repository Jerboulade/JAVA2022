package be.technifutur.decouverte.poo;

public class Scenario2
{
    public static void main(String[] args)
    {
        VaisseauMethode v1 = new VaisseauMethode();
        VaisseauMethode v2 = new VaisseauMethode(13);

        v1.shoot();
        v1.shoot();
        v1.shoot();
        v1.shoot();
        v1.shoot();
        v1.shoot();
        v1.shoot();
        v1.shoot();
        v1.showRocketLeft();
        v1.reload(-100);
        v1.showRocketLeft();
        v1.reload(100);
        v1.showRocketLeft();
        v1.land();
        v1.takeOff();
        v1.showState();
        v1.takeOff();
        VaisseauMethode.showFlyingCount();
        v2.takeOff();
        VaisseauMethode.showFlyingCount();
        v1.land();
        v1.showFlyingCount();
        v1.showState();
        v2.showRocketLeft();
    }
}
