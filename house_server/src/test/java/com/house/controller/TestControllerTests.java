package com.house.controller;

import com.house.model.Data;
import com.house.model.JavaBean;
import com.house.model.TransferMultipartFile;
import com.house.util.FileUtils;
import com.house.util.JacksonUtils;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
public class TestControllerTests extends AbstractContextControllerTests {
	private MockMvc mockMvc;
	@Autowired
	Environment environment;

	@Before
	public void setup() throws Exception {
		this.mockMvc = ((DefaultMockMvcBuilder) MockMvcBuilders
				.webAppContextSetup(this.wac).alwaysExpect(
						MockMvcResultMatchers.status().isOk())).build();
	}

	public JavaBean getJavaBean() {
		JavaBean javaBean = new JavaBean();

		javaBean.setNum(1);
		javaBean.setName("이");
		javaBean.setContent("Hello World! 안녕");
		javaBean.setImage("이미지".getBytes());
		javaBean.setCheck(true);

		TransferMultipartFile mf = null;
		try {
			mf = new TransferMultipartFile(new MockMultipartFile("test.html",
					"sdfasdsdsdsf".getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		javaBean.setUpload(mf);

		return javaBean;
	}

	public void readWriteJson() throws Exception {
		JavaBean javaBean = getJavaBean();

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/json.app", new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(javaBean)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public void hash() throws Exception {
		Data data = new Data();

		data.body = new HashMap();
		data.body.put("test", "test");
		data.body.put("bean", getJavaBean());

		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/hash.app", new Object[0])
						.contentType(MediaType.APPLICATION_JSON)
						.content(JacksonUtils.objectToJson(data).getBytes()))
				.andDo(MockMvcResultHandlers.print());
	}

	public void addJavaBean() throws Exception {
		JavaBean javaBean = getJavaBean();

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/add/test.app", new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(javaBean)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public void getTest() throws Exception {
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/test", new Object[0])).andDo(
				MockMvcResultHandlers.print());
	}

	public void getTest1() throws Exception {
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/test1", new Object[0])).andDo(
				MockMvcResultHandlers.print());
	}

	public void getTests() throws Exception {
		this.mockMvc.perform(
				MockMvcRequestBuilders.post("/get/tests", new Object[0]))
				.andDo(MockMvcResultHandlers.print());
	}

	public void upload() throws Exception {
		JavaBean javaBean = getJavaBean();

		System.out.println(JacksonUtils.objectToJson(javaBean));
		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/upload", new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(javaBean)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public void pathTest() {
		String path = "/abc/bds/sd/img.jpeg";

		System.out.println(path.substring(path.lastIndexOf('/') + 1));
		System.out.println(path.substring(path.lastIndexOf('.') + 1));
	}

	public void writeFile() throws IllegalStateException, IOException {
		TransferMultipartFile mf = null;
		try {
			mf = new TransferMultipartFile(new MockMultipartFile(
					"test123.html", "sdfasdsdsdsf".getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(FileUtils.getCurrentRequest().getSession()
				.getServletContext().getRealPath("/")
				+ "/image/" + mf.getName());
		FileUtils.transferTo(mf.getName(), mf.getContent());
	}

	public void byteToString() throws Exception {
		String name = "test.png";
		String type = "";
		if (name.indexOf('.') == -1) {
			type = ".png";
		} else {
			type = name.substring(name.indexOf('.'));
			name = name.replaceAll(type, "");
		}
		System.out.println(name + " - -" + type);
	}

	@Test
	public void showImage() throws Exception {
		this.mockMvc.perform(
				MockMvcRequestBuilders.get(
						"/house/image/2014091500342000001picture",
						new Object[0])).andDo(MockMvcResultHandlers.print());
	}
}
