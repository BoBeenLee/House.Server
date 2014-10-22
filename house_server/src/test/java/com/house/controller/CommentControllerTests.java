package com.house.controller;

import com.house.model.Comment;
import com.house.model.Data;
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
public class CommentControllerTests extends AbstractContextControllerTests {
	private MockMvc mockMvc;
	@Autowired
	Environment environment;

	@Before
	public void setup() throws Exception {
		this.mockMvc = ((DefaultMockMvcBuilder) MockMvcBuilders
				.webAppContextSetup(this.wac).alwaysExpect(
						MockMvcResultMatchers.status().isOk())).build();
	}

	public void addComment() throws Exception {
		Data data = new Data();

		Comment comment = getComment();
		data.body.put("comment", comment);

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/add/interior/comment.app",
										new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(comment)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public void modifyComment() throws Exception {
		Data data = new Data();

		Comment comment = getComment();

		comment.setContents("Hello world!".getBytes());
		data.body.put("comment", comment);

		this.mockMvc.perform(
				MockMvcRequestBuilders
						.post("/modify/interior/comment.app", new Object[0])
						.contentType(MediaType.APPLICATION_JSON)
						.content(JacksonUtils.objectToJson(data).getBytes()))
				.andDo(MockMvcResultHandlers.print());
	}

	public void removeComment() throws Exception {
		int commentNo = 1;

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/remove/interior/comment.app?ino="
						+ commentNo, new Object[0])).andDo(
				MockMvcResultHandlers.print());
	}

	@Test
	public void printComment() throws Exception {
		int commentNo = 1;

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/get/interior/comment.app?cno="
						+ commentNo, new Object[0])).andDo(
				MockMvcResultHandlers.print());
	}

	public Comment getComment() {
		Comment comment = new Comment();

		comment.setContents("asfasd".getBytes());
		return comment;
	}
}
