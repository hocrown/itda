package com.project.itda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ItdaApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ItdaApplication.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("resource 등록");
        registry.addResourceHandler("/vue/**").addResourceLocations("/WEB-INF/vue-dist/");
    }

}
