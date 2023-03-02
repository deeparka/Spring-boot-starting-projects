package com.eurekafeign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


//Application url - localhost:9197/feign/getConversionResult/2

@RestController
@RequestMapping(value= "/feign")
public class FeignClientController {
	
	@Autowired
	MoneyConversionClient moneyconversionclient;
	
	@GetMapping(value="/getConversionResult/{count}", produces= MediaType.APPLICATION_JSON_VALUE)
	@HystrixCommand(fallbackMethod= "defaultResponse")
	public ResponseEntity<Double> getConvertedmoneyAndUserInfoViaFeign(@PathVariable(name= "count") double count) {
		System.out.println("Using the feign client controller to fetch the money to be converted for locale: " + count);

		// Fetching the converted money salutation for the given locale. 
		// Data is fetched from the itd, eti, ety microservices hosted on port no. - 8183, 8184, 8185
		double convertedMoney = moneyconversionclient.getConversionResult(count);
		System.out.println("Old money: " + count + ", new money: " + convertedMoney);

		// Sending the response
		return new ResponseEntity<Double>(convertedMoney, HttpStatus.OK);
	}
	
	// When we define a fallback-method, the fallback-method must match the same parameters of the method where you define the Hystrix Command using the hystrix-command annotation.
	public ResponseEntity<String> defaultResponse(String err) {
		System.out.println("Not able to convert currency as microservice is down.");
		err = "Fallback error as the microservice is down.";
		return new ResponseEntity<String>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
