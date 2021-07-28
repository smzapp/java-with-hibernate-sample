package com.monstarlove.dao;

import com.monstarlove.config.FileConfig;
import com.monstarlove.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CategoryDao {

    private final SessionFactory factory;
    private Transaction transaction = null;

    public CategoryDao() {
        this.factory = new Configuration()
                .configure(FileConfig.HIBERNATE_FILE)
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();
    }

    public void insert() {
        try {
            Session session = this.factory.getCurrentSession();
            Customer customer = new Customer("Sam","Sam@test.com","1234");
            transaction = session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        } catch(Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            this.factory.close();
        }
    }
}
