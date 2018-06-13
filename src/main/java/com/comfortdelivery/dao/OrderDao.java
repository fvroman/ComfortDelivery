package com.comfortdelivery.dao;

import com.comfortdelivery.entity.Order;

import java.util.List;

public interface OrderDao {

    public List<Order> getOrders();

    public void saveOrder(Order order);
}
