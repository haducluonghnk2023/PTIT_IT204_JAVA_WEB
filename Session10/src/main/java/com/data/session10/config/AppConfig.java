package com.data.session10.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.data.session10.controller",
        "com.data.session10.service",
        "com.data.session10.repository"})
public class AppConfig {
    private String HOST_NAME = "dlcfbiayq";
    private String API_KEY = "981361598332755";
    private String API_SECRET = "snRChEj-CEdwkZROh-Zt1RlW64E";

    @Bean
    public ViewResolver viewResolver() {
        org.springframework.web.servlet.view.InternalResourceViewResolver resolver = new org.springframework.web.servlet.view.InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1024 * 1024 * 10); // 10MB
        return multipartResolver;
    }

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", HOST_NAME,
                "api_key", API_KEY,
                "api_secret", API_SECRET,
                "secure", true
        ));
    }
}
