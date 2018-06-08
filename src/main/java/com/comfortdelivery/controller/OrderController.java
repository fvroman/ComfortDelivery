package com.comfortdelivery.controller;

import com.comfortdelivery.entity.Product;
import com.comfortdelivery.beans.OrderBin;
import com.comfortdelivery.service.ProductService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

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
    @ResponseBody
    public ResponseEntity remove(@RequestParam long id) {
        Product product = productService.getSingleProduct(id);
        orderBin.remove(product);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping("/addToBin")
    @ResponseBody
    public ResponseEntity add(@RequestParam long id) {
        Product product = productService.getSingleProduct(id);
        orderBin.add(product);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping("/decreaseAmount")
    @ResponseBody
    public ResponseEntity decrease(@RequestParam long id) {
        Product product = productService.getSingleProduct(id);
        orderBin.decreaseAmount(product);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}