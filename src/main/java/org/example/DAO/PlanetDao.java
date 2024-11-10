package org.example.DAO;


import org.example.config.HibernateConfig;
import org.example.model.Planet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PlanetDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    public void createPlanet(String name) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = new Planet();
            planet.setName(name);
            session.persist(planet);
            transaction.commit();
        }
    }

    public Planet getPlanet(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public void updatePlanet(Long id, String newName) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                planet.setName(newName);
                session.persist(planet);
                transaction.commit();
            }
        }
    }

    public void deletePlanet(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            if (planet != null) {
                session.delete(planet);
                transaction.commit();
            }
        }
    }
}

