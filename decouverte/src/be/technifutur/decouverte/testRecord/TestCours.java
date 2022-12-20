package be.technifutur.decouverte.testRecord;

import be.technifutur.decouverte.collection.data.Personne;
import be.technifutur.decouverte.testEnum.JourSemaine;

public class TestCours {
    public static void main(String[] args) {
        Cours java = new Cours(JourSemaine.LUNDI, "JAVA2022", Personne.dataTest()[0]);
        Lesson java2 = new Lesson(JourSemaine.LUNDI, "JAVA2022", Personne.dataTest()[0]);
        Lesson c = new Lesson(JourSemaine.DIMANCHE, "C3P22", Personne.dataTest()[1]);

        System.out.println(java.equals(java2));
        System.out.println(java.equals(c));
        System.out.println(java);

    }
}
