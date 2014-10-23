package com.house.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.house.model.Data;
import com.house.model.JavaBean;
import com.house.model.TransferMultipartFile;
import com.house.service.TestService;
import com.house.util.JacksonUtils;

@Controller
public class TestController {
	@Autowired
	TestService testService;

	@Autowired
	CommentController commentController;
	// MappingJacksonHttpMessageConverter (requires Jackson on the classpath -
	// particularly useful for serving JavaScript clients that expect to work
	// with JSON)


//	@Secured("ROLE_USER")
	@RequestMapping(value = "/test")
	public @ResponseBody Data getTest(HttpServletRequest request) {

		return commentController.getCommentByNo("interior", 1);
	}

	@RequestMapping(value = "/test1")
	public String getTest1(@RequestBody(required = false) JavaBean bean) {
		return "forward:/get/tests.app";
	}

	@RequestMapping(value = "/hash")
	public @ResponseBody
	Data hash() { // @Valid @RequestBody Data outerData
		Data data = new Data();
		// data.setBody(bean);
		data.setStatus(Data.Status.OK);
		
		System.out.println("Server : " + JacksonUtils.objectToJson(data));
		return data;
	}

	@RequestMapping(value = "/json", method = RequestMethod.POST)
	public @ResponseBody
	Data readWriteJson(@Valid @RequestBody JavaBean bean) {
		Data data = new Data();
		// data.setBody(bean);
		data.setStatus(Data.Status.OK);
		System.out.println("Server : " + JacksonUtils.objectToJson(bean));
		return data;
	}

	@RequestMapping(value = "/add/test", method = RequestMethod.POST)
	public @ResponseBody
	String addJavaBean(@Valid @RequestBody JavaBean bean) {
		testService.addTest(bean);
		return "success";
	}

	@RequestMapping(value = "/get/tests")
	public @ResponseBody
	List<JavaBean> getTests() {
		return testService.getTests();
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody
	String upload(HttpServletRequest request) {
		String ROOT_URL = request.getSession().getServletContext()
				.getRealPath("/")
				+ "/image/";
		System.out.println(ROOT_URL);
//		TransferMultipartFile tf = bean.getUpload();
//		File file = new File(ROOT_URL + tf.getName());
//
//		System.out.println(file.getAbsolutePath());
//		try {
//			tf.transferTo(file);
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		return "success";
	}
	
	/* dump */
//	HttpHeaders responseHeaders = new HttpHeaders();
//	responseHeaders.setContentType(MediaType.APPLICATION_JSON);
//	responseHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//
//	RestTemplate template = new RestTemplate();
//	Data data = new Data();
//	data.body.put("test", "esssd");
//
//	HttpEntity<Data> requestEntity = new HttpEntity<Data>(data,
//			responseHeaders);
//	ResponseEntity<Data> entity = template.postForEntity(
//			"http://localhost:8080/app_server/hash.app", requestEntity,
//			Data.class);
////	System.out.println(entity.getStatusCode());
//	ResponseEntity<Data> responseEntity = new ResponseEntity<Data>(entity.getBody(),
//			responseHeaders, HttpStatus.OK);
//	// responseEntity.
}
