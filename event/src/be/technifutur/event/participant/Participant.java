package src.be.technifutur.event.participant;

import src.be.technifutur.event.activities.Activity;

import java.util.LinkedList;

public class Participant {
    private int id;
    private LinkedList<Activity> activities;
    private int forfeit;

    public Participant() {
    }

    public int getId() {
        return id;
    }

    public LinkedList getActivities() {
        return activities;
    }

    public int getForfeit() {
        return forfeit;
    }
}
