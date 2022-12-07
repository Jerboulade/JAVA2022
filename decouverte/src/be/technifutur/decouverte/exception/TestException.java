package be.technifutur.decouverte.exception;

import javax.naming.ldap.SortResponseControl;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestException {

    public static void main(String[] args)
    {
        String path = new String("./toto.txt");
        try (Scanner scan = new Scanner(new File(path)))
        {
            while (scan.hasNext())
            {
                int a = Integer.parseInt(scan.nextLine());
                System.out.println("---------- line : " + a + " -------------");
                System.out.println("TestException.main start");
                try
                {
                    fct1(a);
                }
                catch (Exception e)
                {
                    System.out.println("fct1 not catched");
                }
                System.out.println("TestException.main end");
            }
        }
        catch (FileNotFoundException | NoSuchElementException e) // NoSuchElementException occures if scan.nextLine doesn't find text
        {
            System.out.println("An error occured!!!!!!");
        }
    }

    private static void fct1(int val)
    {
        System.out.println("TestException.fct1 start");
        try
        {
            System.out.println("TestException.fct1 start try");
            fct2(val);
            System.out.println("TestException.fct1 end try");
        }
        catch (MyException e)
        {
            //e.printStackTrace();
            System.out.println("TestException.fct1 catch");
            System.err.println(e.getMessage());
        }
        catch (IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            System.out.println("FINALLY");
        }
        System.out.println("TestException.fct1 end");
    }

    private static void fct2(int val) throws MyException
    {
        System.out.println("TestException.fct2 start");
        fct3(val);
        System.out.println("TestException.fct2 end");
    }

    private static void fct3(int val) throws MyException
    {
        System.out.println("TestException.fct3 start");
        if (val == 5)
            throw new InvalidParameterException("5 is an exception");
        else if (val == 10)
            throw new MyException("10 is also an exception");
        else if (val == 20)
            throw new RuntimeException("20 is not good");
        System.out.println("TestException.fct3 end");
    }
}
