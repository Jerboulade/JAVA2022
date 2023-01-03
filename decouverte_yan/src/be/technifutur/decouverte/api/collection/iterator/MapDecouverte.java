package be.technifutur.decouverte.api.collection.iterator;

import be.technifutur.decouverte.api.collection.data.Personne;

import java.util.*;

public class MapDecouverte {

    public static void main(String[] args) {
        Map<Integer, Personne> maMap = new LinkedHashMap<>();
        //Map<Integer, Personne> maMap = new HashMap<>();
        //Map<Integer, Personne> maMap = new TreeMap<>();

        for(Personne p : Personne.dataTest()){
            maMap.put(p.getAge(),p);
        }

        for( Integer i : maMap.keySet()){
            System.out.printf("age: %s, personne: %s%n",i,maMap.get(i));
        }

        Map<Integer, Set<Personne>> calendrier = new TreeMap<>();
        for(Personne p : Personne.dataTest()){
            int key = p.getAge()/10*10;
            Set<Personne> set = calendrier.get(key);
            if(set == null){
                set = new HashSet<>();
                calendrier.put(key,set);
            }
            set.add(p);

        }

        for( Integer i : calendrier.keySet()){
            System.out.printf("age: %s, personne: %s%n",i,calendrier.get(i));
        }

        // boucle sur les valeurs
        for(Personne p : maMap.values()){
            System.out.println(p);
        }

        //boucles sur clé valeur
        for(Map.Entry<Integer,Personne> entry: maMap.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
