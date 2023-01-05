package src.be.technifutur.event.participant;

import src.be.technifutur.event.activities.Activity;

import java.util.LinkedList;

public class Individual{
    private String   id;
    private String   name;
    private String   lastName;
    private String   club;
    private LinkedList<Activity> activitiesList = new LinkedList<>();


    public Individual() {
    }

    public          Individual(String name, String club) {
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
        return (id +
                " " + name +
                " " + lastName +
                " " + club +
                " " + activitiesList);
    }

    public static void main(String[] args) {
        LinkedList<Individual> aList = new LinkedList<>();
        IndividualController ic = new IndividualController(aList);

        System.out.println(ic.createIndividual());
        System.out.println(ic.createIndividual());
        System.out.println(aList);
    }
}
