package com.comfortdelivery.service;

import com.comfortdelivery.dao.ProductDao;
import com.comfortdelivery.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;
    ProductServiceImpl(@Autowired ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public Product getSingleProduct(long id) {
        return productDao.getSingleProduct(id);
    }

    @Override
    @Transactional
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    @Transactional
    public List<Product> getProductsBySubcategory(String subcategory){
        return productDao.getProductsBySubcategory(subcategory);
    }

    @Override
    @Transactional
    public List<Product> searchProducts(String searchStr, Integer limit){
        return productDao.searchProducts(searchStr, limit);
    }

    public int getMinimumPrice(List<Product> products) {
        return products.stream().mapToInt(Product::getPrice).min().orElse(0);
    }

    public int getMaximumPrice(List<Product> products) {
        return products.stream().mapToInt(Product::getPrice).max().orElse(0);
    }
}
