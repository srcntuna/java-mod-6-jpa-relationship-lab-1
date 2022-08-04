package org.example;

import org.example.models.Capital;
import org.example.models.Country;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Main {
    public static void main(String[] args) {
        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        Country italy = new Country();
        italy.setName("Italy");

        Country serbia = new Country();
        serbia.setName("Serbia");

        Capital rome = new Capital();
        rome.setName("Rome");

        Capital belgrade = new Capital();
        belgrade.setName("Belgrade");

        italy.setCapital(rome);
        serbia.setCapital(belgrade);

        transaction.begin();

        entityManager.persist(italy);
        entityManager.persist(serbia);

        entityManager.persist(rome);
        entityManager.persist(belgrade);


        transaction.commit();
        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}