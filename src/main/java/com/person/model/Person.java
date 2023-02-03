package com.person.model;

public class Person {
	private int id;
	private String name;
	private String lastname;
	private String zipcode;
	private String city;
	private String color;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastname() {
		return lastname;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getCity() {
		return city;
	}

	public String getColor() {
		return color;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setColor(String color) {
		// removes all whitespaces and non-visible characters
		color = color.replaceAll("\\s+", "");

		switch (color) {
		case "1":
			this.color = "blau";
			break;
		case "2":
			this.color = "grün";
			break;
		case "3":
			this.color = "violett";
			break;
		case "4":
			this.color = "rot";
			break;
		case "5":
			this.color = "gelb";
			break;
		case "6":
			this.color = "türkis";
			break;
		case "7":
			this.color = "weiß";
			break;
		}
	}
}