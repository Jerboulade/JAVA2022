package src.be.technifutur.event.controller;

import src.be.technifutur.event.Planning;
import src.be.technifutur.event.activities.Activity;
import src.be.technifutur.event.participant.Participant;

import java.util.LinkedList;
import java.util.Scanner;

public class SubscriptionController {
    Planning planning;
    ListController lc = new ListController();

    public SubscriptionController(Planning planning) {
        this.planning = planning;
    }

    public void subOneParticipantToManyActivities(Participant participant){
        Scanner scan = new Scanner(System.in);

        if (planning.getaList().size() != 0) {
            System.out.print("Do you want to add activities to the participant? (y/n) ");
            if (scan.nextLine().equals("y")) {
                LinkedList<Activity> selection = lc.selectMultipleItem(planning.getaList(), "activity(ies)");
                LinkedList<Activity> pActivities = participant.getActivitiesList();
                for (Activity a : selection) {
                    pActivities.add(a);
                    a.getParticipantsList().add(participant);
                }
            }
        }
    }

    public void subManyParticipantsToManyActivities(){
        LinkedList<Participant> pList = planning.getpList();
        LinkedList<Activity> aList = planning.getaList();

        if (pList.size() != 0 && aList.size() != 0) {
            LinkedList<Participant> pSelect = lc.selectMultipleItem(pList, "participant(s)");
            LinkedList<Activity> aSelect = lc.selectMultipleItem(aList, "activity(ies)");
            LinkedList<Activity> tmp;

            for (Participant p : pSelect) {
                tmp = p.getActivitiesList();
                for (Activity a : aSelect) {
                    if (!tmp.contains(a)) {
                        tmp.add(a);
                        a.getParticipantsList().add(p);
                    }
                    else
                        System.out.printf("%s %s is already subscribed to %s", p.getName(), p.getLastName(), a);
                }
            }
        }
        else if (pList.size() == 0)
            System.out.println("No participant in the planning!");
        else if (aList.size() == 0)
            System.out.println("No activity in the planning!");
    }

    public void removeParticipantFromActivities(Participant p){
        LinkedList<Activity> aList = planning.getaList();
        LinkedList<Participant> pList;

        for (Activity a : aList){
            pList = a.getParticipantsList();
            if (pList.contains(p))
                pList.remove(p);
        }
    }

    /*public LinkedList<Participant> selectParticipant(){
        LinkedList<Participant> selection = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        String[] input;
        //int[] aIndex;

        listIndividual();
        System.out.println("Choose participant(s) [n1,n2,...]");
        input = scan.nextLine().split(",");
        for (String s : input){
            selection.add(planning.getpList().get(Integer.parseInt(s) - 1));
        }
        for (Participant p : selection){
            System.out.println(p);
        }
        return selection;
    }

    public LinkedList<Activity> selectActivities(){
        LinkedList<Activity> selection = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        String[] input;
        //int[] aIndex;

        listActivities();
        System.out.println("Choose activity(ies) (a1,a2,...)");
        input = scan.nextLine().split(",");
        for (String s : input){
            selection.add(planning.getaList().get(Integer.parseInt(s) - 1));
        }
        for (Activity a : selection){
            System.out.println(a);
        }
        return selection;
    }

    public void listActivities(){
        int i = 0;

        for (Activity a : planning.getaList()){
            System.out.println(++i + ": " + a);
        }
        System.out.println("");
    }

    public void listIndividual()
    {
        int i = 0;

        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (Participant ind : planning.getpList()){
            System.out.println(++i + ": " + ind);
        }
        System.out.println("");
    }*/
}
