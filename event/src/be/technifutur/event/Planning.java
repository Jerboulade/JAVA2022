package src.be.technifutur.event;

import src.be.technifutur.event.activities.Activity;
import src.be.technifutur.event.controller.ActivityController;
import src.be.technifutur.event.participant.Participant;
import src.be.technifutur.event.controller.ParticipantController;

import java.util.LinkedList;

/*
* List of activities --> map
*/
public class Planning {
    private LinkedList<Activity>    aList = new LinkedList<>();
    private LinkedList<Participant>  pList = new LinkedList<>();


    public LinkedList<Activity> getaList() {
        return aList;
    }

    public LinkedList<Participant> getpList() {
        return pList;
    }


}
