package com.eurekafeign.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "conversion")
public interface MoneyConversionClient {
	@GetMapping(value= "/itd/convert/{count}")
	public double getConversionResult(@PathVariable(name= "count") double count);
}
