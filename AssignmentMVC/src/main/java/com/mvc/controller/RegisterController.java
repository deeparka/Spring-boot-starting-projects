package com.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class RegisterController {
	
	@RequestMapping(value = "/submitRegisterForm", method = RequestMethod.GET)
	public String init(Model model) {
//		model.addAttribute("msg", "Please Enter Your Login Details");
		return "register";
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public String register(Model model, @ModelAttribute("registerBean") RegisterBean registerBean) {
		
		if (registerBean != null && registerBean.getUsername() != null && registerBean.getPassword() != null
				&& registerBean.getAge() != 0 && registerBean.getFirstName() != null && registerBean.getLastName() != null
				&& registerBean.getEmail()!= null && registerBean.getEmailPassword() != null) {
			
				model.addAttribute("username", registerBean.getUsername());
				model.addAttribute("registerText", "You are successfully Registered");
				return "welcome";
				
			} else {
				model.addAttribute("error", "Please enter Details");
				return "register";
		}
		
	}
	
}
