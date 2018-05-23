package com.comfortdelivery.service;

import com.comfortdelivery.dao.CategoryDao;
import com.comfortdelivery.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;
    CategoryServiceImpl(@Autowired CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    @Transactional
    public List<Category> getCategories() {
        return categoryDao.getCategories();
    }
}
