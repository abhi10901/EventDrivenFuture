package com.ajb.event.driven.future.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajb.event.driven.future.backend.model.SampleMessage;

@RestController
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping
	public String getMessage() {
		return "Hello World";
	}

	@GetMapping("/message")
	public SampleMessage getSampleMessage() {
		return new SampleMessage("Hello Abhishek is here...!");
	}
}
