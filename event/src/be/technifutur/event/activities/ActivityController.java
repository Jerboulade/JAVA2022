package src.be.technifutur.event.activities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Scanner;

public class ActivityController {

    private LinkedList<Activity> aList;

    public ActivityController(LinkedList<Activity> aList) {
        this.aList = aList;
    }

    public void createActivity(){
        String input;
        int option;
        Activity a;
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy H:mm");
        LocalDateTime sTime;

        System.out.println("Choose the type of activity\n1.Sport Session\n2.Meal\n3.Housing");
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
        System.out.println("Start date (dd-MM-yyyy H:mm) : ");
        input = scan.nextLine();
        a.setStartTime(LocalDateTime.parse(input, dateFormat));
        System.out.println("End date (dd-MM-yyyy H:mm) : ");
        input = scan.nextLine();
        a.setEndTime(LocalDateTime.parse(input, dateFormat));
        System.out.println("Price : ");
        input = scan.nextLine();
        a.setPrice(Integer.parseInt(input));
        System.out.println("Additional comment : ");
        input = scan.nextLine();
        a.setComment(input);
        aList.add(a);
        //return a;
    }

    public void listActivities(){
        int i = 0;

        for (Activity a : aList){
            System.out.println(++i + ": " + a);
        }
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

    public static void main(String[] args) {
        LinkedList aList = new LinkedList<>();
        ActivityController ac = new ActivityController(aList);

        ac.createActivity();
        //ac.createActivity();
        //ac.createActivity();
        ac.listActivities();
    }
}
