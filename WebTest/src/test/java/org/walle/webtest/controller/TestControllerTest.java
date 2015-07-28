package org.walle.webtest.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.walle.webtest.Application;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class TestControllerTest {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac)
				.alwaysDo(MockMvcResultHandlers.print())
				.alwaysExpect(MockMvcResultMatchers.status().isOk())
				.alwaysExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON + ";charset=UTF-8"))
				.build();
	}
	
	@Test
	public void testQuerySlaMissedTickets() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/querySlaMissedTickets"))
				.andReturn();
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(System.out,
				objectMapper.readTree(mvcResult.getResponse().getContentAsString()));
	}
	
}
