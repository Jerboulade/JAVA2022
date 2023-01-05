package src.be.technifutur.event.activities;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Scanner;
import java.text.Format;

public class TestActivities {
    public static void main(String[] args) {
        // Housing act2;
        // Meal    act3;
        Session act1;
        Scanner scan = new Scanner(System.in);

        LocalDateTime start;

        //input = scan.nextLine();

        //LocalDateTime date = LocalDateTime.of(2002, 2, 15, 13, 31); // throws DateTimeException
        //date = date.plusHours(5);

        //stockage
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy H:mm");
        String text = "12-03-2022 8:30";  // user input
        LocalDateTime sTime = LocalDateTime.parse(text, dateFormat);
        System.out.println(sTime);
        //view
        DateTimeFormatter viewFormat = DateTimeFormatter.ofPattern("'Le' dd LLLL yyyy 'à' HH'h'mm");
        String view = sTime.format(viewFormat);
        System.out.println(view);

        //act1 = new Session(SessionCategory.BEERPONG);
        //act1.setStartTime();
    }
}
