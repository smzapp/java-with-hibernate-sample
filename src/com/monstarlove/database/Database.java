package com.monstarlove.database;

import com.monstarlove.config.FileConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Created by Samuel Amador
 */
public class Database {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction = null;
    private Object model;

    public Database(){
        super();
        this.init();
    }

    public Database(Object table) {
        this.model = table;
        this.init();
    }

    public void init() {
        try {
            this.factory = new Configuration()
                    .configure(FileConfig.HIBERNATE_FILE)
                    .addAnnotatedClass(this.model.getClass())
                    .buildSessionFactory();
            this.session = this.factory.getCurrentSession();
            this.transaction = session.beginTransaction();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert() {
        try {
            this.session.save(this.model);
            this.session.getTransaction().commit();
        } catch(Exception e) {
            if (this.transaction != null) {
                this.transaction.rollback();
            }
        } finally {
            this.factory.close();
        }
    }

    public int delete(int id) {
        try {
            String hql = "delete from " + this.model.getClass().getSimpleName() + " where id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            int result = query.executeUpdate();
            session.getTransaction().commit();
            return result;
        } catch(Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return 0;
        } finally {
            this.factory.close();
        }
    }

}
