package com.house.controller;

import com.house.model.Data;
import com.house.model.SudatalkCategory;
import com.house.util.JacksonUtils;
import java.util.HashMap;
import org.junit.Before;
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
public class SudatalkCategoryControllerTests extends
		AbstractContextControllerTests {
	private MockMvc mockMvc;
	@Autowired
	Environment environment;

	@Before
	public void setup() throws Exception {
		this.mockMvc = ((DefaultMockMvcBuilder) MockMvcBuilders
				.webAppContextSetup(this.wac).alwaysExpect(
						MockMvcResultMatchers.status().isOk())).build();
	}

	public void addSudatalkCategory() throws Exception {
		Data data = new Data();

		SudatalkCategory sudatalkCategory = getSudatalkCategory();
		data.body.put("sudatalkcategory", sudatalkCategory);

		this.mockMvc.perform(
				MockMvcRequestBuilders
						.post("/add/sudatalkcategory.app", new Object[0])
						.contentType(MediaType.APPLICATION_JSON)
						.content(JacksonUtils.objectToJson(data).getBytes()))
				.andDo(MockMvcResultHandlers.print());
	}

	public void modifySudatalkCategory() throws Exception {
		Data data = new Data();

		SudatalkCategory sudatalkCategory = getSudatalkCategory();
		sudatalkCategory.setCateNo(1);
		data.body.put("sudatalkcategory", sudatalkCategory);

		this.mockMvc.perform(
				MockMvcRequestBuilders
						.post("/modify/sudatalkcategory.app", new Object[0])
						.contentType(MediaType.APPLICATION_JSON)
						.content(JacksonUtils.objectToJson(data).getBytes()))
				.andDo(MockMvcResultHandlers.print());
	}

	public void removeSudatalkCategory() throws Exception {
		int cateNo = 1;

		this.mockMvc.perform(
				MockMvcRequestBuilders.post(
						"/remove/sudatalkcategory.app?scno=" + cateNo,
						new Object[0])).andDo(MockMvcResultHandlers.print());
	}

	public void printSudatalkCategory() throws Exception {
		int cateNo = 1;

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/get/sudatalkcategory.app?scno="
						+ cateNo, new Object[0])).andDo(
				MockMvcResultHandlers.print());
	}

	public SudatalkCategory getSudatalkCategory() {
		SudatalkCategory sudatalkCategory = new SudatalkCategory();

		sudatalkCategory.setDepth(1);
		sudatalkCategory.setCateNm("chair");
		return sudatalkCategory;
	}
}
