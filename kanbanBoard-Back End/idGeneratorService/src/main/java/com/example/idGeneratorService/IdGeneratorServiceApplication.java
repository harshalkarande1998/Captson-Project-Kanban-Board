package com.example.idGeneratorService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
public class IdGeneratorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdGeneratorServiceApplication.class, args);
	}


}