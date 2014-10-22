package com.house.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.model.Data;
import com.house.model.JavaBean;
import com.house.service.TestService;
import com.house.util.JacksonUtils;

@Controller
public class TestController {
	@Autowired
	TestService testService;
	@Autowired
	CommentController commentController;

	@RequestMapping({ "/test" })
	@ResponseBody
	public Data getTest(HttpServletRequest request) {
		return this.commentController.getCommentByNo("interior", 1L);
	}

	@RequestMapping({ "/test1" })
	public String getTest1(@RequestBody(required = false) JavaBean bean) {
		return "forward:/get/tests.app";
	}

	@RequestMapping({ "/hash" })
	@ResponseBody
	public Data hash() {
		Data data = new Data();

		data.setStatus(Data.Status.OK);

		System.out.println("Server : " + JacksonUtils.objectToJson(data));
		return data;
	}

	@RequestMapping(value = { "/json" }, method = { RequestMethod.POST })
	@ResponseBody
	public Data readWriteJson(@Valid @RequestBody JavaBean bean) {
		Data data = new Data();

		data.setStatus(Data.Status.OK);
		System.out.println("Server : " + JacksonUtils.objectToJson(bean));
		return data;
	}

	@RequestMapping(value = { "/add/test" }, method = { RequestMethod.POST })
	@ResponseBody
	public String addJavaBean(@Valid @RequestBody JavaBean bean) {
		this.testService.addTest(bean);
		return "success";
	}

	@RequestMapping({ "/get/tests" })
	@ResponseBody
	public List<JavaBean> getTests() {
		return this.testService.getTests();
	}

	@RequestMapping(value = { "/upload" }, method = { RequestMethod.POST })
	@ResponseBody
	public String upload(HttpServletRequest request) {
		String ROOT_URL = request.getSession().getServletContext()
				.getRealPath("/")
				+ "/image/";
		System.out.println(ROOT_URL);

		return "success";
	}
}
