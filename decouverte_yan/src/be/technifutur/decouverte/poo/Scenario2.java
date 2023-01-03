package be.technifutur.decouverte.poo;

public class Scenario2 {

    public static void main(String[] args) {
        VaisseauMethode v1 = new VaisseauMethode(10);
        VaisseauMethode v2 = new VaisseauMethode(3);

        v1.decoller();
        v1.decoller();
        v1.atterrir();
        v1.atterrir();
        v1.decoller();
        v1.tirer();
        v1.tirer();
        System.out.println(v1.getNbMissiles());
        v1.tirer();
        v1.tirer();
        v1.tirer();
        v1.tirer();
        v1.tirer();
        v1.tirer();
        v1.addMissiles(8);
        System.out.println(v1.getNbMissiles());
    }
}
