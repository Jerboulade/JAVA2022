package src.be.technifutur.event.controller;

import src.be.technifutur.event.Planning;

import java.util.Scanner;

public class PlanningController {
    private Planning planning;
    private ActivityController ac;
    private ParticipantController pc;

    public PlanningController(Planning planning) {
        this.planning = planning;
        this.ac = new ActivityController(planning.getaList());
        this.pc = new ParticipantController(planning);
    }

    public void start(){
        int action = 0;
        Scanner scan = new Scanner(System.in);

        while (action != 3){
            System.out.print("""
                    1.Activity manager
                    2.Participant manager
                    3.Quit
                    """);
            try {
                action = Integer.parseInt(scan.nextLine());
                if (action >= 1 && action <= 2) {
                    switch (action) {
                        case 1 -> ac.start();
                        case 2 -> pc.start();
                    }
                }
                else if (action != 3)
                    System.out.println("-Wrong action!-");
            }
            catch (NumberFormatException e){
                System.out.println("--Wrong action!--");
            }
        }
        System.out.println("Ciao les nazes!");
    }
}
