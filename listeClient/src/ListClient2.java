import org.w3c.dom.Text;

import java.util.Scanner;

public class ListClient2
{
    public static void main(String[] args)
    {
        int             option = 0;
        ChainedList     list = new ChainedList();

        while (option != 5)
        {
            option = showMenu();
            if (option == 1)
                showList(list);
            else if (option == 2)
                addClient(list);
            else if (option == 3)
                delClient(list);
            else if (option == 4)
                modifyClient(list);
        }
        System.out.println("Ciao les nazes!");
    }
    public static int  showMenu()
    {
        Scanner scan = new Scanner(System.in);
        int         option = 0;

        System.out.printf("[1] Lister les clients\n");
        System.out.printf("[2] Ajouter un client\n");
        System.out.printf("[3] Supprimer un client\n");
        System.out.printf("[4] Modifier un client\n");
        System.out.printf("[5] Quitter\n\n");
        System.out.printf("Choisir une option: ");
        option = Integer.parseInt(scan.nextLine());
        while (option < 1 || option > 5)
        {
            System.out.printf("L'option '%d' est invalide.\nChoisir une option: ", option);
            option = Integer.parseInt(scan.nextLine());
        }
        return (option);
    }

    public static void  showList(ChainedList list)
    {
        int     i = 0;
        Node    tmp = list.start;

        if (list.count == 0)
            System.out.println("La liste ne contient aucun client!");
        else
        {
            while (tmp != null)
            {
                System.out.printf("%d. ", i + 1);
                showIndividual(tmp.client);
                tmp = tmp.next;
                i++;
            }
        }

    }

    public static void  showIndividual(Individual client)
    {
        String    birth;

        birth = client.date.day + " / " + client.date.month + " / " + client.date.year;
        System.out.printf("%s %s - Date of birth: %s\n",client.name, client.firstName, birth);
    }

    public static void  addClient(ChainedList list)
    {
        Node    newNode;

        if (list.count == list.size)
            System.out.println("La liste est complète! Impossible d'ajouter d'autres clients");
        else
        {
            newNode = new Node();
            newNode.client = getClient(list);
            if (list.count == 0)
            {
                list.start = newNode;
                list.current = newNode;
            }
            else
            {
                newNode.previous = list.current;
                list.current.next = newNode;
                list.current = newNode;
            }
            list.count++;
        }
    }

    public static Individual  getClient(ChainedList list)
    {
        Individual  client = new Individual();
        Birthday    date = new Birthday();
        Scanner     scan = new Scanner(System.in);
        String      input;

        System.out.printf("Nom : ");
        client.name = scan.nextLine();
        System.out.printf("Prénom : ");
        client.firstName = scan.nextLine();
        while (checkFirstName(client.name, client.firstName, list) == false)
        {
            System.out.printf("Nom : ");
            client.name = scan.nextLine();
            System.out.printf("Prénom : ");
            client.firstName = scan.nextLine();
        }
        System.out.printf("Jour de naissance : ");
        input = scan.nextLine();
        if (input != "")
            date.day = Integer.parseInt(input);
        System.out.printf("Mois de naissance : ");
        input = scan.nextLine();
        if (input != "")
            date.month = Integer.parseInt(input);
        System.out.printf("Année de naissance : ");
        input = scan.nextLine();
        if (input != "")
            date.year = Integer.parseInt(input);
        client.date = date;
        return (client);
    }

    public static boolean checkFirstName(String name, String firstName, ChainedList list)
    {
        Node    tmp = list.start;
        boolean valid = true;

        if (name.length() < 2 || firstName.length() < 2)
        {
            valid = false;
            System.out.println("Le nom/prenom du client doit contenir 2 lettres au minimum.");
        }
        else
        {
            while (tmp != null)
            {
                System.out.println("coucou");
                if (name.equalsIgnoreCase(tmp.client.name) && firstName.equalsIgnoreCase(tmp.client.firstName))
                {
                    valid = false;
                    System.out.printf("Le client %s %s existe déjà.\n", tmp.client.name, tmp.client.firstName);
                }
                tmp = tmp.next;
            }
        }
        return (valid);
    }
    public static Node getNode(ChainedList list, int position)
    {
        Node tmp = list.start;

        while (position > 0)
        {
            tmp = tmp.next;
            position--;
        }
        return (tmp);
    }

    public static void  delClient(ChainedList list)
    {
        Node        delNode;
        Scanner     scan = new Scanner(System.in);
        int         num;

        if (list.count == 0)
            System.out.println("La liste est vide!\n");
        else
        {
            showList(list);
            System.out.print("Rentrez le numéro du client à supprimer: ");
            num = Integer.parseInt(scan.nextLine());
            while (num < 1 || num > list.count)
            {
                System.out.printf("Le numero de client '%d' est invalide.\nChoisir un autre numero: ", num);
                num = Integer.parseInt(scan.nextLine());
            }
            num--;

            delNode = getNode(list, num);
            showIndividual(delNode.client);
            System.out.println("|--> supprimé\n");

            if (num == 0 || list.count == 1) // premier element de la liste ou liste avec 1 seul element
            {
                list.start = list.start.next;
                if (list.start != null)
                    list.start.previous = null;
            }
            else if (num + 1 == list.count) // dernier element de la liste
            {
                list.current = list.current.previous;
                list.current.next = null;
            }
            else // entre le 1 et le dernier
            {
                delNode.previous.next = delNode.next;
                delNode.next.previous = delNode.previous;
            }
            list.count--;
        }
    }

    public static void modifyClient(ChainedList list)
    {
        System.out.println("Work in progress...");

    }
}
