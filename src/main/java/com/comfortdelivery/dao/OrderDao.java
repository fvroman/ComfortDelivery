package com.comfortdelivery.dao;

import com.comfortdelivery.entity.Customer;
import com.comfortdelivery.entity.Order;
import com.comfortdelivery.entity.Product;

import java.util.List;
import java.util.Map;

public interface OrderDao {

    public List<Order> getOrders();

    public Order fillOrder(Map<Product, Integer> binProducts, Customer customer);

    public void saveOrder(Order order);
}
