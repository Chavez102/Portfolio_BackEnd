package com.example.demo;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages="com.example")
public class PortfolioBackEndApplication {

	public static void main(String[] args) {
		
//		 Map<String, String> env_var = System.getenv();
//
//	        // Loop through all environment variables
//	        for (String envName : env_var.keySet()) {
//	            // Print environment variable name and value to console
//	            System.out.format("%s = %s", envName, env_var.get(envName));
//	            System.out.println();
//	        }
//		
//		
//		String fromUser= System.getenv("PORTFOLIO_GMAIL_USERNAME");
//		String fromUserPassword= System.getenv("PORTFOLIO_GMAIL_PASSWORD");
//		System.out.println("fromUser: "+ fromUser);
//		System.out.println("fromUserPassword: "+ fromUserPassword);
		
		
		SpringApplication.run(PortfolioBackEndApplication.class, args);
	}

}
