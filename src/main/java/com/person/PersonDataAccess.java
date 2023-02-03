package com.person;

import java.util.List;

import com.person.model.Person;

public interface PersonDataAccess {
	List<Person> findAll();

	Person findById(int id);

	List<Person> findByColor(String color);
}
