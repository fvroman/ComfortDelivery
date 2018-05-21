package com.comfortdelivery.dao;

import com.comfortdelivery.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    private SessionFactory sessionFactory;

    ProductDaoImpl(@Autowired SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Product> getProducts(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product", Product.class);

        return query.getResultList();
    }
}
