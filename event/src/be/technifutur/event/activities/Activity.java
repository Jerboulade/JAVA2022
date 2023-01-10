package src.be.technifutur.event.activities;

import src.be.technifutur.event.participant.Participant;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Activity {
    private LocalDateTime    startTime;
    private LocalDateTime    endTime;
    private float            price;
    private String           comment;
    private LinkedList<Participant> participantsList = new LinkedList<>();
    public              Activity() {
    }

    public              Activity(LocalDateTime startTime, LocalDateTime endTime, float price) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public              Activity(LocalDateTime startTime, LocalDateTime endTime, float price, String comment) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.comment = comment;
    }

    public LocalDateTime    getStartTime() {
        return startTime;
    }

    public void         setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime    getEndTime() {
        return endTime;
    }

    public void         setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public float        getPrice() {
        return price;
    }

    public void         setPrice(float price) {
        this.price = price;
    }

    public String       getComment() {
        return comment;
    }

    public void         setComment(String comment) {
        this.comment = comment;
    }

    public LinkedList<Participant> getParticipantsList() {
        return participantsList;
    }

    public void setParticipantsList(LinkedList<Participant> participantsList) {
        this.participantsList = participantsList;
    }

    @Override
    public String toString() {

        LinkedList<String> names = new LinkedList<>();

        for (Participant p : participantsList)
            names.add(p.getName());
        return this.getClass().getSimpleName() + "{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                ", participantsList=" + names;
    }
}
