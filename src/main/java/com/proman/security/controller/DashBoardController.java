package com.proman.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoardController {
    @GetMapping(value = "/dashboard")
    public String dashboard() {
        return "index";
    }

}
