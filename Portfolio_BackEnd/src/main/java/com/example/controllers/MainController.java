package com.example.controllers;

import java.io.IOException;
 
import javax.mail.MessagingException;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Email;
import com.example.models.Response;
import com.example.models.MailMessage;



@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "true")
@RestController

public class MainController {
	
	@Autowired
	Email email;
	
	
	@GetMapping("/home")
	public ResponseEntity<Response> hello(){ 
		
		Response myresponse=new Response("ACCEPTING CHANGES FROM BACK");
		System.out.println("GET REQUEST");
		 
		return ResponseEntity.ok(myresponse);
	}
	
	
	@PostMapping("/email")
	public ResponseEntity<Response> email(@RequestBody MailMessage message ) throws MessagingException, IOException{ 
			
			Response myresponse=new Response("ACCEPTING CHANGES FROM BACK"); 
			System.out.println("Trying to send email");		
			
			String from =message.getEmail();
 
			 
			email= new Email(from,message);
			
			email.sendEmail(); 
			
			return ResponseEntity.ok(myresponse);
		}


	
	


}
