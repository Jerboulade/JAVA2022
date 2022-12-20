package be.technifutur.decouverte.stream;

import be.technifutur.decouverte.collection.data.Personne;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayToStream {
    public static void main(String[] args) {
        Personne[] pers = Personne.dataTest();
        Stream<Personne> objectif = Arrays.stream(pers);
        Stream<Personne> objectif2 = Arrays.stream(pers);

        objectif = Arrays.asList(pers).stream();
        objectif.filter(p -> p.getAge() > 60)
                .map(p -> String.format("%s a %d ans!", p.getPrenom(), p.getAge()))
                .forEach(System.out::println);
        System.out.println("----------------------------------");
        List<Personne> list = Arrays.stream(pers).filter(p->p.getAge()<70)
                                                 .toList();
        for (Personne p : list)
            System.out.println(p);
        System.out.println("----------------------------------");
        long num = objectif2.filter(p -> p.getAge() >= 20 && p.getAge() <= 65)
                            //.peek(System.out::println)
                            .count();
        System.out.println(num);
        System.out.println("----------------------------------");
        String noms = Arrays.stream(pers)
                .map(p -> String.format("%s %s", p.getPrenom().toUpperCase(), p.getName().toUpperCase()))
                .collect(Collectors.joining(", "));
        System.out.println(noms);
        System.out.println("----------------------------------");
        Map<Integer, String> map = Arrays.stream(pers)
                                    .collect(Collectors.toMap(
                                            p->p.getAge()/10*10,
                                            p->String.format("%s %s", p.getPrenom().toUpperCase(), p.getName().toUpperCase()),
                                            (i,j)->String.format("%s, %s", i, j))
                                    );
        System.out.println(map);
        System.out.println("----------------------------------");
        Map<Integer, Personne> map2 = Arrays.stream(pers)
                .collect(Collectors.toMap(
                        p->p.getAge()/10*10,
                        p->p,
                        (i,j)->i.getName().length() >= j.getName().length() ? i : j)
                );
        System.out.println(map2);
        System.out.println("----------------------------------");
        Map<Character, SortedSet<Personne>> botin = Arrays.stream(pers)
                .collect(Collectors.groupingBy(
                        p->p.getName().charAt(0),
                        Collectors.toCollection(()->new TreeSet<>(getNameComparator()))
                ));
        System.out.println(botin);
        for (Character i : botin.keySet()){
            SortedSet<Personne>s = botin.get(i);

            System.out.printf("%c\n-\n", i);
            for (Personne p : s)
                System.out.printf("%s\n", String.format("%s %s est né le %s et mesure %dcm", p.getName(), p.getPrenom(), p.getNaissance(), p.getTaille()));
        }
    }

    private static Comparator<Personne> getNameComparator(){
        return (Comparator.comparing(Personne::getName).thenComparing(Personne::getPrenom).thenComparing(Personne::getNaissance));
    }
}
