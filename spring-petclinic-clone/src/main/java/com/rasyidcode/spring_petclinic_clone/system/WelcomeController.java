package com.rasyidcode.spring_petclinic_clone.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}

}
