package be.technifutur.decouverte.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestException {

    public static void main(String[] args) {
        try(Scanner scan = new Scanner(new File("toto.txt"))) {
            while(scan.hasNext()) {
                scan.nextInt();
                int a = Integer.parseInt(scan.nextLine());
                System.out.println(a + "------------------");
                System.out.println("TestException.main debut");
                try {
                    fct1(a);
                }catch (Exception e){
                    System.out.println("fct1 non catché");
                }
                System.out.println("TestException.main fin");
            }
        } catch (FileNotFoundException|NoSuchElementException e ) {
            System.out.println("une erreur inconnue");
        }
    }

    private static void fct1(int val) {
        System.out.println("TestException.fct1 debut");
        try {
            System.out.println("TestException.fct1 debut try");
            fct2(val);
            System.out.println("TestException.fct1 fin try");
        } catch (MonException e) {
            System.out.println("TestException.fct1 catch");
            System.err.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Finally");
        }
        System.out.println("TestException.fct1 fin");
    }

    private static void fct2(int val) throws MonException {
        System.out.println("TestException.fct2 debut");
        fct3(val);
        System.out.println("TestException.fct2 fin");
    }

    private static void fct3(int val) throws MonException {
       System.out.println("TestException.fct3 debut");
        if(val == 5){
            throw new InvalidParameterException("5 c'est une erreur");
        } else if (val == 10) {
            throw new MonException("10 c'est pas bon non plus");
        } else if (val == 20){
            throw new RuntimeException(" 20 pas bon");
        }
        System.out.println("TestException.fct3 fin");

    }
}
