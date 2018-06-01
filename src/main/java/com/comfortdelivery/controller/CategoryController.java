package com.comfortdelivery.controller;

import com.comfortdelivery.entity.Category;
import com.comfortdelivery.entity.Product;
import com.comfortdelivery.model.OrderBin;
import com.comfortdelivery.service.CategoryService;
import com.comfortdelivery.service.ProductService;
import org.jboss.jandex.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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

    /*
    @RequestMapping(path = "/{category}")
    public String getSubcategories(@PathVariable String category) {
        return "testMap";
    }
    */

}
