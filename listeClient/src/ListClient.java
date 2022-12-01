import org.w3c.dom.Text;

import java.util.Scanner;

public class ListClient {

    public static void main(String[] args)
    {
        int     option = 0;
        Liste    list = new Liste();

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
        Scanner     scan = new Scanner(System.in);
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

    public static void  showList(Liste list)
    {
        int i = 0;

        if (list.count == 0)
        {
            System.out.println("La liste ne contient aucun client!");
            return ;
        }
        while (i < list.count)
        {
            System.out.printf("%d. ", i + 1);
            showIndividual(list.tab[i]);
            i++;
        }
    }

    public static void  showIndividual(Individual client)
    {
        String    birth;

        birth = client.date.day + " / " + client.date.month + " / " + client.date.year;
        System.out.printf("%s %s - Date of birth: %s\n",client.name, client.firstName, birth);
    }

    public static void  addClient(Liste list)
    {
        if (list.count == list.SIZE)
        {
            System.out.println("La liste est complète! Impossible d'ajouter d'autres clients");
            return ;
        }
        list.tab[list.count] = getClient();
        list.count++;
    }

    public static Individual  getClient()
    {
        Individual  client = new Individual();
        Birthday    date = new Birthday();
        Scanner     scan = new Scanner(System.in);
        Text        input;

        System.out.printf("Nom : ");
        client.name = scan.nextLine();
        System.out.printf("Prénom : ");
        client.firstName = scan.nextLine();
        System.out.printf("Jour de naissance : ");
        date.day = Integer.parseInt(scan.nextLine());
        System.out.printf("Mois de naissance : ");
        date.month = Integer.parseInt(scan.nextLine());
        System.out.printf("Année de naissance : ");
        date.year = Integer.parseInt(scan.nextLine());
        client.date = date;
        return (client);
    }

    public static void  delClient(Liste list)
    {
        Scanner     scan = new Scanner(System.in);
        int         num;

        if (list.count == 0)
        {
            System.out.println("La liste est vide!\n");
            return ;
        }
        showList(list);
        System.out.print("Rentrez le numéro du client à supprimer: ");
        num = Integer.parseInt(scan.nextLine());
        while (num < 1 || num > list.count)
        {
            System.out.printf("Le numero de client '%d' est invalide.\nChoisir un autre numero: ", num);
            num = Integer.parseInt(scan.nextLine());
        }
        showIndividual(list.tab[num - 1]);
        System.out.println("|--> supprimé\n");
        list.tab[num - 1] = list.tab[list.count - 1];
        list.tab[list.count - 1] = null;
        list.count--;
    }

    public static void modifyClient(Liste list)
    {
        System.out.println("Work in progress...");
    }
}