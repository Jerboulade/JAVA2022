package be.technifutur.decouverte.collection.iterator;

import be.technifutur.decouverte.collection.data.Personne;

import java.util.Comparator;

public class NameComparator implements Comparator<Personne> {

    @Override
    public int compare(Personne o1, Personne o2) {
        int res;

        res = o1.getName().compareTo(o2.getName());
        if (res == 0)
            res = o1.getPrenom().compareTo(o2.getPrenom());
        if (res == 0)
            res = o1.getNaissance().compareTo(o2.getNaissance());
        return res;
    }
}
