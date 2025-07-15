package com.example.SpringSecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping()
    public String home(HttpServletRequest request){
        return "Home Page "+request.getSession().getId();
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello User";
    }

    @GetMapping("/about")
    public  String aboutUs(){
        return "Tamilarasan!";
    }
}
