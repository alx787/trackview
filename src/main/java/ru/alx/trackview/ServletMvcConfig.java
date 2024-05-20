package ru.alx.trackview;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "ru.alx.trackview"  })
public class ServletMvcConfig implements WebMvcConfigurer {
    // Configuration to render VIEWS
    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.jsp("/WEB-INF/views/", ".jsp");
        registry.jsp("/WEB-INF/", ".jsp");
    }

    // Configuration to render STATIC CONTENTS (IMAGE, CSS, JS)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // Register resource handler for -

        // IMAGES
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/resources/images/");

        // CSS
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/resources/css/");

        // JAVASCRIPT
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/resources/js/");
    }
}
