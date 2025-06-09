package com.example;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Numerology API",
                description = "API for calculating and managing numerology profiles"
        )
)
@SpringBootApplication
public class NumerologyApp {
    public static void main(String[] args) {
        SpringApplication.run(NumerologyApp.class, args);
    }
}