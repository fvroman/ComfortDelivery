package com.comfortdelivery.dao;

import com.comfortdelivery.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    private SessionFactory sessionFactory;

    CategoryDaoImpl(@Autowired SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Category> getCategories() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Category ", Category.class);
        return query.getResultList();
    }
}
