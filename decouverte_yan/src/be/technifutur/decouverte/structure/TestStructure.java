package be.technifutur.decouverte.structure;

import java.util.Scanner;

public class TestStructure {

    public static void main(String[] args) {
        Personne client = new Personne();
        client.nom = "Durant";
        client.prenom = "Toto";
        client.naissance = new MaDate();
        client.naissance.jour = 15;
        client.naissance.mois = 3;
        client.naissance.an = 2000;

        client = saisirPersonne();

        afficherPersonne(client);
        String texte = dateToString(client.naissance);
        System.out.println(texte);
    }

    private static String dateToString(MaDate date) {
        return String.format("%s / %s / %s", date.jour,date.mois,date.an);
    }

    private static Personne saisirPersonne() {
        Personne pers = new Personne();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom : ");
        pers.nom = scanner.nextLine();
        System.out.print("Prénom : ");
        pers.prenom = scanner.nextLine();
        pers.naissance = saisirDate();
        return pers;
    }

    private static MaDate saisirDate() {
        return null;
    }

    public static void afficherPersonne(Personne p){

        System.out.printf("""
                nom : %s
                prénom : %s
                date de naissance : %s
                """, p.nom, p.prenom, dateToString(p.naissance));

    }
}
