package be.technifutur.decouverte.collection.iterator;

import be.technifutur.decouverte.collection.data.Personne;
import be.technifutur.decouverte.poo.Personnage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorDecouverte {
    public static void main(String[] args) {
        Personne[] personneTab = Personne.dataTest();
        List<Personne> personneList = Arrays.asList(personneTab);
        List<Personne> personneListModifiable = new ArrayList<>(personneList);
        Iterator<Personne> iterator = personneList.iterator();
        testIterator(iterator);
        testIterable(personneListModifiable);
    }

    private static void testIterator(Iterator<Personne> i){
        //System.out.printf("%s\n", i.hasNext());
        while(i.hasNext()) {
            Personne p = i.next();
            System.out.println(p.getPrenom() + " " + p.getName() + " a " + p.getAge() + " ans!");
        }
        System.out.println("-----------------------");
    }

    private static void testIterable(Iterable<Personne> i)
    {
        Iterator<Personne> iterator = i.iterator();

        while (iterator.hasNext())
        {
            Personne p = iterator.next();
            System.out.println(p.getName() + " " + p.getPrenom());
            if (p.getName().charAt(0) == 'B')
                iterator.remove();
        }
        System.out.println("-----------------------");
        for (Personne p : i)
            System.out.println(p.getName() + " " + p.getPrenom());
    }
}
