package com.comfortdelivery.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
    @SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "order_sum")
    private long orderSum;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "status")
    private long status;

    @Column(name = "delivery_address")
    private String address;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                          CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "ordered_products",
               joinColumns = @JoinColumn(name = "order_id"),
               inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public long getOrderId() {
        return orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(long orderSum) {
        this.orderSum = orderSum;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatusAsString() {
        //Todo маппинг по сути, может какой-другой вариант есть?;
        return null;
    }

    public void addProduct(Product product) {
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
    }

    public void removeProduct(Product product) {
        //todo когда буду делать корзину
    }
}
