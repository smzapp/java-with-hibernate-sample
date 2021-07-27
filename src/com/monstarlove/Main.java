package com.monstarlove;

import com.monstarlove.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please");
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Customer.class)
                                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            Customer customer = new Customer("Sam","Sam@test.com","1234");
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
