package com.house.controller;

import com.house.model.Data;
import com.house.model.Like;
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
public class LikeControllerTests extends AbstractContextControllerTests {
	private MockMvc mockMvc;
	@Autowired
	Environment environment;

	@Before
	public void setup() throws Exception {
		this.mockMvc = ((DefaultMockMvcBuilder) MockMvcBuilders
				.webAppContextSetup(this.wac).alwaysExpect(
						MockMvcResultMatchers.status().isOk())).build();
	}

	public void addLike() throws Exception {
		Data data = new Data();

		Like like = getLike();
		data.body.put("like", like);

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/add/like.app", new Object[0])
						.contentType(MediaType.APPLICATION_JSON)
						.content(JacksonUtils.objectToJson(data).getBytes()))
				.andDo(MockMvcResultHandlers.print());
	}

	public void removeLike() throws Exception {
		int likeNo = 1;

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/remove/like.app?lno=" + likeNo,
						new Object[0])).andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void printLike() throws Exception {
		int likeNo = 1;

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/get/like.app?lno=" + likeNo,
						new Object[0])).andDo(MockMvcResultHandlers.print());
	}

	public Like getLike() {
		Like like = new Like();

		like.setSrcType(2);

		return like;
	}
}

