package com.house.mapper;

import com.house.model.JavaBean;
import java.util.List;

public interface TestMapper {
	public int deleteTest(int no);

	public int addTest(JavaBean javaBean);

	public List<JavaBean> getTests();
}
