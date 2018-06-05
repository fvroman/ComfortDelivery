package com.comfortdelivery.controller;

import com.comfortdelivery.entity.Product;
import com.comfortdelivery.beans.OrderBin;
import com.comfortdelivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    private OrderBin orderBin;

    private ProductService productService;
    OrderController(@Autowired OrderBin orderBin, @Autowired ProductService productService) {
        this.orderBin = orderBin;
        this.productService = productService;
    }

    @RequestMapping("/deleteFromBin")
    public String remove(@RequestParam int id, HttpServletRequest request) {
        orderBin.remove(id);
        String referer = request.getHeader("Referer");
        //todo  Временный костыль, потом сделаю интерцептор
        return "redirect:/" + referer.substring(22,referer.length());
    }

    @RequestMapping("/addToBin")
    public String add(@RequestParam long id, HttpServletRequest request) {
        Product product = productService.getSingleProduct(id);
        orderBin.add(product);
        String referer = request.getHeader("Referer");
        //todo  Временный костыль, потом сделаю интерцептор
        return "redirect:/" + referer.substring(22,referer.length());
    }


}
