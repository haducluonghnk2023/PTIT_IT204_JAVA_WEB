package com.data.session09.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.data.session09.controller",
        "com.data.session09.service",
        "com.data.session09.repository"})
public class AppConfig {

    @Bean
    public ViewResolver viewResolver() {
        org.springframework.web.servlet.view.InternalResourceViewResolver resolver = new org.springframework.web.servlet.view.InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
