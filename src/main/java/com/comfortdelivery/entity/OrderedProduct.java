package com.comfortdelivery.entity;

import javax.persistence.*;

@Entity
@Table(name="ordered_products")
public class OrderedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordered_product_seq")
    @SequenceGenerator(name = "ordered_product_seq", sequenceName = "ordered_product_seq", initialValue = 10000, allocationSize = 1)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private long quantity;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
