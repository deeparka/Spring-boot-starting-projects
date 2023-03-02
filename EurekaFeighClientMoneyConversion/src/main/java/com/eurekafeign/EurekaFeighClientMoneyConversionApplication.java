package com.eurekafeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient		// This annotation lists the application on the eureka server.
@EnableFeignClients	// This annotation enables feign client.
@EnableCircuitBreaker		// This annotation enables the circuit breaker for the microservice.
public class EurekaFeighClientMoneyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaFeighClientMoneyConversionApplication.class, args);
	}

}
