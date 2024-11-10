package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.model.Planet;

import java.util.List;

public class PlanetCrudService {
    private final EntityManager em;

    public PlanetCrudService(EntityManager em) {
        this.em = em;
    }

    public void save(Planet planet) {
        em.persist(planet);
    }

    public Planet findById(String id) {
        return em.find(Planet.class, id);
    }

    public List<Planet> findAll() {
        return em.createQuery("SELECT p FROM Planet p", Planet.class).getResultList();
    }

    public void delete(String id) {
        Planet planet = findById(id);
        if (planet != null) {
            em.remove(planet);
        }
    }
}
