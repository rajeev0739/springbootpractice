package com.rajeev.sbp.controller;



import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Rajeev's Spring Boot App !!";
    }

}