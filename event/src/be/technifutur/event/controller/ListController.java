package src.be.technifutur.event.controller;

import java.util.LinkedList;
import java.util.Scanner;

public class ListController {
    public ListController() {
    }

    public LinkedList selectMultipleItem(LinkedList list, String itemLabel){
        LinkedList selection = new LinkedList<>();

        if (list.size() != 0){
            Scanner scan = new Scanner(System.in);
            String[] input;

            listItem(list);
            System.out.printf("Choose %s [1,2,...]\n", itemLabel);
            input = scan.nextLine().split(",");
            for (String s : input) {
                selection.add(list.get(Integer.parseInt(s) - 1));
            }
            for (Object i : selection) {
                System.out.println(i);
            }
        }
        else
            System.out.printf("No %s in the planning!\n", itemLabel);
        return selection;
    }

    public Object selectOneItem(LinkedList list, String itemLabel){
        Object selection = null;

        if (list.size() != 0){
            Scanner scan = new Scanner(System.in);
            String input;

            listItem(list);
            System.out.printf("Choose %s [number]\n", itemLabel);
            input = scan.nextLine();
            selection = list.get(Integer.parseInt(input) - 1);
            System.out.println(selection);
        }
        else
            System.out.printf("No %s in the planning!\n", itemLabel);
        return selection;
    }

    public void listItem(LinkedList list){
        int i = 0;

        for (Object item : list){
            System.out.println(++i + ": " + item);
        }
        System.out.println("");
    }
}
