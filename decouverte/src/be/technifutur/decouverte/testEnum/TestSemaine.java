package be.technifutur.decouverte.testEnum;

public class TestSemaine {
    public static void main(String[] args) {
        JourSemaine jour = dayOff(JourSemaine.LUNDI);

        if (jour == JourSemaine.LUNDI)
            System.out.printf("%s, congé!\n", jour);
        else
            System.out.printf("%s, pas congé :(\n", jour);
        for (JourSemaine j : JourSemaine.values()){
            if (j.compareTo(jour) == 2)
                System.out.printf("Oh putain: %s!\n", j); // comparTo ne guarantit pas le même écart dans toute les version de java
            if (j.compareTo(jour) > 0){
                System.out.println(j.getMessage());
                System.out.println(j.ordinal());
            }
        }
    }

    static JourSemaine dayOff(JourSemaine j){
        return (j);
    }
}
