package com.person;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetAllPersons() throws Exception {
		mockMvc.perform(get("/persons")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.[0].id").value(1))
				.andExpect(jsonPath("$.[0].name").value(" Hans")).andExpect(jsonPath("$.[0].lastname").value("Müller"))
				.andExpect(jsonPath("$.[0].zipcode").value("67742"))
				.andExpect(jsonPath("$.[0].city").value("Lauterecken"))
				.andExpect(jsonPath("$.[0].color").value("blau"));
	}

	@Test
	public void testGetPersonWithId5() throws Exception {
		mockMvc.perform(get("/persons/5")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.id").value(5))
				.andExpect(jsonPath("$.name").value(" Jonas")).andExpect(jsonPath("$.lastname").value("Müller"))
				.andExpect(jsonPath("$.zipcode").value("32323")).andExpect(jsonPath("$.city").value("Hansstadt"))
				.andExpect(jsonPath("$.color").value("gelb"));
	}

	@Test
	public void testGetPersonWithColorRot() throws Exception {
		mockMvc.perform(get("/persons/color/rot")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.[0].id").value(4))
				.andExpect(jsonPath("$.[0].name").value(" Milly"))
				.andExpect(jsonPath("$.[0].lastname").value("Millenium"))
				.andExpect(jsonPath("$.[0].zipcode").value("77777")).andExpect(jsonPath("$.[0].city").value("made"))
				.andExpect(jsonPath("$.[0].color").value("rot"));
	}
}
