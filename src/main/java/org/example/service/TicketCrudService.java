package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.model.Ticket;

import java.util.List;

public class TicketCrudService {
    private EntityManager entityManager;

    public TicketCrudService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void save(Ticket ticket) {
        if (ticket.getClient() == null || entityManager.find(Ticket.class, ticket.getClient().getId()) == null) {
            throw new IllegalArgumentException("Invalid or null client");
        }
        if (ticket.getFromPlanet() == null || entityManager.find(Ticket.class, ticket.getFromPlanet().getId()) == null) {
            throw new IllegalArgumentException("Invalid or null planet");
        }
        if (ticket.getToPlanet() == null || entityManager.find(Ticket.class, ticket.getToPlanet().getId()) == null) {
            throw new IllegalArgumentException("Invalid or null planet");
        }
        entityManager.persist(ticket);
    }
    public Ticket findById(Long id) {
        return entityManager.find(Ticket.class, id);
    }
    public List<Ticket> findAll() {
        return entityManager.createQuery("SELECT t from Ticket t", Ticket.class).getResultList();
    }

    public void delete(Long id) {
        Ticket ticket = findById(id);
        entityManager.remove(ticket);
    }
}
