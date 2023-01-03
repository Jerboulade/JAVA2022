package src.be.technifutur.event;

import src.be.technifutur.event.participant.Participant;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int action = 0;
        Participant participant;
        Scanner scan = new Scanner(System.in);
        String output;

        while (action != 4){
            System.out.println("1.Show list activities\n2.Show list participant\n3.Add activity\n4.Quit");
            //action = scan.nextInt();
            try {
                action = scan.nextInt();
                if (action < 1 || action > 4)
                {
                    System.out.println("Wrong action!");
                    continue;
                }
            }
            catch (InputMismatchException e){
                //System.out.printf("Wrong action! %s -----------------------\n", action);
                scan.next();
                continue;
            }
            System.out.println("action " + action);
        }
        System.out.println("Exit");
    }
}
