package com.comfortdelivery.beans;

import com.comfortdelivery.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderBin {

    private List<Product> products;
    private String fucken = "DFFDFDFSDFDS!";
    OrderBin() {

    }

    OrderBin(List<Product> products) {
        this.products = products;
    }

    public void add(Product product) {
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
    }

    public void remove(int productId) {
        products.remove(productId);
    }

    public void clear() {
        this.products = null;
    }

    public List<Product> getProducts() {
        return this.products;
    }
}