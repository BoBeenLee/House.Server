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

import com.house.model.Data;
import com.house.model.Sudatalk;
import com.house.model.SudatalkCategory;
import com.house.model.TransferMultipartFile;
import com.house.util.JacksonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class SudatalkCategoryControllerTests extends AbstractContextControllerTests {
	private MockMvc mockMvc;

	@Autowired
	Environment environment;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(
				status().isOk()).build();
	}
	
//	@Test
	public void addSudatalkCategory() throws Exception {
		Data data = new Data();
		
		SudatalkCategory sudatalkCategory = getSudatalkCategory();
		data.body.put("sudatalkcategory", sudatalkCategory);
		
//		System.out.println(JacksonUtils.objectToJson(data));
		this.mockMvc
				.perform(
						post("/add/sudatalkcategory.app").contentType(
								MediaType.APPLICATION_JSON).content(
								JacksonUtils.objectToJson(data).getBytes()))
				.andDo(print());
	}
	
//	@Test
	public void modifySudatalkCategory() throws Exception {
		Data data = new Data();
		
		SudatalkCategory sudatalkCategory = getSudatalkCategory();
		sudatalkCategory.setCateNo(1);
		data.body.put("sudatalkcategory", sudatalkCategory);
		
//		System.out.println(JacksonUtils.objectToJson(data));
		this.mockMvc
				.perform(
						post("/modify/sudatalkcategory.app").contentType(
								MediaType.APPLICATION_JSON).content(
								JacksonUtils.objectToJson(data).getBytes()))
				.andDo(print());
	}
//	@Test
	public void removeSudatalkCategory() throws Exception {
		int cateNo = 1;
		
		this.mockMvc
				.perform(
						post("/remove/sudatalkcategory.app?scno=" + cateNo))
				.andDo(print());
	}
	
//	@Test
	public void printSudatalkCategory() throws Exception {
		int cateNo = 1;
		
		this.mockMvc
				.perform(
						post("/get/sudatalkcategory.app?scno=" + cateNo))
				.andDo(print());
	}

	public SudatalkCategory getSudatalkCategory() {
		SudatalkCategory sudatalkCategory = new SudatalkCategory();
		/*
			depth;
			cateNm;
		 */
		sudatalkCategory.setDepth(1);
		sudatalkCategory.setCateNm("chair");
		return sudatalkCategory;
	}
}
