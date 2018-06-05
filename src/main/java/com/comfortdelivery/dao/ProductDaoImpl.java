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

    public Product getSingleProduct(long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    public List<Product> getProducts(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product", Product.class);

        return query.getResultList();
    }

    public List<Product> getProductsBySubcategory(String subcategory){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where subcategory = :subcategory", Product.class);
        query.setParameter("subcategory", subcategory);
        return query.getResultList();
    }

    public List<Product> searchProducts(String searchStr, Integer limit){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where lower(productName) like :searchStr", Product.class);
        query.setParameter("searchStr", "%" + searchStr.toLowerCase() + "%");
        if (limit != null) {
            query.setMaxResults(10);
        }
        return query.getResultList();
    }


}
