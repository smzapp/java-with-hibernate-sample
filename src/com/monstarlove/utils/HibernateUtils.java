package com.monstarlove.utils;

import com.monstarlove.config.FileConfig;
import com.monstarlove.entities.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    public static Session buildSession() {
        try {
            SessionFactory factory = new Configuration()
                    .configure(FileConfig.HIBERNATE_FILE)
                    .addAnnotatedClass(Category.class)
                    .buildSessionFactory();
            return factory.getCurrentSession();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
