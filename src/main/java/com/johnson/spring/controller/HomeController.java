package com.johnson.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/home", "", "/"})
    public String hello(Model model){
        model.addAttribute("user", "johnson arrobo");
        return "home.html";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact.html";
    }

}
