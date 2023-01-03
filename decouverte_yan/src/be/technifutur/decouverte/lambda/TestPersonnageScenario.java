package be.technifutur.decouverte.lambda;

import be.technifutur.decouverte.poo.Jedi;
import be.technifutur.decouverte.poo.Personnage;
import be.technifutur.decouverte.poo.Soldat;
import be.technifutur.decouverte.poo.autre.Millenium;

import java.util.function.BiConsumer;

public class TestPersonnageScenario {

    public static void main(String[] args) {
        Soldat soldat = new Soldat("Léon");
        Jedi jedi = new Jedi("Luc");

        PersonnageScenario scenario = new PersonnageScenario(soldat, jedi);

        scenario.addScennette((h,p)->{
            System.out.printf("%s dit : ",h.getNom());
            h.afficheCamps();
            System.out.printf("et %s repond ", p.getNom());
            p.afficheCamps();
        });
        scenario.addScennette(new MonBiconsumer());
        scenario.addScennette((h,p) -> {
            System.out.printf("%s: %n",h.getNom());
            h.combattre();
            System.out.printf("et %s %n",p.getNom());
            p.combattre();
            System.out.printf("%s ne savait pas visé contrairement à %s %n",h.getNom(),p.getNom());
            System.out.printf("%s lui coupa la tête %n", p.getNom());
        });
        scenario.addScennette(getEpisode2());
        scenario.addScennette(TestPersonnageScenario::histoire);
        scenario.addScennette((h,p)-> System.out.println("..."));
        scenario.addScennette(TestPersonnageScenario::histoireNulle);
        scenario.addScennette(TestPersonnageScenario::part);
        scenario.addScennette(TestPersonnageScenario::jaiPasLesRef);
        scenario.addScennette(new BiConsumer<Personnage, Personnage>() {
            @Override
            public void accept(Personnage h, Personnage p) {
                h.combattre();
                System.out.println(h.getNom());
                p.combattre();
                System.out.println(p.getNom());
            }
        });
        scenario.addScennette(TestPersonnageScenario::andorcemieuxquestarwars);
        scenario.run();
    }
    static void andorcemieuxquestarwars(Personnage A, Personnage C) {

        System.out.println("Deux silhouettes se dessinent " );
        System.out.println("C'est moi " + A.getNom() + " Et je vais niquer ta mère");
        System.out.println( C.getNom() + ": J'aimerai niquer la tienne mais elle est déjà morte.");
        System.out.println(A.getNom() + " "+  A.combattre() +" "+ C.getNom());
    }

    private static BiConsumer<Personnage, Personnage> getEpisode2() {
        return new BiConsumer<Personnage, Personnage>(){
            @Override
            public void accept(Personnage personnage, Personnage personnage2) {
                //
            }
        };
    }

    static void jaiPasLesRef(Personnage pers1, Personnage pers2){
        System.out.println("Bonjour, je m'appelle "+pers2.getNom());
        System.out.println(pers1.getNom()+" : j'ai pas la ref, j'ai pas vu les films Oskour");
    }

    static void part(Personnage p, Personnage h) {
        Millenium v = new Millenium();

        System.out.println(p.getNom() + " monte dans le vaisseau");
        v.decoller();
        if(p.getCamp() == h.getCamp()) {
            System.out.println(p.getNom() + " apercoit " + h.getNom());
            v.tirer();
        }
    }

    static void histoireNulle(Personnage p,Personnage p2){
        p.afficheCamps();
        p.combattre();
        p2.afficheCamps();
        p2.combattre();
    }

    static void histoire(Personnage p, Personnage h) {
        h.combattre();
        System.out.println(h.getNom());
        p.combattre();
        System.out.println(p.getNom());
    }
}
