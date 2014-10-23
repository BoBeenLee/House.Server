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
public class SudatalkControllerTests extends AbstractContextControllerTests {
	private MockMvc mockMvc;

	@Autowired
	Environment environment;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(
				status().isOk()).build();
	}


//	@Test
	public void addSudatalk() throws Exception {
		Data data = new Data();
		
		Sudatalk sudatalk = getSudatalk();
		List<TransferMultipartFile> multipartFiles = new ArrayList<TransferMultipartFile>();
		data.body.put("sudatalk", sudatalk);
		
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
						post("/add/sudatalk.app").contentType(
								MediaType.APPLICATION_JSON).content(
								JacksonUtils.objectToJson(data).getBytes()))
				.andDo(print());
		// andDo( print() - 출력하라 );
	}
	
//	@Test
	public void modifySudatalk() throws Exception {
	Data data = new Data();
		
		Sudatalk sudatalk = getSudatalk();
		// 1번일 경우 수정 테스트
		
		List<TransferMultipartFile> multipartFiles = new ArrayList<TransferMultipartFile>();
		data.body.put("sudatalk", sudatalk);
		
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
		
		System.out.println(JacksonUtils.objectToJson(data));
		this.mockMvc
				.perform(
						post("/modify/sudatalk.app").contentType(
								MediaType.APPLICATION_JSON).content(
								JacksonUtils.objectToJson(data).getBytes()))
				.andDo(print());
		// andDo( print() - 출력하라 );
	}
	
//	@Test
	public void removeSudatalk() throws Exception {
		int talkNo = 1;
		
		this.mockMvc
				.perform(
						post("/remove/sudatalk.app?sno=" + talkNo))
				.andDo(print());
	}

	@Test
	public void printSudatalk() throws Exception {
		int talkNo = 1;
		
		this.mockMvc
				.perform(
						post("/get/sudatalk.app?sno=" + talkNo))
				.andDo(print());
	}
	
	public Sudatalk getSudatalk() {
		Sudatalk sudatalk = new Sudatalk();
		/*
		private int cateCd;
		private String subject;
		private String contents;
		private String tagNm;
		 */
		sudatalk.setCateCd(1);
		sudatalk.setContents("asdfsdfasfds".getBytes());
		sudatalk.setSubject("Hello World!");
		sudatalk.setTagNm("book,chair");
		return sudatalk;
	}
}
