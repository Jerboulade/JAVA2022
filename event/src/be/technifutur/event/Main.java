package src.be.technifutur.event;

import src.be.technifutur.event.controller.PlanningController;

public class Main {
    public static void main(String[] args) {
        Planning planning = new Planning();
        PlanningController pc = new PlanningController(planning);

        pc.start();
    }
}
