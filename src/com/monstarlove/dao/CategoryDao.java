package com.monstarlove.dao;

import com.monstarlove.entities.Category;
import com.monstarlove.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDao {

    private Session session;

    public List<Category> getResult() {
        try {
            String hql = "FROM Category";
            session = HibernateUtils.buildSession();
            session.beginTransaction();
            Query query = session.createQuery(hql);
            List<Category> result = query.list();
            this.session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
