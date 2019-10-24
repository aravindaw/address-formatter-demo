package com.aravinda.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Springboot application starting point.
 *
 * @author Aravinda Weerasekara
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    /**
     * <p>Main mathod
     * </p>
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
