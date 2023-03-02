package com.eurekazuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient // This annotation lists the application on the eureka server.
@EnableZuulProxy  // This annotation enables the zuul gateway.
public class EurekaZuulMoneyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaZuulMoneyConversionApplication.class, args);
	}

}
