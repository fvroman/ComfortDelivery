package com.comfortdelivery.controller;

import com.comfortdelivery.entity.Customer;
import com.comfortdelivery.entity.Order;
import com.comfortdelivery.entity.OrderedProduct;
import com.comfortdelivery.entity.Product;
import com.comfortdelivery.beans.OrderBin;
import com.comfortdelivery.service.OrderService;
import com.comfortdelivery.service.ProductService;
import com.comfortdelivery.service.ReportService;
import com.sun.deploy.net.HttpResponse;
import org.apache.tools.ant.taskdefs.condition.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

//todo Рефактор корзину через OrderedProduct ?
@Controller
public class OrderController {

    private OrderBin orderBin;

    private ProductService productService;

    private OrderService orderService;

    @Value("#{villages}")
    private Map<String, String> villages;

    OrderController(@Autowired OrderBin orderBin, @Autowired ProductService productService, @Autowired OrderService orderService) {
        this.orderBin = orderBin;
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/deleteFromBin")
    @ResponseBody
    public ResponseEntity remove(@RequestParam long id) {
        Product product = productService.getSingleProduct(id);
        orderBin.remove(product);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/addToBin")
    @ResponseBody
    public ResponseEntity add(@RequestParam long id) {
        Product product = productService.getSingleProduct(id);
        orderBin.add(product);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/decreaseAmount")
    @ResponseBody
    public ResponseEntity decrease(@RequestParam long id) {
        Product product = productService.getSingleProduct(id);
        orderBin.decreaseAmount(product);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/order")
    public String placeOrder(Model model) {
        Customer customer = new Customer();
        if (orderBin.getProducts() == null || orderBin.getProducts().size() == 0) {
            return "redirect:/";
        }
        //todo получать кастомера из сессии (когда будет Security)
        model.addAttribute("customer", customer);
        model.addAttribute("villages", villages);
        return "order-confirmation";
    }

    @RequestMapping("/confirmOrder")
    public String confirmOrder(@ModelAttribute Customer customer, Model model) {
        Order order = orderService.fillOrder(orderBin.getProducts(), customer);
        orderService.saveOrder(order);
        orderBin.clear();
        model.addAttribute("order",order);
        return "success";
    }

    @RequestMapping("/generateReport")
    public ResponseEntity GenerateReport(@RequestParam int orderId, HttpServletRequest request) {
        ReportService.generateAgreement(orderService.getOrder(orderId), request.getServerName());
        return ResponseEntity.ok(HttpStatus.OK);
    }






}