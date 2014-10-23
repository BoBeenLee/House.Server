package com.house.mapper;

import java.util.List;

import com.house.model.JavaBean;

public interface TestMapper {
	public int deleteTest(int id);
	public int addTest(JavaBean test);
	public List<JavaBean> getTests();
}
