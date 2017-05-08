package com.ajb.event.driven.future.backend.repositories;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.ajb.event.driven.future.backend.model.Person;

public interface PersonRepository extends MongoRepository<Person, Serializable>{

}
