package com.house.controller;

import com.house.model.Data;
import com.house.model.TransferMultipartFile;
import com.house.model.User;
import com.house.util.JacksonUtils;
import java.io.IOException;
import java.io.PrintStream;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTests extends AbstractContextControllerTests {
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
		User user = new User();

		String usrId = "id12";
		String userPw = "pw12";

		user.setUsrId(usrId);
		user.setUsrPw(userPw);

		this.mockMvc.perform(
				MockMvcRequestBuilders
						.post("/auth/user.app?token=sdfdsf", new Object[0])
						.contentType(MediaType.APPLICATION_JSON)
						.content(JacksonUtils.objectToJson(user).getBytes()))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void addUser() throws Exception {
		Data data = new Data();
		User user = getUser();
		user.setUsrId("id2");
		user.setUsrPw("pw2");

		data.body.put("user", user);

		TransferMultipartFile mf = null;
		try {
			mf = new TransferMultipartFile(new MockMultipartFile("test12.html",
					"sdfasdsf".getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		data.body.put("img", mf);

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/add/user.app", new Object[0])
						.contentType(MediaType.APPLICATION_JSON)
						.content(JacksonUtils.objectToJson(data).getBytes()))
				.andDo(MockMvcResultHandlers.print());
	}

	public void removeUser() throws Exception {
		int userNo = 1;

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/remove/user.app?uno=" + userNo,
						new Object[0])).andDo(MockMvcResultHandlers.print());
	}

	public void modifyUser() throws Exception {
		Data data = new Data();

		data.body.put("user", getUser());

		TransferMultipartFile mf = null;
		try {
			mf = new TransferMultipartFile(new MockMultipartFile("test.html",
					"sdfasdsf".getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		data.body.put("img", mf);

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/modify/user.app", new Object[0])
						.contentType(MediaType.APPLICATION_JSON)
						.content(JacksonUtils.objectToJson(data).getBytes()))
				.andDo(MockMvcResultHandlers.print());
	}

	public void printUser() throws Exception {
		Data data = new Data();

		data.body.put("user", getUser());

		TransferMultipartFile mf = null;
		try {
			mf = new TransferMultipartFile(new MockMultipartFile("test.html",
					"sdfasdsf".getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		data.body.put("img", mf);

		System.out.println(JacksonUtils.objectToJson(data));

		String usrId = "id1";

		System.out.println(JacksonUtils.objectToJson(getUser()));

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/get/user.app", new Object[0])
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"usrId\":\"id1\"}")).andDo(
				MockMvcResultHandlers.print());
	}

	public User getUser() {
		User user = new User();

		user.setUsrSts(2);
		user.setUsrNm("name1");
		user.setUsrId("id1");
		user.setUsrPw("pw1");
		user.setUsrSs("ss");
		user.setTermsYN("Y");
		user.setPsPlatform("3.1.10");
		user.setPsId("s");
		user.setPsRevokeYN("Y");
		user.setPsAppVer("3.1");
		user.setDeviceNM("nexus");

		return user;
	}
}
