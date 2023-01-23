package be.technifutur;

import be.technifutur.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("northwind");
        EntityManager manager = emf.createEntityManager();

        emf.close();
    }
}