package com.backbase.bank;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@ComponentScan({"com.backbase.controller", "com.backbase.bank.services",
        "com.backbase.bank.configuration", "com.backbase.infrastrcture"})
public class AtmFinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtmFinderApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() throws Exception {


        RestTemplate restTemplate = new RestTemplate();

        return restTemplate;
    }
}
