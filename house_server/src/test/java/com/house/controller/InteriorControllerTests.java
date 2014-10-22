package com.house.controller;

import com.house.model.Data;
import com.house.model.Interior;
import com.house.model.TransferMultipartFile;
import com.house.util.JacksonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class InteriorControllerTests extends AbstractContextControllerTests {
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
	public void addInterior() throws Exception {
		Data data = new Data();

		Interior interior = getInterior();
		List<TransferMultipartFile> multipartFiles = new ArrayList();
		data.body.put("interior", interior);

		TransferMultipartFile mf = null;
		try {
			for (int i = 0; i < 3; i++) {
				mf = new TransferMultipartFile(new MockMultipartFile(
						"test.html", "sdfasdsf".getBytes()));
				multipartFiles.add(mf);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		data.body.put("imgs", multipartFiles);

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/add/interior.app", new Object[0])
						.contentType(MediaType.APPLICATION_JSON)
						.content(JacksonUtils.objectToJson(data).getBytes()))
				.andDo(MockMvcResultHandlers.print());
	}

	public void modifyInterior() throws Exception {
		Data data = new Data();

		Interior interior = getInterior();

		List<TransferMultipartFile> multipartFiles = new ArrayList();
		data.body.put("interior", interior);

		TransferMultipartFile mf = null;
		try {
			for (int i = 0; i < 3; i++) {
				mf = new TransferMultipartFile(new MockMultipartFile(
						"test.html", "sdfasdsf".getBytes()));
				multipartFiles.add(mf);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		data.body.put("imgs", multipartFiles);

		this.mockMvc.perform(
				MockMvcRequestBuilders
						.post("/modify/interior.app", new Object[0])
						.contentType(MediaType.APPLICATION_JSON)
						.content(JacksonUtils.objectToJson(data).getBytes()))
				.andDo(MockMvcResultHandlers.print());
	}

	public void removeInterior() throws Exception {
		int interiorNo = 1;

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/remove/interior.app?ino="
						+ interiorNo, new Object[0])).andDo(
				MockMvcResultHandlers.print());
	}

	public void printInterior() throws Exception {
		int interiorNo = 1;

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/get/interior.app?ino="
						+ interiorNo, new Object[0])).andDo(
				MockMvcResultHandlers.print());
	}

	public Interior getInterior() {
		Interior interior = new Interior();

		interior.setCateCd(1);
		interior.setContents("asdfsdfasfds".getBytes());
		interior.setSubject("Hello World!");
		interior.setTagNm("book,chair");
		return interior;
	}
}
