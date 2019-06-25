package com.proman.frontend.config;

import com.proman.security.config.WebMvcConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@EnableWebMvc
@Configuration
public class MvcConfig extends WebMvcConfig {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/front-end/static/**").addResourceLocations("/front-end/my-app/src/");
        registry.addResourceHandler("/front-end/*.js").addResourceLocations("/front-end/my-app/");
        registry.addResourceHandler("/front-end/*.json").addResourceLocations("/front-end/my-app/");
        registry.addResourceHandler("/front-end/*.ico").addResourceLocations("/front-end/my-app/");
        registry.addResourceHandler("/index.html").addResourceLocations("/front-end/my-app/public/index.html");
    }
}