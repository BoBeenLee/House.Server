package com.house.controller;

import com.house.model.Data;
import com.house.model.Scrap;
import com.house.util.JacksonUtils;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class ScrapControllerTests extends AbstractContextControllerTests {
	private MockMvc mockMvc;
	@Autowired
	Environment environment;

	@Before
	public void setup() throws Exception {
		this.mockMvc = ((DefaultMockMvcBuilder) MockMvcBuilders
				.webAppContextSetup(this.wac).alwaysExpect(
						MockMvcResultMatchers.status().isOk())).build();
	}

	public void addScrap() throws Exception {
		Data data = new Data();

		Scrap scrap = getScrap();
		data.body.put("scrap", scrap);

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/add/scrap.app", new Object[0])
						.contentType(MediaType.APPLICATION_JSON)
						.content(JacksonUtils.objectToJson(data).getBytes()))
				.andDo(MockMvcResultHandlers.print());
	}

	public void removeScrap() throws Exception {
		int scrapNo = 1;

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/remove/scrap.app?sno=" + scrapNo,
						new Object[0])).andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void printScrap() throws Exception {
		int scrapNo = 1;

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/get/scrap.app?sno=" + scrapNo,
						new Object[0])).andDo(MockMvcResultHandlers.print());
	}

	public Scrap getScrap() {
		Scrap scrap = new Scrap();

		scrap.setSrcType(2);

		return scrap;
	}
}
