package com.house.service;

import com.house.model.JavaBean;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TestService {
	public boolean addTest(JavaBean javaBean);

	public boolean removeTest(int id);

	public List<JavaBean> getTests();
}
