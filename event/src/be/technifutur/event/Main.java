package src.be.technifutur.event;

import src.be.technifutur.event.activities.ActivityController;
import src.be.technifutur.event.participant.IndividualController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Event planning = new Event();
        ActivityController ac = planning.getAc();
        IndividualController pc = planning.getPc();
        int action = 0;
        Scanner scan = new Scanner(System.in);

        while (action != 5){
            System.out.println("1.Show list activities\n2.Show list participant\n3.Add activity\n4.Add participant\n5.Quit");
            try {
                action = Integer.parseInt(scan.nextLine());
                if (action < 1 || action > 5)
                    System.out.println("-Wrong action!-");
                else
                {
                    switch (action) {
                        case 1 -> ac.listActivities();
                        case 2 -> pc.listIndividual();
                        case 3 -> ac.createActivity();
                        case 4 -> pc.createIndividual();
                    }
                }
            }
            catch (NumberFormatException e){
                System.out.println("--Wrong action!--");
            }
        }

    }
}
