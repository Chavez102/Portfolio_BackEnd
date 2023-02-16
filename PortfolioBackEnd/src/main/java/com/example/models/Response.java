package com.example.models;

public class Response {
	String message;

	public Response(String message) {
		super();
		this.message = message;
	}
	public Response() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
