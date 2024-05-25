package com.rasyidcode.springcontexteclipse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rasyidcode.springcontexteclipse.beans.MyBean;

@Configuration
public class Config3 {

	@Bean(name = "mybean1")
	public MyBean myBean() {
		MyBean b = new MyBean();
		b.setText("Hello Bean");
		return b;
	}

	@Bean(name = "mybean2")
	public MyBean myBean2() {
		MyBean b = new MyBean();
		b.setText("Hello Bean 2");
		return b;
	}
}
