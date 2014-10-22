package com.house.service.impl;

import com.house.mapper.TestMapper;
import com.house.model.JavaBean;
import com.house.service.TestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService {
	@Autowired
	TestMapper testMapper;

	public boolean addTest(JavaBean javaBean) {
		boolean isTest = 1 == this.testMapper.addTest(javaBean);
		return isTest;
	}

	public boolean removeTest(int id) {
		boolean isTest = 1 == this.testMapper.deleteTest(id);
		return isTest;
	}

	public List<JavaBean> getTests() {
		List<JavaBean> tests = this.testMapper.getTests();
		return tests;
	}
}
