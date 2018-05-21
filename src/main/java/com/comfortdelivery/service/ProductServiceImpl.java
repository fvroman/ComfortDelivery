package com.comfortdelivery.service;

import com.comfortdelivery.dao.ProductDao;
import com.comfortdelivery.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDao productDao;
    ProductServiceImpl(@Autowired ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

}
