package com.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.mapper.TestMapper;
import com.house.model.JavaBean;
import com.house.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {
	@Autowired
	TestMapper testMapper;
	
	public boolean addTest(JavaBean javaBean) {
		boolean isTest = (1 == testMapper.addTest(javaBean))? true : false;
		return isTest;
	}
	public boolean removeTest(int id) {
		boolean isTest = (1 == testMapper.deleteTest(id))? true : false;
		return isTest;
	}
	public List<JavaBean> getTests() {
		List<JavaBean> tests = testMapper.getTests();
		return tests;
	}
}
