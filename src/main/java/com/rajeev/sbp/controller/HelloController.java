package com.rajeev.sbp.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("/")
    public String index() {
    	logger.debug("Inside index::");
        return "Greetings from Rajeev's Spring Boot App !!";
    }

}