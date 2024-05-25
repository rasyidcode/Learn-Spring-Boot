package com.rasyidcode.springcontexteclipse.beans;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class AnotherBean {

	private String message;

	@PostConstruct
	private void init() {
		this.message = "Hello From AnotherBean";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
