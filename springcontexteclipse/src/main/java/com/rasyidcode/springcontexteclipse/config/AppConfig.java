package com.rasyidcode.springcontexteclipse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = {
                "com.rasyidcode.springcontexteclipse.services",
                "com.rasyidcode.springcontexteclipse.repositories"
        }
)
public class AppConfig {

}
