package com.pding.spring_boot_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "Spring Boot Demo Application";
    }

    @GetMapping("/hello")
    public List<String> hello(){
        return List.of("hello","world123");
    }

}
