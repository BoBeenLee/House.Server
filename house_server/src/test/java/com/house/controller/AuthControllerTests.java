package com.house.controller;

import com.house.model.User;
import com.house.util.JacksonUtils;
import java.io.PrintStream;
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
public class AuthControllerTests extends AbstractContextControllerTests {
	private MockMvc mockMvc;
	@Autowired
	Environment environment;

	@Before
	public void setup() throws Exception {
		this.mockMvc = ((DefaultMockMvcBuilder) MockMvcBuilders
				.webAppContextSetup(this.wac).alwaysExpect(
						MockMvcResultMatchers.status().isOk())).build();
	}

	public void login() throws Exception {
		String j_username = "id";
		String j_password = "pw";

		User user = new User();
		user.setUsrId(j_username);
		user.setUsrPw(j_password);

		System.out.println(JacksonUtils.objectToJson(user));
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/login.app", new Object[0])
						.contentType(MediaType.APPLICATION_JSON)
						.content(JacksonUtils.objectToJson(user).getBytes()))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void printStatus() throws Exception {
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/status.app", new Object[0]))
				.andDo(MockMvcResultHandlers.print());
	}

	public void logout() throws Exception {
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/logout", new Object[0])).andDo(
				MockMvcResultHandlers.print());
	}
}
