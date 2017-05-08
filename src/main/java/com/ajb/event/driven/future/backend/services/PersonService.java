package com.ajb.event.driven.future.backend.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajb.event.driven.future.backend.model.Person;
import com.ajb.event.driven.future.backend.repositories.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepo;
	
	public PersonService() {}
	
	@Autowired
	public PersonService(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	public List<Person> listAll() {
		return personRepo.findAll();
	}
	
	public Person save(Person person) {
		person.setId(UUID.randomUUID());
		return personRepo.save(person);
	}

}
