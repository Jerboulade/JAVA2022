package src.be.technifutur.event.participant;

import src.be.technifutur.event.activities.Activity;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.UUID;

public class IndividualController {
    private LinkedList<Individual> iList;

    public IndividualController(LinkedList<Individual> iList) {
        this.iList = iList;
    }

    public void addIndividual(Individual i){
        iList.add(i);
    }

    public Individual createIndividual(){
        Scanner scan = new Scanner(System.in);
        Individual i = new Individual();
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
        addIndividual(i);
        return i;
    }

    public void listIndividual()
    {
        int i = 0;

        for (Individual ind : iList){
            System.out.println(++i + ": " + ind);
        }
    }

    public static void main(String[] args) {
        LinkedList<Individual> iList= new LinkedList<>();
        IndividualController ic = new IndividualController(iList);

        ic.createIndividual();
        ic.createIndividual();
        ic.listIndividual();

    }
}
