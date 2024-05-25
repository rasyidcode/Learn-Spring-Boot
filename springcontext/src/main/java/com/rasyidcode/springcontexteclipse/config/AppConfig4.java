package com.rasyidcode.springcontexteclipse.config;

import com.rasyidcode.springcontexteclipse.beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig4 {

    @Bean(name = "mybean1")
    public MyBean myBean() {
        MyBean b = new MyBean();
        b.setMessage("Hello");
        return b;
    }

    @Bean(name = "mybean2")
    public MyBean myBean2() {
        MyBean b2 = new MyBean();
        b2.setMessage("World");
        return b2;
    }

}
