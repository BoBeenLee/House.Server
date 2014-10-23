package com.house.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import com.house.util.FileUtils;
import com.house.util.JacksonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestControllerTests extends AbstractContextControllerTests {
	private MockMvc mockMvc;

	@Autowired
	Environment environment;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(
				status().isOk()).build();
	}

	public JavaBean getJavaBean() {
		JavaBean javaBean = new JavaBean();
		/*
		 * int num; String content; byte[] image; boolean check;
		 */
		javaBean.setNum(1);
		javaBean.setName("이");
		javaBean.setContent("Hello World! 안녕");
		javaBean.setImage("이미지".getBytes());
		javaBean.setCheck(true);

		// new MockMultipartFile("test.html", "sdfasdsf".getBytes())
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

	// @Test
	public void readWriteJson() throws Exception {
		JavaBean javaBean = getJavaBean();

		// System.out.println(JacksonUtils.objectToJson(javaBean));
		this.mockMvc
				.perform(
						post("/json.app").contentType(
								MediaType.APPLICATION_JSON).content(
								JacksonUtils.objectToJson(javaBean).getBytes()))
				.andDo(print());
		// andDo( print() - 출력하라 );
	}

	// @Test
	public void hash() throws Exception {
		Data data = new Data();

		data.body = new HashMap<String, Object>();
		data.body.put("test", "test");
		data.body.put("bean", getJavaBean());
		// System.out.println(JacksonUtils.objectToJson(javaBean));
		this.mockMvc.perform(
				post("/hash.app").contentType(MediaType.APPLICATION_JSON)
						.content(JacksonUtils.objectToJson(data).getBytes()))
				.andDo(print());
		// andDo( print() - 출력하라 );
	}

	// @Test
	public void addJavaBean() throws Exception {
		JavaBean javaBean = getJavaBean();

		this.mockMvc
				.perform(
						post("/add/test.app").contentType(
								MediaType.APPLICATION_JSON).content(
								JacksonUtils.objectToJson(javaBean).getBytes()))
				.andDo(print());
	}

//	@Test
	public void getTest() throws Exception {
//		File file = new File("/usr");
//		
//		System.out.println(file.getAbsolutePath());
		
//		Properties props = System.getProperties();
//		for (Enumeration en = props.propertyNames(); en.hasMoreElements();) {
//			String key = (String) en.nextElement();
//			String value = props.getProperty(key);
//			System.out.println(key + "=" + value);
//		}
		// System.out.println(System.getProperty("catalina.home"));
		this.mockMvc.perform(post("/test")).andDo(print());
	}

	// @Test
	public void getTest1() throws Exception {
		this.mockMvc.perform(post("/test1")).andDo(print());
	}

//	 @Test
	public void getTests() throws Exception {
		this.mockMvc.perform(post("/get/tests")).andDo(print());
	}

//	 @Test
	public void upload() throws Exception {
		// I use FileUpload directly and this is the approach I use:
		// Code:
		// File newFiles= new
		// File(request.getSession().getServletContext().getRealPath("/WEB-INF/files/"),
		// uploadFile.getName());
		// Remember to deal with the uploadFile.getName() quirk with IE.
		// Good Luck - not sure if this will work in your case,
		JavaBean javaBean = getJavaBean();

		 System.out.println(JacksonUtils.objectToJson(javaBean));
		this.mockMvc
				.perform(
						post("/upload").contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(javaBean)
												.getBytes())).andDo(print());
	}
	
//	@Test
	public void pathTest(){
		String path = "/abc/bds/sd/img.jpeg";
		
		System.out.println(path.substring(path.lastIndexOf('/') + 1));
		System.out.println(path.substring(path.lastIndexOf('.') + 1));
		
	}
	
//	@Test
	public void writeFile() throws IllegalStateException, IOException{
		TransferMultipartFile mf = null;
		try {
			mf = new TransferMultipartFile(new MockMultipartFile("test123.html",
					"sdfasdsdsdsf".getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(FileUtils.getCurrentRequest().getSession().getServletContext()
				.getRealPath("/")
				+ "/image/" + mf.getName());
		FileUtils.transferTo(mf.getName(), mf.getContent());
	}
	
	@Test
	public void byteToString() throws Exception{
//		ArrayList<String> strList = new ArrayList<String>();
//		
//		strList.set(0,  "Hello");
//		
	}
	
	
}
