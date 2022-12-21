package src.be.technifutur.event.individual;

import src.be.technifutur.event.activities.Activity;

import java.util.LinkedList;

public class Individual {
    public String   name;
    public String   club;
    //public LinkedList<Activity> activitiesList;

    public          Individual(String name, String lastName, String club) {
        this.name = name;
        this.club = club;
    }

    public String   getName() {
        return name;
    }

    public void     setName(String name) {
        this.name = name;
    }

    public String   getClub() {
        return club;
    }

    public void     setClub(String club) {
        this.club = club;
    }
}
