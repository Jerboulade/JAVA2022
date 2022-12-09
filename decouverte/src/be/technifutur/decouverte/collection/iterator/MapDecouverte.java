package be.technifutur.decouverte.collection.iterator;

import be.technifutur.decouverte.collection.data.Personne;

import java.util.*;

public class MapDecouverte {

    public static void main(String[] args) {
        // Map<Integer, Personne> maMap = new HashMap<>(); // not sorted
         Map<Integer, Personne> maMap = new LinkedHashMap<>(); // fifo
        // Map<Integer, Personne> maMap = new TreeMap<>(); // sorted

        for (Personne p : Personne.dataTest()){
            maMap.put(p.getAge(), p);
        }
        for (Integer i : maMap.keySet()){
            System.out.println(i);
        }
        for (Integer i : maMap.keySet()){
            System.out.printf("age: %s, personne: %s\n", i, maMap.get(i));
        }
        System.out.println("-----------------");
        Map<Integer, Set<Personne>> calendar = new TreeMap<>();
        for (Personne p : Personne.dataTest()){
            int age = p.getAge();
            Set<Personne> set = calendar.get(age);
            if (set == null){
                set = new LinkedHashSet<>();
                calendar.put(age, set);
            }
            set.add(p);
        }
        for (Integer i : calendar.keySet()){
            System.out.printf("age: %s, personne: %s\n", i, calendar.get(i));
        }
    }
}
