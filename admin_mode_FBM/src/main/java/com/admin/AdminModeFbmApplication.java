package com.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AdminModeFbmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminModeFbmApplication.class, args);
	}

}
