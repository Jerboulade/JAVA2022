package be.technifutur.decouverte.api.collection.iterator;

import be.technifutur.decouverte.api.collection.data.Personne;

import java.util.*;

public class CollectionDecouverte {

    public static void main(String[] args) {
        Personne[] personneTab = Personne.dataTest();
        Collection<Personne> personneCollection = new LinkedHashSet<>();
        for(Personne p :personneTab){
            System.out.println(personneCollection.add(p));
        }


        for (Personne p : personneCollection){
            System.out.println(p);
        }
    }
}
