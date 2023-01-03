package be.technifutur.decouverte.lambda;

import be.technifutur.decouverte.poo.Personnage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class PersonnageScenario {

    Personnage hero;
    Personnage pers;

    List<BiConsumer<Personnage,Personnage>> scenetteList = new ArrayList<>();

    public PersonnageScenario(Personnage hero, Personnage pers) {
        this.hero = hero;
        this.pers = pers;
    }

    public void addScennette(BiConsumer<Personnage,Personnage> scenette){
        this.scenetteList.add(scenette);
    }

    public void run(){
        System.out.printf("Rencontre de %s et %s %n",hero.getNom(), pers.getNom());
        for(BiConsumer<Personnage,Personnage> s : scenetteList){
           s.accept(hero,pers);
        }
        System.out.println("FIN");
    }
}
