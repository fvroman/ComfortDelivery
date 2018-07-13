package com.comfortdelivery.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
    @Value("${contactsTitle}")
    private String contactsTitle;

    @Value("${contactsText}")
    private String contactsText;

    @Value("${deliveryTitle}")
    private String deliveryTitle;

    @Value("${deliveryText}")
    private String deliveryText;

    @Value("${loginTitle}")
    private String loginTitle;

    @Value("${loginText}")
    private String loginText;


    @GetMapping("/delivery")
    public String getDeliveryPage(Model model) {
        model.addAttribute("title", deliveryTitle);
        model.addAttribute("text", deliveryText);
        return "info-common";
    }

    @GetMapping("/contacts")
    public String getContactsPage(Model model) {

        model.addAttribute("title", contactsTitle);
        model.addAttribute("text", contactsText);
        return "info-common";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("title", loginTitle);
        model.addAttribute("text", loginText);
        return "info-common";
    }
}
