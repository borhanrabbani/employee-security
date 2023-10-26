package com.spring.security.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	
	@GetMapping("/showMyLoginPage")
	public String shoMyLoginPage() {
		return "plain-login";
	}
	
	@GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";
    }
}
