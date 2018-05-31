package com.comfortdelivery.service;

import com.comfortdelivery.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    List<Product> getProductsBySubcategory(String subcategory);
    int getMinimumPrice(List<Product> products);
    int getMaximumPrice(List<Product> products);

}
