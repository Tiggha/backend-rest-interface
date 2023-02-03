package com.person.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.person.PersonDataAccess;
import com.person.model.Person;

@Service
public class PersonCSVDataAccess implements PersonDataAccess {
	private List<Person> persons;

	public PersonCSVDataAccess() throws IOException {
		this.persons = parseCSVFile("src/main/java/com/person/sample-input.csv");
	}

	private List<Person> parseCSVFile(String fileName) throws IOException {
		List<Person> persons = new ArrayList<>();
		try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
			String[] line;
			int lineNumber = 0;
			while ((line = reader.readNext()) != null) {

				// ignore faulty/missing data
				if (line.length != 4)
					continue;

				if (lineNumber == 0) {
					lineNumber++;
				}

				String zipcode_city = line[2];
				String zipcode_split = zipcode_city.split(" ")[1];
				String city_split = zipcode_city.split(" ")[2];

				Person person = new Person();
				person.setId(lineNumber++);
				person.setLastname(line[0]);
				person.setName(line[1]);
				person.setZipcode(zipcode_split);
				person.setCity(city_split);
				person.setColor(line[3]);
				persons.add(person);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persons;
	}

	@Override
	public List<Person> findAll() {
		return persons;
	}

	@Override
	public Person findById(int id) {
		return persons.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	}

	@Override
	public List<Person> findByColor(String color) {
		return persons.stream().filter(p -> p.getColor().equals(color)).collect(Collectors.toList());
	}
}
