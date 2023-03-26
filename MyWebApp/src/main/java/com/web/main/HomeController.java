package com.web.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	
	@GetMapping("/homepage")
	public ModelAndView run(Student student) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("object", student);
		
		mv.setViewName("home");
		
		System.out.println(student.getSid());
		System.out.println(student.getSname());
		System.out.println(student.getLang());
		
		return mv;
	}
}
