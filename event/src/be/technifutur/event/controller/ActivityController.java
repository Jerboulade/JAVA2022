package src.be.technifutur.event.controller;

import src.be.technifutur.event.activities.*;
import src.be.technifutur.event.participant.Participant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.Scanner;

public class ActivityController {

    private LinkedList<Activity> aList;

    public ActivityController(LinkedList<Activity> aList) {
        this.aList = aList;
    }

    public void start(){
        int action = 0;
        Scanner scan = new Scanner(System.in);

        while (action != 5){
            System.out.print("""
                    1.Show activities
                    2.Create activity
                    3.Delete activity (TODO)
                    4.Modify activity (TODO)
                    5.Go back
                    """);
            try {
                action = Integer.parseInt(scan.nextLine());
                if (action >= 1 && action <= 4) {
                    switch (action) {
                        case 1 -> showActivities();
                        case 2 -> createActivity();
                        case 3 -> System.out.println("delete activity");
                        case 4 -> System.out.println("modify activity");
                    }
                }
                else if (action != 5)
                    System.out.println("-Wrong action!-");
            }
            catch (NumberFormatException e){
                System.out.println("--Wrong action!--");
            }
        }
    }

    public void showActivities() {
        if (aList.size() != 0){
            DateTimeFormatter viewFormat = DateTimeFormatter.ofPattern("dd LLLL yyyy 'at' HH'h'mm");
            String attribute;

            for (Activity a : aList) {
                if (a instanceof Meal)
                    attribute = ((Meal) a).getDish();
                else if (a instanceof Session)
                    attribute = ((Session) a).category.name();
                else if (a instanceof Housing)
                    attribute = String.valueOf(((Housing) a).getRoom());
                else
                    attribute = "whatever";
                String output = String.format("%s: %s\n", a.getClass().getSimpleName(), attribute);
                System.out.printf("%s", output);
                for (int i = 0; i < output.length(); i++)
                    System.out.print("-");
                System.out.printf("\nStart: %s\nEnd:   %s\nPrice: %.2f\nComment: '%s'\nParticipants: ",
                        a.getStartTime().format(viewFormat), a.getEndTime().format(viewFormat), a.getPrice(), a.getComment());
                if (a.getParticipantsList().size() != 0) {
                    for (Participant p : a.getParticipantsList()) {
                        System.out.printf("%s.%s", p.getName(), p.getLastName());
                        if (!p.equals(a.getParticipantsList().get(a.getParticipantsList().size() - 1))) {
                            System.out.print(", ");
                        }
                    }
                } else
                    System.out.print("none");
                System.out.println("\n");
            }
        }
        else
            System.out.println("No activity in the planning yet!\n");
    }
    public void createActivity(){
        String input;
        int option;
        Activity a;
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy H:mm");
        LocalDateTime sTime;

        System.out.print("1.Sport Session\n2.Meal\n3.Housing\nChoose the type of activity: ");
        option = Integer.parseInt(scan.nextLine());
        switch (option) {
            case 1:
                a = createSession(); break;
            case 2:
                a = createMeal(); break;
            case 3:
                a = createHousing(); break;
            default:
                a = new Activity();
        }
        try{
            System.out.print("Start date (dd-MM-yyyy H:mm) : ");
            input = scan.nextLine();
            a.setStartTime(LocalDateTime.parse(input, dateFormat));
        }
        catch (DateTimeParseException e){
            a.setStartTime(LocalDateTime.now());
        }
        try {
            System.out.print("End date (dd-MM-yyyy H:mm) : ");
            input = scan.nextLine();
            a.setEndTime(LocalDateTime.parse(input, dateFormat));
        }
        catch (DateTimeParseException e){
            a.setEndTime(LocalDateTime.now());
        }
        System.out.print("Price : ");
        input = scan.nextLine();
        a.setPrice(Integer.parseInt(input));
        System.out.print("Additional comment : ");
        input = scan.nextLine();
        a.setComment(input);
        aList.add(a);
        System.out.println("\nActivity created : " + a + "\n");
    }

    public Session createSession(){
        int option;
        int i = 0;
        Session s = new Session();
        SessionCategory[] cat = SessionCategory.values();
        Scanner scan = new Scanner(System.in);

        for (SessionCategory sc : cat)
            System.out.println(++i + ". " + sc);
        System.out.printf("Choose category: ");
        option = Integer.parseInt(scan.nextLine()) - 1;
        s.setCategory(cat[option]);
        return s;
    }

    public Housing createHousing(){
        Housing h = new Housing();
        Scanner scan = new Scanner(System.in);

        System.out.printf("Room number: ");
        h.setRoom(Integer.parseInt(scan.nextLine()));
        return h;
    }

    public Meal createMeal(){
        Meal m = new Meal();
        Scanner scan = new Scanner(System.in);

        System.out.printf("Dish of the day: ");
        m.setDish(scan.nextLine());
        return m;
    }
}
