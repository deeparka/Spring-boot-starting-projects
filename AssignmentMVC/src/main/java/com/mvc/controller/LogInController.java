package com.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LogInController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(Model model) {
		
//		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") LogInBean loginBean) {
		
		if (loginBean != null && loginBean.getUsername() != null && loginBean.getPassword() != null) {
			    
				model.addAttribute("username", loginBean.getUsername());
				model.addAttribute("loginText", "You are logged in");
				return "welcome";
				
		} else {
			
			model.addAttribute("error", "Please enter Details");
			return "login";
			
		}
		
	}
	
}
