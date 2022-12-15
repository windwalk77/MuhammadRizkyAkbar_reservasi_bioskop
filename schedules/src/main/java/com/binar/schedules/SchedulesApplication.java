package com.binar.schedules;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@EnableEurekaClient
@SpringBootApplication
public class SchedulesApplication {
    public static void main(String[] args) {
        SpringApplication.run(SchedulesApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }

}
