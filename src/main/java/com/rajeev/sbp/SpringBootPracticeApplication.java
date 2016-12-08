package com.rajeev.sbp;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootPracticeApplication {
	 private static final Logger logger = LoggerFactory.getLogger(SpringBootPracticeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPracticeApplication.class, args);
		
		   logger.error("Message logged at ERROR level");
		   logger.warn("Message logged at WARN level");
		   logger.info("Message logged at INFO level");
		   logger.debug("Message logged at DEBUG level");

	}
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

        	logger.debug("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
            	logger.debug(beanName);
            }

        };
    }
}
