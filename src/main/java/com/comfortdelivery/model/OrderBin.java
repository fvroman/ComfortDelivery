package com.comfortdelivery.model;

import com.comfortdelivery.entity.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

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
