package com.eurekaety.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ety")
public class ETY {
	@GetMapping(value = "/convert/{count}")
	public double convertor(@PathVariable(name = "count") double count) {
		double EURO;
		double YEN;
		
		EURO = count;
		YEN = EURO * 145.05;
		
		return YEN;
	}
}
