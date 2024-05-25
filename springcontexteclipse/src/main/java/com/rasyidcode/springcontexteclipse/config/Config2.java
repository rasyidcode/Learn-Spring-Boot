package com.rasyidcode.springcontexteclipse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rasyidcode.springcontexteclipse.beans.MyBean;

@Configuration
public class Config2 {

	@Bean
	public MyBean myBean() {
		MyBean b = new MyBean();
		b.setText("Hello Bean");
		return b;
	}

	@Bean
	public MyBean myBean2() {
		MyBean b = new MyBean();
		b.setText("Hello Bean 2");
		return b;
	}
}
