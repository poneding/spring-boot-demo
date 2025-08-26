package com.pding.spring_boot_demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "首页接口")
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "Spring Boot Demo Application";
    }

    @GetMapping("/hello")
    public List<String> hello() {
        return List.of("hello", "world123");
    }

}
