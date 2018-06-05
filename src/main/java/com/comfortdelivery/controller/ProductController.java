package com.comfortdelivery.controller;

import com.comfortdelivery.entity.Product;
import com.comfortdelivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/{category}")
public class ProductController {

    private ProductService productService;

    ProductController(@Autowired ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/{subcategory}")
    public String getProductsBySubcategory( @PathVariable String subcategory, Model model) {
        List<Product> products = productService.getProductsBySubcategory(subcategory);
        int minPrice = productService.getMinimumPrice(products);
        int maxPrice = productService.getMaximumPrice(products);

        model.addAttribute("products", products);
        model.addAttribute("subcategoryName", subcategory);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        return "product-list";
    }

}
