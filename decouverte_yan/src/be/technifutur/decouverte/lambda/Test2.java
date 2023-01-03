package be.technifutur.decouverte.lambda;

import be.technifutur.decouverte.poo.VaisseauAncetre;
import be.technifutur.decouverte.poo.Xwing;
import be.technifutur.decouverte.poo.autre.Millenium;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<VaisseauAncetre> vaisseauList = new ArrayList<>();

        vaisseauList.add(new Millenium());
        vaisseauList.add(new Millenium());
        vaisseauList.add(new Millenium());
        vaisseauList.add(new Xwing(5));
        vaisseauList.add(new VaisseauAncetre(6) {
            @Override
            public void afficherCamps() {
                System.out.println("j'ai pas de camps");
            }
        });
        vaisseauList.add(new Xwing(3){
            @Override
            public void tirer() {
                System.out.println("je vais tirer");
                super.tirer();
            }
        });

        vaisseauList.forEach(VaisseauAncetre::tirer);
        System.out.printf("---------...same as....-----------\n");
        vaisseauList.forEach(v -> {
            v.tirer();
        });
    }
}
