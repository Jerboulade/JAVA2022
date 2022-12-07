package be.technifutur.decouverte.collection.iterator;

import be.technifutur.decouverte.collection.data.Personne;

import java.util.*;

public class CollectionDecouverte
{
    public static void main(String[] args)
    {
        Personne[] personneTab = Personne.dataTest();
        // Collection<Personne> personneCollection = new ArrayList<>(); //ArrayList accept doublons
         Collection<Personne> personneCollection = new HashSet<>(); // HashSet don't accept doublons -> will accept to add twice Yves Montand because HashSet check doublon via equals so via reference -> we have to rewrite equals to make it efficient

        for (Personne p : personneTab)
            System.out.println(personneCollection.add(p));
        personneCollection.add(personneTab[0]);
        personneCollection.add(personneTab[0]); // return: true with ArrayList, false with HashSet
        personneCollection.add(personneTab[1]);
        System.out.println(personneCollection.contains(personneTab[3]));
        for (Personne p : personneCollection)
            System.out.println(p);
        System.out.println("-----------------------");
        personneCollection.add(personneTab[3]);
        System.out.println(personneCollection.contains(personneTab[3]));
        for (Personne p : personneCollection)
            System.out.println(p);
    }


}
