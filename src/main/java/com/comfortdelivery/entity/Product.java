package com.comfortdelivery.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
    @Column(name = "product_id")
    private long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private int price;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private List<Feature> features;

    @Column(name = "subcategory")
    private String subcategory;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "ordered_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))

    private List<Order> orders;

    public long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, price);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) return false;
        if (object == this) return true;
        if (!(object instanceof Product)) {
            return false;
        }
        Product otherProduct = (Product) object;
        if (this.productId == (otherProduct.productId)) {
            return true;
        } else {
            return false;
        }
    }
}
