package com.rasyidcode.spring_security_experiment_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class SpringSecurityExperiment1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityExperiment1Application.class, args);
	}

//    @Bean
//    MyLoggingFilter loggingFilter() {
//		return new MyLoggingFilter();
//	}

//    @Bean
//    FilterRegistrationBean<MyLoggingFilter> loggingFilterBean() {
//    	FilterRegistrationBean<MyLoggingFilter> registrationBean = new FilterRegistrationBean<>();
//    	registrationBean.setFilter(new MyLoggingFilter());
//    	registrationBean.addUrlPatterns("/*");
//    	return registrationBean;
//    }

//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.addFilterBefore(new MyLoggingFilter(), AuthorizationFilter.class);
//		return http.build();
//	}

	@GetMapping("/")
	public String home() {
		return "home";
	}

}
