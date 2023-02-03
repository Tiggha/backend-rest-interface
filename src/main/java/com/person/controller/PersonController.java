package com.person.controller;

import com.person.PersonDataAccess;
import com.person.model.Person;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {
	private final PersonDataAccess personDataAccess;

	public PersonController(PersonDataAccess personDataAccess) {
		this.personDataAccess = personDataAccess;
	}

	@GetMapping
	public List<Person> getAllPersons() {
		return personDataAccess.findAll();
	}

	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable int id) {
		return personDataAccess.findById(id);
	}

	@GetMapping("/color/{color}")
	public List<Person> getPersonsByColor(@PathVariable String color) {
		return personDataAccess.findByColor(color);
	}
}