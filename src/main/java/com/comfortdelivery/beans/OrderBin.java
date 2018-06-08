package com.comfortdelivery.beans;

import com.comfortdelivery.entity.Product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderBin {

    private LinkedHashMap<Product,Integer> products;
    private Integer total;
    OrderBin() {

    }

    OrderBin(LinkedHashMap<Product,Integer> products) {
        this.products = products;
    }

    public void add(Product product) {
        if (products == null) {
            products = new LinkedHashMap<>();
        }
        products.merge(product, 1, (oldVal, newVal) -> oldVal + newVal);
    }
    //TODO SHIT CODE CHANGE
    public void remove(Product product) {
        products.remove(product);
    }

    public void decreaseAmount(Product product) {
        products.merge(product, 1, (oldVal, newVal) ->  oldVal - newVal);
        if (products.get(product) == 0) {
            remove(product);
        }
    }

    public void clear() {
        this.products = null;
    }

    private void calculateTotal() {
        total = 0;
        if (products != null) {
            for (Map.Entry<Product,Integer> entry : products.entrySet()){
                total += entry.getKey().getPrice() * entry.getValue();
            }
        }  else {
            total = 0;
        }
    }

    public Map<Product,Integer> getProducts() {
        return this.products;
    }

    public Integer getTotal() {
        calculateTotal();
        return total;
    }
}