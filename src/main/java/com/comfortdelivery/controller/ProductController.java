package com.comfortdelivery.controller;

import com.comfortdelivery.entity.Product;
import com.comfortdelivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/{category}")
public class ProductController {

    private ProductService productService;

    ProductController(@Autowired ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path = "/{subcategory}")
    public String getProductsBySubcategory(@PathVariable String category, @PathVariable String subcategory, Model model) {
        List<Product> products = productService.getProductsBySubcategory(subcategory);
        model.addAttribute("products", products);
        model.addAttribute("subcategoryName", subcategory);
        return "product-list";
    }
}
