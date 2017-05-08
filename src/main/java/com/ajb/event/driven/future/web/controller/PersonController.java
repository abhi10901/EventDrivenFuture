package com.ajb.event.driven.future.web.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajb.event.driven.future.backend.model.Person;
import com.ajb.event.driven.future.backend.services.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
	private PersonService personService;
	private static final Logger log = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping
	public List<Person> getAllPersons() {
		return personService.listAll();
	}
	
	@PostMapping
	public Person createPerson(@RequestBody Person newPerson) {
		log.info("Before : " + newPerson);
		
		Person createdPerson = personService.save(newPerson);
		
		log.info("After : " + createdPerson);
		return createdPerson;
	}
}
