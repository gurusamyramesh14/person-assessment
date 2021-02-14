//package com.embl.assessment.configuration;
//
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * Configuration class for the Application Web Module
// */
//@Configuration @EnableWebMvc @ComponentScan public class ApplicationWebConfig implements WebMvcConfigurer {
//    
//    /**
//     * Method for adding the resource handlers
//     */
//    @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("/");
//    }
//    
//    /**
//     * Method for adding the view controllers
//     */
//    @Override public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addRedirectViewController("/", "index.html");
//    }
//}
