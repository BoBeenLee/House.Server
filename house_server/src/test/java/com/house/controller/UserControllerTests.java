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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.house.model.Data;
import com.house.model.TransferMultipartFile;
import com.house.model.User;
import com.house.util.JacksonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTests extends AbstractContextControllerTests {
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
		User user = new User();
		String userId, userPw;
		
		userId = "id12"; userPw = "pw12";
		
		user.setUsrId(userId); user.setUsrPw(userPw);
		
		this.mockMvc
				.perform(
						post("/auth/user.app?token=sdfdsf").contentType(
								MediaType.APPLICATION_JSON).content(
								JacksonUtils.objectToJson(user).getBytes()))
				.andDo(print());
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
		
		// System.out.println(JacksonUtils.objectToJson(data));
		this.mockMvc
				.perform(
						post("/add/user.app").contentType(
								MediaType.APPLICATION_JSON).content(
								JacksonUtils.objectToJson(data).getBytes()))
				.andDo(print());
	}

//	@Test
	public void removeUser() throws Exception {
		int userNo = 1;
		
		this.mockMvc
				.perform(
						post("/remove/user.app?uno=" + userNo))
				.andDo(print());
	}

//	@Test
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
		
//		System.out.println(JacksonUtils.objectToJson(javaBean));
		this.mockMvc
				.perform(
						post("/modify/user.app").contentType(
								MediaType.APPLICATION_JSON).content(
								JacksonUtils.objectToJson(data).getBytes()))
				.andDo(print());
	}
	
//	@Test
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
		
		
		String userId = "id1";
		// @JsonProperty("_usr_id")
//		this.mockMvc
//		.perform(
//				post("/get/user.app?usrId=" + userId))
//		.andDo(print());
		
		
		 System.out.println(JacksonUtils.objectToJson(getUser()));
//		 System.out.println("{\"usrNo\":0,\"usrSts\":2,\"usrNm\":\"name1\",\"usrId\":\"id1\",\"usrPw\":\"pw1\",\"usrSs\":\"ss\",\"termsYN\":\"Y\",\"psPlatform\":\"3.1.10\",\"psId\":\"s\",\"psRevokeYN\":\"Y\",\"psAppVer\":\"3.1\",\"deviceNM\":\"nexus\",\"modified\":null,\"created\":null}");
//		 System.out.println("{\"usrId\":\"id1\"}");
		this.mockMvc
		.perform(
				post("/get/user.app")
				.contentType(
						MediaType.APPLICATION_JSON).content(
								"{\"usrId\":\"id1\"}"))
		.andDo(print());
	}
	

	public User getUser() {
		User user = new User();
		/*
			private int usrSts;
			private String usrNm;
			private String usrId;
			private String usrPw;
			private String usrSs;
			private String termsYN;
			private String psPlatform;
			private String psId;
			private String psRevokeYN;
			private String psAppVer;
			private String deviceNM;
			private String modified;
			private String created;
		 */			
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
