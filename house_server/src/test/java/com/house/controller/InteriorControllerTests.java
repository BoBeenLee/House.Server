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
import com.house.model.Interior;
import com.house.model.InteriorCategory;
import com.house.model.TransferMultipartFile;
import com.house.util.JacksonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class InteriorControllerTests extends AbstractContextControllerTests {
	private MockMvc mockMvc;

	@Autowired
	Environment environment;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(
				status().isOk()).build();
	}


	@Test
	public void addInterior() throws Exception {
		Data data = new Data();
		
		Interior interior = getInterior();
		List<TransferMultipartFile> multipartFiles = new ArrayList<TransferMultipartFile>();
		data.body.put("interior", interior);
		
		TransferMultipartFile mf = null;
		try {
			for(int i=0; i<3; i++){
				mf = new TransferMultipartFile(new MockMultipartFile("test.html",
						"sdfasdsf".getBytes()));
				multipartFiles.add(mf);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		data.body.put("imgs", multipartFiles);
		
//		System.out.println(JacksonUtils.objectToJson(data));
		this.mockMvc
				.perform(
						post("/add/interior.app").contentType(
								MediaType.APPLICATION_JSON).content(
								JacksonUtils.objectToJson(data).getBytes()))
				.andDo(print());
	}
	
//	@Test
	public void modifyInterior() throws Exception {
		Data data = new Data();
		
		Interior interior = getInterior();
		// 1번일 경우 수정 테스트
//		interior.setInteriorNo(1);
		
		List<TransferMultipartFile> multipartFiles = new ArrayList<TransferMultipartFile>();
		data.body.put("interior", interior);
		
		TransferMultipartFile mf = null;
		try {
			for(int i=0; i<3; i++){
				mf = new TransferMultipartFile(new MockMultipartFile("test.html",
						"sdfasdsf".getBytes()));
				multipartFiles.add(mf);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		data.body.put("imgs", multipartFiles);
		
	   // System.out.println(JacksonUtils.objectToJson(data));
		this.mockMvc
				.perform(
						post("/modify/interior.app").contentType(
								MediaType.APPLICATION_JSON).content(
								JacksonUtils.objectToJson(data).getBytes()))
				.andDo(print());
	}
	
//	@Test
	public void removeInterior() throws Exception {
		int interiorNo = 1;
		
		this.mockMvc
				.perform(
						post("/remove/interior.app?ino=" + interiorNo))
				.andDo(print());
	}

//	@Test
	public void printInterior() throws Exception {
		int interiorNo = 1;
		
		this.mockMvc
				.perform(
						post("/get/interior.app?ino=" + interiorNo))
				.andDo(print());
	}

	
	public Interior getInterior() {
		Interior interior = new Interior();
		/*
		private int cateCd;
		private String subject;
		private String contents;
		private String tagNm;
		 */
		interior.setCateCd(1);
		interior.setContents("asdfsdfasfds".getBytes());
		interior.setSubject("Hello World!");
		interior.setTagNm("book,chair");
		return interior;
	}
}
