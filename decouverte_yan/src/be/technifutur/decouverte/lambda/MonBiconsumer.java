package be.technifutur.decouverte.lambda;

import be.technifutur.decouverte.poo.Personnage;

import java.util.function.BiConsumer;

public class MonBiconsumer implements BiConsumer<Personnage, Personnage> {
    @Override
    public void accept(Personnage personnage1, Personnage personnage2) {
        System.out.println("Rencontre de "+personnage1.getNom() + " et de "+personnage2.getNom());
    }
}
