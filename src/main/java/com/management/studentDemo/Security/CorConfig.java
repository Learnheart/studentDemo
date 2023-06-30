package com.management.studentDemo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorConfig {

    private static final String GET = "GET";
    private static final String POST = "POST";
    private static final String DELETE = "DELETE";
    private static final String PUT = "PUT";

    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**")
                        .allowedMethods(GET, POST, DELETE, PUT)
                        .allowedHeaders("*")
                        .allowedOriginPatterns("*") //specifies the domains/origins that are allowed to make cross-origin requests.
                        //specifies if credentials such as cookies or authorization headers are allowed for cross-origin requests.
                        .allowCredentials(true);
            }
        };
    }
}

