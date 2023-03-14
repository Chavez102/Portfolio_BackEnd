package com.example.models;

public class MailMessage {
	String name="";
	String email="";
	String phone="";
	String location="";
	String message="";
	String subject="";
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return " name=" + name + 
				"\n email=" + email + 
				"\n phone=" + phone + 
				"\n location=" + location +
				"\n message=" + message ;
	}
	
	

}
