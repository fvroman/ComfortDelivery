package com.comfortdelivery.dao;

import com.comfortdelivery.entity.Product;

import java.util.List;

public interface ProductDao {
    Product getSingleProduct(long id);

    List<Product> getProducts();

    List<Product> searchProducts(String searchStr, Integer limit);

    List<Product> getProductsBySubcategory(String subcategory);
}
