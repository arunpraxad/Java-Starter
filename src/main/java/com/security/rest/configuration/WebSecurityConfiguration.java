package com.security.rest.configuration;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class WebSecurityConfiguration implements ServletContextInitializer, EmbeddedServletContainerCustomizer {


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
    }

//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = null;
//        if (config.getAllowedOrigins() != null && !config.getAllowedOrigins().isEmpty()) {
//            source.registerCorsConfiguration("/api/**", config);
//        }
//        return new CorsFilter(source);
//    }
}
