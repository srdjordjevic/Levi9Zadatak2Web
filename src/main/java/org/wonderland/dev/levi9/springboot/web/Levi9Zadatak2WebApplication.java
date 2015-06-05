package org.wonderland.dev.levi9.springboot.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.SpringApplicationConfiguration;

@SpringBootApplication
@EnableConfigurationProperties
@SpringApplicationConfiguration(classes=CustomProperties.class)
public class Levi9Zadatak2WebApplication  {

    public static void main(String[] args) {
        SpringApplication.run(Levi9Zadatak2WebApplication.class, args);
    }

}
