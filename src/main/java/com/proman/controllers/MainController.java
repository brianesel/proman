package com.proman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@CrossOrigin(origins = "*")
@RestController
public class MainController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public RedirectView login(Model model) {
        System.out.println("hello");
        return new RedirectView("index");
    }

    @RequestMapping("/user")
    public String userIndex() {
        System.out.println("hi");
        return "hello";
    }
}