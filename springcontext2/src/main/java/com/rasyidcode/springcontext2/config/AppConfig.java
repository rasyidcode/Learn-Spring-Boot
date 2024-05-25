package com.rasyidcode.springcontext2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = {
                "com.rasyidcode.springcontext2.repositories",
                "com.rasyidcode.springcontext2.services"
        }
)
public class AppConfig {
}
