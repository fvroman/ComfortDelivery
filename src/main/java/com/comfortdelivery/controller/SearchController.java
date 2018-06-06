package com.comfortdelivery.controller;

import com.comfortdelivery.entity.Product;
import com.comfortdelivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SearchController {

    private static final Integer AUTOCOMPLETE_LIMIT = 10;

    private ProductService productService;

    SearchController(@Autowired ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getSearchMatches")
    public @ResponseBody
    List<Product> getSearchMatches(@RequestParam("term") String searchStr) {
        return productService.searchProducts(searchStr, AUTOCOMPLETE_LIMIT);
    }

    @GetMapping("/searchProducts")
    public String searchProducts(@RequestParam String searchStr, Model model) {
        List<Product> products = productService.searchProducts(searchStr,null);
        model.addAttribute("products", products);
        return "product-list";
    }
}
