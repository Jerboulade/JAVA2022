package be.technifutur.decouverte.generique;

import be.technifutur.decouverte.poo.VaisseauMethode;

public class TestBox {

    public static void main(String[] args) {
        VaisseauMethode v1 = new VaisseauMethode(3);

        Box<VaisseauMethode> boite = new Box<>(v1);
        Box boite2 = new Box("toto");
        Box<String> boite3  = new Box<>("dédé");

        String text = (String) boite2.getValue();
        System.out.println(text);

        VaisseauMethode value = boite.getValue();
        boite.setValue(new VaisseauMethode(6));
        utiliseBoite(boite);
        utiliseBoite(boite2);
        //utiliseBoite(boite3);
    }


    static void utiliseBoite(Box<VaisseauMethode> b){
        ((VaisseauMethode)b.getValue()).tirer();
    }
}
