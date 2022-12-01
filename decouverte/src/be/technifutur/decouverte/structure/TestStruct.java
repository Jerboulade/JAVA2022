package be.technifutur.decouverte.structure;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.Scanner;

public class TestStruct {
    public static void main(String[] args) {
        // Personne client = new Personne();
        Personne client = getClient();
        // client.name = "Durant";
        // client.firstName = "Louis";
        // client.birthday = new MaDate();
        // client.birthday.day = 15;
        // client.birthday.month = 2;
        // client.birthday.year = 2000;
        showClient(client);

        String txt = dateToStr(client.birthday);
        System.out.println(txt);
    }
    public static void showClient(Personne p){
        System.out.print(p.name + " " + p.firstName + " est né le ");
    }

    public static String dateToStr(MaDate birth){
        return(birth.day + "/" + birth.month + "/" + birth.year);
    }

    public static void monthToStr(int month){
        if (month == 1)
            System.out.print("Janvier");
        else if (month == 2)
            System.out.print("Février");
        else if (month == 4)
            System.out.print("Avril");
        else if (month == 5)
            System.out.print("Mai");
        else if (month == 6)
            System.out.print("Juin");
        else if (month == 7)
            System.out.print("Juillet");
        else if (month == 8)
            System.out.print("Août");
        else if (month == 9)
            System.out.print("Septembre");
        else if (month == 10)
            System.out.print("Octobre");
        else if (month == 11)
            System.out.print("Novembre");
        else if (month == 12)
            System.out.print("Décembre");
    }

    public static Personne getClient(){
        Personne    p = new Personne();
        MaDate      birth = new MaDate();
        Scanner     scan = new Scanner(System.in);
        Text        input;

        System.out.printf("Nom : ");
        p.name = scan.nextLine();
        System.out.printf("Prénom : ");
        p.firstName = scan.nextLine();
        System.out.printf("Jour de naissance : ");
        birth.day = Integer.parseInt(scan.nextLine());
        System.out.printf("Mois de naissance : ");
        birth.month = Integer.parseInt(scan.nextLine());
        System.out.printf("Année de naissance : ");
        birth.year = Integer.parseInt(scan.nextLine());
        p.birthday = birth;
        return (p);
    }
}
