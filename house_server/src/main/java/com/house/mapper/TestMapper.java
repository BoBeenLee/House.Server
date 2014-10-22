package com.house.mapper;

import com.house.model.JavaBean;
import java.util.List;

public interface TestMapper {
	public int deleteTest(int paramInt);

	public int addTest(JavaBean paramJavaBean);

	public List<JavaBean> getTests();
}
