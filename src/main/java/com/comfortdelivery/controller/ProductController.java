package com.comfortdelivery.controller;

import com.comfortdelivery.entity.Product;
import com.comfortdelivery.model.OrderBin;
import com.comfortdelivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/{category}")
public class ProductController {

    private ProductService productService;
    private OrderBin orderBin;

    ProductController(@Autowired ProductService productService, @Autowired OrderBin orderBin) {
        this.productService = productService;
        this.orderBin = orderBin;
    }

    @GetMapping(path = "/{subcategory}")
    public String getProductsBySubcategory( @PathVariable String subcategory, Model model) {
        List<Product> products = productService.getProductsBySubcategory(subcategory);
        int minPrice = productService.getMinimumPrice(products);
        int maxPrice = productService.getMaximumPrice(products);
        //orderBin.add(products.get(new Random().nextInt(products.size())));

        model.addAttribute("products", products);
        model.addAttribute("subcategoryName", subcategory);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("orderBin", orderBin);
        return "product-list";
    }
}
