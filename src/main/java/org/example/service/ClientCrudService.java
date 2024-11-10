package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.model.Client;

import java.util.List;

public class ClientCrudService {
    private final EntityManager em;

    public ClientCrudService(EntityManager em) {
        this.em = em;
    }

    public void save(Client client) {
        em.persist(client);
    }

    public Client findById(Long id) {
        return em.find(Client.class, id);
    }

    public List<Client> findAll() {
        return em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }

    public void delete(Long id) {
        Client client = findById(id);
        if (client != null) {
            em.remove(client);
        }
    }
}
