package be.technifutur.decouverte.api.collection.iterator;

import be.technifutur.decouverte.api.collection.data.Personne;

import java.util.Comparator;

public class NameComparator implements Comparator<Personne> {
    @Override
    public int compare(Personne o1, Personne o2) {
        int result = o1.getName().compareTo(o2.getName());
        if(result==0){
            result = o1.getPrenom().compareTo(o2.getPrenom());
        }
        if(result==0){
            result = o1.getNaissance().compareTo(o2.getNaissance());
        }
        return result;
    }
}
