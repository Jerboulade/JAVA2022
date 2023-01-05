package src.be.technifutur.event;

import src.be.technifutur.event.activities.Activity;
import src.be.technifutur.event.activities.ActivityController;
import src.be.technifutur.event.participant.Individual;
import src.be.technifutur.event.participant.IndividualController;

import java.util.LinkedList;

/*
* List of activities --> map
*/
public class Event {
    private LinkedList<Activity>    aList = new LinkedList<>();
    private LinkedList<Individual>  pList = new LinkedList<>();
    private ActivityController ac = new ActivityController(aList);
    private IndividualController pc = new IndividualController(pList);

    public LinkedList<Activity> getaList() {
        return aList;
    }

    public LinkedList<Individual> getpList() {
        return pList;
    }

    public ActivityController getAc() {
        return ac;
    }

    public IndividualController getPc() {
        return pc;
    }
}
