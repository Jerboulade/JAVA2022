package src.be.technifutur.event.activities;

import java.time.LocalDateTime;

public class Activity {
    private LocalDateTime    startTime;
    private LocalDateTime    endTime;
    private float            price;
    private String           comment;

    public              Activity(LocalDateTime startTime) {
        this.startTime = startTime;
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
}
