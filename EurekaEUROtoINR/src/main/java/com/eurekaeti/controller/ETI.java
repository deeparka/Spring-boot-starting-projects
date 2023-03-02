package com.eurekaeti.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/eti")
public class ETI {
	@GetMapping(value = "/convert/{count}")
	public double convertor(@PathVariable(name = "count") double count) {
		double EURO;
		double INR;
		
		EURO = count;
		INR = EURO * 87.78;
		
		return INR;
	}
}
