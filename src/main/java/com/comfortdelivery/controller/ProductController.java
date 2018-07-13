package com.comfortdelivery.controller;

import com.comfortdelivery.entity.Product;
import com.comfortdelivery.filters.PriceFilter;
import com.comfortdelivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/{category}")
public class ProductController {

    private ProductService productService;

    private static final int productsOnPage = 20;

    ProductController(@Autowired ProductService productService) {
        this.productService = productService;
    }

    //todo фильтр
    @RequestMapping(path = "/{subcategory}")
    public String getProductsBySubcategory(@PathVariable String subcategory, @RequestParam(required = false) Integer page,
                                           Model model) {

        List<Product> products;
        int minPrice;
        int maxPrice;


        products = productService.getProductsBySubcategory(subcategory);
        minPrice = productService.getMinimumPrice(products);
        maxPrice = productService.getMaximumPrice(products);


        PagedListHolder<Product> pagedListHolder = new PagedListHolder<>(products);
        pagedListHolder.setPageSize(productsOnPage);

        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(0);
            model.addAttribute("products", pagedListHolder.getPageList());
        } else {
            pagedListHolder.setPage(page - 1);
            model.addAttribute("products", pagedListHolder.getPageList());
        }

        model.addAttribute("page", page);
        model.addAttribute("maxPage", pagedListHolder.getPageCount());
        model.addAttribute("subcategoryName", subcategory);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        return "product-list";
    }


}
