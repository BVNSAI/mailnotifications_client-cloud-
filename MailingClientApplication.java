package com.vedams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MailingClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailingClientApplication.class, args);
	}
}
