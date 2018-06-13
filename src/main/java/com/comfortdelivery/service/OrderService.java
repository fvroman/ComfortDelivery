package com.comfortdelivery.service;

import com.comfortdelivery.entity.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getOrders();

    public void saveOrder(Order order);
}
