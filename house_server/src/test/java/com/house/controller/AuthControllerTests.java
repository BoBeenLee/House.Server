package com.house.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.util.HashMap;

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
import com.house.model.JavaBean;
import com.house.model.TransferMultipartFile;
import com.house.model.User;
import com.house.util.JacksonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class AuthControllerTests extends AbstractContextControllerTests {
	private MockMvc mockMvc;

	@Autowired
	Environment environment;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(
				status().isOk()).build();
	}
	
//	@Test
	public void login() throws Exception {
		String j_username, j_password;
		
		j_username = "id";
		j_password = "pw";
		
		User user = new User();
		user.setUsrId(j_username);
		user.setUsrPw(j_password);
		
		System.out.println(JacksonUtils.objectToJson(user));
		this.mockMvc
		.perform(
				post("/login.app").contentType(
						MediaType.APPLICATION_JSON).content(
						JacksonUtils.objectToJson(user).getBytes()))
		.andDo(print());
	}
	

	@Test
	public void printStatus() throws Exception {
		this.mockMvc
		.perform(
				post("/status.app"))
		.andDo(print());
	}
	
//	@Test
	public void logout() throws Exception {
		this.mockMvc
		.perform(
				post("/logout"))
		.andDo(print());
	}
}
