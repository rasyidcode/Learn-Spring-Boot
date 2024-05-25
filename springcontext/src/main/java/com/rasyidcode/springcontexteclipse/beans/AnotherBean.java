package com.rasyidcode.springcontexteclipse.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class AnotherBean {

    private String message;

    @PostConstruct
    private void init() {
        this.message = "Hello from AnotherBean";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
