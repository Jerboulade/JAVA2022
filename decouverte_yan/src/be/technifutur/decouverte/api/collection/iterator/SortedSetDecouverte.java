package be.technifutur.decouverte.api.collection.iterator;

import be.technifutur.decouverte.api.collection.data.Personne;

import java.util.*;

public class SortedSetDecouverte {

    public static void main(String[] args) {
        Personne[] dataTest = Personne.dataTest();
        Comparator<Personne> monComparator = new NameComparator();
        SortedSet<Personne> monSet = new TreeSet<>(monComparator);
        monSet.addAll(Arrays.asList(dataTest));
        for (Personne p : monSet){
            System.out.println(p);
        }

        Arrays.sort(dataTest, monComparator);
    }
}
