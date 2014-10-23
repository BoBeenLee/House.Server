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

import com.house.model.Comment;
import com.house.model.Data;
import com.house.model.Interior;
import com.house.model.TransferMultipartFile;
import com.house.util.JacksonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class CommentControllerTests extends AbstractContextControllerTests {
	private MockMvc mockMvc;

	@Autowired
	Environment environment;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(
				status().isOk()).build();
	}


//	@Test
	public void addComment() throws Exception {
		Data data = new Data();
		
		Comment comment = getComment();
		data.body.put("comment", comment);
		
//		System.out.println(JacksonUtils.objectToJson(data));
		this.mockMvc
				.perform(
						post("/add/interior/comment.app").contentType(
								MediaType.APPLICATION_JSON).content(
								JacksonUtils.objectToJson(comment).getBytes()))
				.andDo(print());
	}
	
//	@Test
	public void modifyComment() throws Exception {
		Data data = new Data();
		
		Comment comment = getComment();
		// 1번일 경우 수정 테스트
		comment.setContents("Hello world!".getBytes());
		data.body.put("comment", comment);
		
	   // System.out.println(JacksonUtils.objectToJson(data));
		this.mockMvc
				.perform(
						post("/modify/interior/comment.app").contentType(
								MediaType.APPLICATION_JSON).content(
								JacksonUtils.objectToJson(data).getBytes()))
				.andDo(print());
	}
	
//	@Test
	public void removeComment() throws Exception {
		int commentNo = 1;
		
		this.mockMvc
				.perform(
						post("/remove/interior/comment.app?ino=" + commentNo))
				.andDo(print());
	}

	@Test
	public void printComment() throws Exception {
		int commentNo = 1;
		
		this.mockMvc
				.perform(
						post("/get/interior/comment.app?cno=" + commentNo))
				.andDo(print());
	}	
	
	public Comment getComment() {
		Comment comment = new Comment();

		//		comment.setSrcNo(1);
		comment.setContents("asfasd".getBytes());
		return comment;
	}
}
