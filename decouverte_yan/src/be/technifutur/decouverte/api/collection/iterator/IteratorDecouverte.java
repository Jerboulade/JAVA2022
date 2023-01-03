package be.technifutur.decouverte.api.collection.iterator;

import be.technifutur.decouverte.api.collection.data.Personne;

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
        //testIterator(iterator);
        testIterable(personneListModifiable);
    }

    private static void testIterator(Iterator<Personne> iterator2) {
//        boolean b = iterator2.hasNext();
//        System.out.println(iterator2.next());
//        System.out.println(iterator2.next());
        while (iterator2.hasNext()) {
            Personne personne = iterator2.next();
            System.out.println(personne.getName() + " " + personne.getPrenom());
        }
    }

    private static void testIterable(Iterable<Personne> iterable) {
        Iterator<Personne> iterator = iterable.iterator();
        while (iterator.hasNext()){
            Personne x = iterator.next();
            System.out.println(x.getName()+" "+ x.getPrenom());
            if(x.getName().charAt(0)=='B'){
                iterator.remove();
            }
        }

        System.out.println("-----------------------");
        int pos = 0;
        for(Personne x : iterable){
            System.out.println( (pos+1)+") "+x.getName()+" "+ x.getPrenom());
            pos++;
        }
    }
}
