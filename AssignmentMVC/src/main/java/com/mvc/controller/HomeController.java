package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/login")
	public String display() {
		return "submitLoginForm";
	}
	
	@RequestMapping("/register")
	public String display_register() {
		return "submitRegisterForm";
	}
}
