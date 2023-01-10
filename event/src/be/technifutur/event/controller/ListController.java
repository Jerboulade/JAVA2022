package src.be.technifutur.event.controller;

import java.util.LinkedList;
import java.util.Scanner;

public class ListController {
    public ListController() {
    }

    public <T>LinkedList<T> selectMultipleItem(LinkedList<T> list, String itemLabel){
        LinkedList<T> selection = new LinkedList<>();

        if (list.size() != 0){
            Scanner scan = new Scanner(System.in);
            String[] input;
            int i = 0;

            listItem(list);
            System.out.printf("Choose %s [1,2,...] : ", itemLabel);
            input = scan.nextLine().split(",");
            for (String s : input) {
                i = Integer.parseInt(s);
                if (i > 0 && i <= list.size())
                    selection.add(list.get(i - 1));
            }
            System.out.println("\n" + itemLabel + " selected:");
            for (T o : selection) {
                System.out.println("- " + o);
            }
            System.out.println("");
        }
        else
            System.out.printf("No %s in the planning!\n", itemLabel);
        return selection;
    }

    public <T>T selectOneItem(LinkedList<T> list, String itemLabel){
        T selection = null;

        if (list.size() != 0){
            Scanner scan = new Scanner(System.in);
            String input;

            listItem(list);
            System.out.printf("Choose %s [number] : ", itemLabel);
            input = scan.nextLine();
            selection = list.get(Integer.parseInt(input) - 1);
            System.out.println(itemLabel + " selected: " + selection);
        }
        else
            System.out.printf("No %s in the planning!\n", itemLabel);
        return selection;
    }

    public void listItem(LinkedList<?> list){
        int i = 0;

        System.out.println("");
        for (Object item : list){
            System.out.println(++i + ": " + item);
        }
    }
}
