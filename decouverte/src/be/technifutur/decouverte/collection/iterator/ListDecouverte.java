package be.technifutur.decouverte.collection.iterator;

import be.technifutur.decouverte.collection.data.Personne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListDecouverte {

    public static void main(String[] args)
    {
        Personne[] dataTest = Personne.dataTest();
        List<Personne> maList = new ArrayList<>(Arrays.asList(dataTest));
        maList = new LinkedList<>(Arrays.asList(dataTest));

        maList.size();
        maList.add(2, dataTest[5]);
        List<Personne> sousList = maList.subList(3, 7);

        for (Personne p : maList){
            System.out.println(p);
        }
        System.out.println("----------------");
        for (Personne p : sousList){
            System.out.println(p);
        }
        sousList.remove(2);
        System.out.println("----------------");
        for (Personne p : maList){
            System.out.println(p);
        }
        System.out.println("----------------");
        for (Personne p : sousList){
            System.out.println(p);
        }
        sousList.get(2);

    }
}
