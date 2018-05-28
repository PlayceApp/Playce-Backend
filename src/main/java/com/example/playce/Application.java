package com.example.playce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servelet.config.annotation.CorsRegistry;
import org.springframework.web.servelet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servelet.config.annotation.WebMvcConfigurer;
 

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
           @Override
           public void addCorsMappings(CorsRegistry registry) {
              registry.addMapping("/**");
           }
        }
    }
}
