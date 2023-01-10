package src.be.technifutur.event.controller;

import src.be.technifutur.event.Planning;
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

    public void addParticipant(Participant p){
        pList.add(p);
    }

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

    public void start(){
        int action = 0;
        Scanner scan = new Scanner(System.in);

        while (action != 6){
            System.out.println("""
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
                        case 1 -> listIndividual();
                        case 2 -> sc.addOneToManyActivities(createIndividual());
                        case 3 -> deleteParticipant();
                        case 4 -> modifyParticipant((Participant)lc.selectOneItem(pList, "participant"));
                        case 5 -> sc.addManyToManyActivities();
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
    public Participant createIndividual(){
        Scanner scan = new Scanner(System.in);
        Participant i = new Participant();
        String  input;

        System.out.printf("Name : ");
        input = scan.nextLine();
        i.setName(input);
        System.out.printf("Last name : ");
        input = scan.nextLine();
        i.setLastName(input);
        System.out.printf("Club : ");
        input = scan.nextLine();
        i.setClub(input);
        i.setId(UUID.randomUUID().toString());
        addParticipant(i);
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
                        String str;
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

    public void listIndividual()
    {
        int i = 0;

        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (Participant ind : pList){
            System.out.println(++i + ": " + ind);
        }
        System.out.println("");
    }

    public static void main(String[] args) {


    }

}
