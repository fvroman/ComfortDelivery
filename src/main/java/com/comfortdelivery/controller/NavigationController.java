package com.comfortdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    @GetMapping("/delivery")
    public String getDeliveryPage(Model model) {

        return "info-common";
    }

    @GetMapping("/contacts")
    public String getContactsPage(Model model) {

        return "info-common";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {

        return "info-common";
    }
}
