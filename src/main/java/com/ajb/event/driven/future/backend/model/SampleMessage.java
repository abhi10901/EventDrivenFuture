package com.ajb.event.driven.future.backend.model;

public class SampleMessage {

	private String message;
	
	public SampleMessage() {}
	
	public SampleMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
