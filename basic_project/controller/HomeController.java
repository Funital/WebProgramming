package com.example.week6.hw06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // GET / → 메인 화면
    @GetMapping("/")
    public String index() {
        return "index";
    }
}