package com.ecom6.common;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Value("${resources.location}")
    private String resourcesLocation;
    @Value("${resources.uri_path}")
    private String resourcesUriPath;
    
    @Autowired
    AuthenticInterceptor authenticInterceptor;
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler(resourcesUriPath + "/**")
    	.addResourceLocations("file:///" + resourcesLocation);
    }
    
    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
         registry.addInterceptor(authenticInterceptor);
    }

}