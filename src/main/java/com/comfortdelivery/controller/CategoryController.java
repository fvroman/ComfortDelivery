package com.comfortdelivery.controller;

import com.comfortdelivery.entity.Category;
import com.comfortdelivery.entity.Product;
import com.comfortdelivery.service.CategoryService;
import com.comfortdelivery.service.ProductService;
import org.jboss.jandex.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    CategoryController(@Autowired CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/")
    public String home(Model model){
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        return "index";
    }

    @RequestMapping(path = "/{category}")
    public String getSubcategory(@PathVariable String category) {
        return "testMap";
    }

    @RequestMapping(path = "/{category}/{subcategory}")
    public String getSubcategory(@PathVariable String category, @PathVariable String subcategory) {

        return "testMap";
    }
}
