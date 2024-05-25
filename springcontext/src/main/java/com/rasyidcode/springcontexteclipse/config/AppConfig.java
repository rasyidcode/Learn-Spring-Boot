package com.rasyidcode.springcontexteclipse.config;

import com.rasyidcode.springcontexteclipse.beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyBean myBean() {
        MyBean b = new MyBean();
        b.setMessage("Hello");
        return b;
    }

}
