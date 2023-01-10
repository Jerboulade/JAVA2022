package src.be.technifutur.event.controller;

import src.be.technifutur.event.Planning;
import src.be.technifutur.event.activities.Activity;
import src.be.technifutur.event.participant.Participant;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.UUID;

public class ParticipantController {
    private LinkedList<Participant> pList;
    private SubscriptionController sc;
    ListController lc = new ListController();

    public ParticipantController(Planning planning) {
        this.pList = planning.getpList();
        this.sc = new SubscriptionController(planning);
    }

    public void start(){
        int action = 0;
        Scanner scan = new Scanner(System.in);

        while (action != 6){
            System.out.print("""
                    1.Show participants
                    2.Create participant
                    3.Delete participant
                    4.Modify participant
                    5.Add activity(ies) to participant(s)
                    6.Go back
                    """);
            try {
                action = Integer.parseInt(scan.nextLine());
                if (action >= 1 && action <= 5) {
                    switch (action) {
                        case 1 -> showParticipants();
                        case 2 -> sc.subOneParticipantToManyActivities(createParticipant());
                        case 3 -> deleteParticipant();
                        case 4 -> modifyParticipant(lc.selectOneItem(pList, "participant"));
                        case 5 -> sc.subManyParticipantsToManyActivities();
                    }
                }
                else if (action != 6)
                    System.out.println("-Wrong action!-");
            }
            catch (NumberFormatException e){
                System.out.println("--Wrong action!--");
            }
        }
    }

    /** Shows every participant of the planning with detailed information*/
    public void showParticipants(){
        if (pList.size() != 0){
            for (Participant p : pList) {
                String output = String.format("%s %s\n", p.getName(), p.getLastName());
                System.out.printf("%s", output);
                for (int i = 0; i < output.length(); i++)
                    System.out.print("-");
                System.out.printf("\nClub: %s\n", p.getClub());
                if (p.getActivitiesList().size() != 0) {
                    for (Activity a : p.getActivitiesList()) {
                        System.out.printf("participate to: %s\n", a);
                    }
                } else
                    System.out.println("\nNo subscription to activity yet!");
                System.out.println("\n");
            }
        } else
            System.out.println("No participant in the planning yet!\n");
    }

    /** Create a new Participant and add it in the participant's list of the planning*/
    public Participant createParticipant(){
        Scanner scan = new Scanner(System.in);
        Participant i = new Participant();
        String  input;

        System.out.print("Name : ");
        input = scan.nextLine();
        i.setName(input);
        System.out.print("Last name : ");
        input = scan.nextLine();
        i.setLastName(input);
        System.out.print("Club : ");
        input = scan.nextLine();
        i.setClub(input);
        i.setId(UUID.randomUUID().toString());
        pList.add(i);
        return i;
    }

    public void modifyParticipant(Participant p)
    {
        if (p != null){
            int action = 0;
            Scanner scan = new Scanner(System.in);

            while (action != 4) {
                System.out.println("""
                        1.Modify name
                        2.Modify lastname
                        3.Modify club
                        4.Go back
                        """);
                try {
                    action = Integer.parseInt(scan.nextLine());
                    if (action >= 1 && action <= 3) {
                        switch (action) {
                            case 1 -> p.setName(getNewAttribute("name"));
                            case 2 -> p.setLastName(getNewAttribute("lastname"));
                            case 3 -> p.setClub(getNewAttribute("club"));
                        }
                    } else if (action != 4)
                        System.out.println("-Wrong action!-");
                } catch (NumberFormatException e) {
                    System.out.println("--Wrong action!--");
                }
            }
        }
    }

    private String getNewAttribute(String attribute) {
        Scanner scan = new Scanner(System.in);

        System.out.printf("Enter participant new %s:", attribute);
        return scan.nextLine();
    }

    /**Add Participant to the participant's list of the planning*/
    public void deleteParticipant(){

        if (pList.size() != 0) {
            LinkedList<Participant> selection = lc.selectMultipleItem(pList, "participant(s)");

            for (Participant p : selection){
                sc.removeParticipantFromActivities(p);
                pList.remove(p);
            }
        }
        else
            System.out.println("No participant in the planning!");
    }
}
