package com.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Response;

@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "true")
@RestController

public class MainController {
	
	
	@GetMapping("/home")
	public ResponseEntity<Response> hello(){ 
		
		Response myresponse=new Response("ACCEPTING CHANGES FROM BACK");
		System.out.println("GET REQUEST");
		
		
		
		return ResponseEntity.ok(myresponse);
	}

}
