package com.house.controller;

import com.house.model.Data;
import com.house.model.InteriorCategory;
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
public class InteriorCategoryControllerTests extends
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

	@Test
	public void addInteriorCategory() throws Exception {
		Data data = new Data();

		InteriorCategory[] interiorCategory = new InteriorCategory[1];
		for (int i = 0; i < interiorCategory.length; i++) {
			data.body.put("interiorcategory", interiorCategory[i]);

			this.mockMvc
					.perform(
							MockMvcRequestBuilders
									.post("/add/interiorcategory.app",
											new Object[0])
									.contentType(MediaType.APPLICATION_JSON)
									.content(
											JacksonUtils.objectToJson(data)
													.getBytes())).andDo(
							MockMvcResultHandlers.print());
		}
	}

	public void modifyInteriorCategory() throws Exception {
		Data data = new Data();

		InteriorCategory InteriorCategory = getInteriorCategory();
		InteriorCategory.setCateNo(1);
		data.body.put("interiorcategory", InteriorCategory);

		this.mockMvc.perform(
				MockMvcRequestBuilders
						.post("/modify/interiorcategory.app", new Object[0])
						.contentType(MediaType.APPLICATION_JSON)
						.content(JacksonUtils.objectToJson(data).getBytes()))
				.andDo(MockMvcResultHandlers.print());
	}

	public void removeInteriorCategory() throws Exception {
		for (int i = 1; i <= 3; i++) {
			int cateNo = i;

			this.mockMvc.perform(
					MockMvcRequestBuilders.post(
							"/remove/interiorcategory.app?icno=" + cateNo,
							new Object[0]))
					.andDo(MockMvcResultHandlers.print());
		}
	}

	@Test
	public void printInteriorCategory() throws Exception {
		int cateNo = 1;

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/get/interiorcategory.app?icno="
						+ cateNo, new Object[0])).andDo(
				MockMvcResultHandlers.print());
	}

	public InteriorCategory getInteriorCategory() {
		InteriorCategory InteriorCategory = new InteriorCategory();

		InteriorCategory.setDepth(1);
		InteriorCategory.setCateNm("chair");
		return InteriorCategory;
	}
}
