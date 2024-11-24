package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.config.HibernateConfig;
import org.example.model.Client;
import org.example.model.Planet;
import org.example.model.Ticket;
import org.example.service.TicketCrudService;
import org.flywaydb.core.Flyway;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Demo {
    public static void main(String[] args) {
        HibernateConfig hibernateConfig = HibernateConfig.getInstance();
        Session session = hibernateConfig.getSession();

        TicketCrudService ticketService = new TicketCrudService(session);

        Transaction transaction = session.beginTransaction();

        Client client = new Client();
        client.setName("John Dear");
        session.persist(client);
        session.flush();

        Planet venus = new Planet();
        venus.setId("VENUS");
        venus.setName("Venus");
        session.persist(venus);

        Planet octopus = new Planet();
        octopus.setId("OCTOPUS");
        octopus.setName("Octopus");
        session.persist(octopus);

        Ticket ticket = new Ticket();
        ticket.setClient(client);
        ticket.setFromPlanet(venus);
        ticket.setToPlanet(octopus);
        ticket.setPrice(100.0);

        try {
            ticketService.save(ticket);
            System.out.println("Ticket saved successfully!");
        } catch (IllegalArgumentException e) {
            System.err.println("Error saving ticket: " + e.getMessage());
        }

        transaction.commit();
        session.close();
        hibernateConfig.close();
    }
}

