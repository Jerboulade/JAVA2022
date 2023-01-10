package src.be.technifutur.event.participant;

import src.be.technifutur.event.activities.Activity;

import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class Participant {
    private String   id;
    private String   name;
    private String   lastName;
    private String   club;
    private LinkedList<Activity> activitiesList = new LinkedList<>();


    public Participant() {
    }

    public Participant(String name, String club) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LinkedList<Activity> getActivitiesList() {
        return activitiesList;
    }

    public void addActivities(Activity a){
        this.activitiesList.add(a);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(" ");
        DateTimeFormatter day = DateTimeFormatter.ofPattern("ddLLLHH'h'mm");
        for (Activity a : activitiesList){
            str.append("[");
            str.append(a.getClass().getSimpleName().toUpperCase());
            str.append(String.format(":%s - %s", a.getStartTime().format(day), a.getEndTime().format(day)));
            str.append("] ");
        }
        return (name + "." + lastName + "(" + club + ")" + str);
    }

    public static void main(String[] args) {

    }
}
