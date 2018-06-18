package com.comfortdelivery.service;

import com.comfortdelivery.entity.Customer;
import com.comfortdelivery.entity.Order;
import com.comfortdelivery.entity.Product;

import java.util.List;
import java.util.Map;

public interface OrderService {
     List<Order> getOrders();

     Order fillOrder(Map<Product, Integer> binProducts, Customer customer);

     void saveOrder(Order order);
}
