package com.comfortdelivery.service;

import com.comfortdelivery.dao.OrderDao;
import com.comfortdelivery.entity.Customer;
import com.comfortdelivery.entity.Order;
import com.comfortdelivery.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;
    OrderServiceImpl(@Autowired OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    @Override
    @Transactional
    public List<Order> getOrders() {
        return orderDao.getOrders();
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        orderDao.saveOrder(order);
    }

    @Override
    @Transactional
    public Order fillOrder(Map<Product, Integer> binProducts, Customer customer) {
        return orderDao.fillOrder(binProducts, customer);
    }

}
