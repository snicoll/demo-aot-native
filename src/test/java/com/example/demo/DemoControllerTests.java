package com.example.demo;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class DemoControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void helloWithNoMode() throws Exception {
		this.mockMvc.perform(get("/hello")).andExpect(status().isOk())
				.andExpect(jsonPath("message").value("No option provided"));
	}

	@Test
	void helloWithBeanMode() throws Exception {
		this.mockMvc.perform(get("/hello").param("mode", "bean")).andExpect(status().isOk())
				.andExpect(jsonPath("message").value("No bean found"));
	}

	@Test
	void helloWithReflectionMode() throws Exception {
		this.mockMvc.perform(get("/hello").param("mode", "reflection")).andExpect(status().isOk())
				.andExpect(jsonPath("message").value("Hello Native"));
	}

	@Test
	void helloWithResourceMode() throws Exception {
		this.mockMvc.perform(get("/hello").param("mode", "resource")).andExpect(status().isOk())
				.andExpect(jsonPath("message").value("[] Hello Native"));
	}

	@Test
	void helloWithUnknownMode() throws Exception {
		this.mockMvc.perform(get("/hello").param("mode", "does-not-exist")).andExpect(status().isOk())
				.andExpect(jsonPath("message").value("Unknown mode: does-not-exist"));
	}

}
