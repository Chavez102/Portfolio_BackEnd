package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages="com.example")
public class PortfolioBackEndApplication {

	public static void main(String[] args) {
		System.out.println("GETS HEREfdlllllllll");
		SpringApplication.run(PortfolioBackEndApplication.class, args);
	}

}
