package org.example.DAO;

import org.example.config.HibernateConfig;
import org.example.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientDao {
    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    public void createClient(String name){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Client client = new Client();
            client.setName(name);
            session.persist(client);
            transaction.commit();
        }
    }
    public Client getClient(String name){
        try(Session session = sessionFactory.openSession()){
            return session.get(Client.class, name);
        }
    }

    public void updateClient(Long id, String newName){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client != null){
                client.setName(newName);
                session.persist(client);
                transaction.commit();
            }
        }
    }
    public void deleteClient(Long id){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class, id);
            if (client != null){
                session.delete(client);
                transaction.commit();
            }
        }
    }

}