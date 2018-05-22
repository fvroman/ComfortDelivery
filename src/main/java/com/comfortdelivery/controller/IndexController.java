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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    private CategoryService categoryService;

    IndexController(@Autowired CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/")
    public String home(Model model){
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        return "index";
    }
}
