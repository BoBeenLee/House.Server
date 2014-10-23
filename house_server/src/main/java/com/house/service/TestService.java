package com.house.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.house.model.JavaBean;

@Transactional
public interface TestService {
	public boolean addTest(JavaBean javaBean);
	public boolean removeTest(int id);
	public List<JavaBean> getTests();

}
