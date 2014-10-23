package com.house.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.house.model.Attach;
import com.house.model.Data;
import com.house.model.Interior;
import com.house.model.Scrap;
import com.house.model.SrcType;
import com.house.model.TransferMultipartFile;
import com.house.util.JacksonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class ScrapControllerTests extends AbstractContextControllerTests {
	private MockMvc mockMvc;

	@Autowired
	Environment environment;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(
				status().isOk()).build();
	}

//	@Test
	public void addScrap() throws Exception {
		Data data = new Data();
		
		Scrap scrap = getScrap();
		data.body.put("scrap", scrap);
		
//		System.out.println(JacksonUtils.objectToJson(data));
		this.mockMvc
				.perform(
						post("/add/scrap.app").contentType(
								MediaType.APPLICATION_JSON).content(
								JacksonUtils.objectToJson(data).getBytes()))
				.andDo(print());
	}
	
//	@Test
	public void removeScrap() throws Exception {
		int scrapNo = 1;
		
		this.mockMvc
				.perform(
						post("/remove/scrap.app?sno=" + scrapNo))
				.andDo(print());
	}
	
	@Test
	public void printScrap() throws Exception {
		int scrapNo = 1;
		
		this.mockMvc
				.perform(
						post("/get/scrap.app?sno=" + scrapNo))
				.andDo(print());
	}

	public Scrap getScrap() {
		Scrap scrap = new Scrap();
		/*
		private int srcType;
		private int srcNo;
		 */
		scrap.setSrcType(SrcType.INTERIOR_TYPE);
//		scrap.setSrcNo(1);
		return scrap;
	}
}
