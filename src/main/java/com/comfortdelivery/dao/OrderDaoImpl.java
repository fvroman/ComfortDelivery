package com.comfortdelivery.dao;

import com.comfortdelivery.entity.Customer;
import com.comfortdelivery.entity.Order;
import com.comfortdelivery.entity.OrderedProduct;
import com.comfortdelivery.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDaoImpl implements OrderDao{

    private SessionFactory sessionFactory;

    OrderDaoImpl(@Autowired SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Order> getOrders() {
        return null;
    }

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
    }

    @Override
    public Order fillOrder(Map<Product, Integer> binProducts, Customer customer) {
        Order order = new Order();

        List<OrderedProduct> orderedProducts = new ArrayList<>();

        for (Map.Entry<Product, Integer> productEntry : binProducts.entrySet()) {
            OrderedProduct orderedProduct = new OrderedProduct();
            orderedProduct.setProduct(productEntry.getKey());
            orderedProduct.setQuantity(productEntry.getValue());
            orderedProduct.setOrder(order);
            orderedProducts.add(orderedProduct);
        }
        order.setOrderedProducts(orderedProducts);
        order.setAddress("test");
        order.setCustomer(customer);
        order.setOrderSum(orderedProducts.stream().mapToLong(o->o.getProduct().getPrice() * o.getQuantity()).sum());
        order.setOrderDate(new Date());
        order.setStatus(1);
        return order;
    }
}