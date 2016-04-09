package com.openfrag.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by tmaffia on 4/9/16.
 */
@Configuration
public class StaticContentConfig extends WebMvcConfigurerAdapter {

    @Value("${static.content.directory}")
    private String STATIC_CONTENT_DIRECTORY;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("file:" + STATIC_CONTENT_DIRECTORY);
    }
}
