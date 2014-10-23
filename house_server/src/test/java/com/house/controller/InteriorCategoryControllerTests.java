package com.house.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.house.model.Data;
import com.house.model.InteriorCategory;
import com.house.util.JacksonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class InteriorCategoryControllerTests extends AbstractContextControllerTests {
	private MockMvc mockMvc;

	@Autowired
	Environment environment;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(
				status().isOk()).build();
	}
	
	@Test
	public void addInteriorCategory() throws Exception {
		Data data = new Data();
		
		InteriorCategory[] interiorCategory = new InteriorCategory[1];
		interiorCategory[0] = new InteriorCategory(){{ setCateNm("ALL"); }};
		
		for(int i=0; i<interiorCategory.length; i++){
			data.body.put("interiorcategory", interiorCategory[i]);
			
	//		System.out.println(JacksonUtils.objectToJson(data));
			this.mockMvc
					.perform(
							post("/add/interiorcategory.app").contentType(
									MediaType.APPLICATION_JSON).content(
									JacksonUtils.objectToJson(data).getBytes()))
									.andDo(print());
		}
	}
	
//	@Test
	public void modifyInteriorCategory() throws Exception {
		Data data = new Data();
		
		InteriorCategory InteriorCategory = getInteriorCategory();
		InteriorCategory.setCateNo(1);
		data.body.put("interiorcategory", InteriorCategory);
		
//		System.out.println(JacksonUtils.objectToJson(data));
		this.mockMvc
				.perform(
						post("/modify/interiorcategory.app").contentType(
								MediaType.APPLICATION_JSON).content(
								JacksonUtils.objectToJson(data).getBytes()))
				.andDo(print());
	}
//	@Test
	public void removeInteriorCategory() throws Exception {
		for(int i=1; i<=3; i++){
				int cateNo = i;
				
				this.mockMvc
						.perform(
								post("/remove/interiorcategory.app?icno=" + cateNo))
						.andDo(print());
		}
	}

//	@Test
	public void printInteriorCategory() throws Exception {
		int cateNo = 1;
		
		this.mockMvc
				.perform(
						post("/get/interiorcategory.app?icno=" + cateNo))
				.andDo(print());
	}	
	
	public InteriorCategory getInteriorCategory() {
		InteriorCategory InteriorCategory = new InteriorCategory();
		/*
			depth;
			cateNm;
		 */
		InteriorCategory.setDepth(1);
		InteriorCategory.setCateNm("chair");
		return InteriorCategory;
	}
}
