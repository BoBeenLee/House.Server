package com.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.mapper.TypeMapper;
import com.house.model.Type;
import com.house.service.TypeService;

@Service("typeService")
public class TypeServiceImpl implements TypeService {
	@Autowired
	TypeMapper typeMapper;
	
	public boolean addType(Type type) {
		boolean isType = (typeMapper.insertType(type) == 1)? true : false;
		return isType;
	}

	public boolean modifyType(Type type) {
		boolean isType = (typeMapper.updateType(type) == 1)? true : false;
		return isType;
	}

	public boolean removeType(int typeNo) {
		boolean isType = (typeMapper.deleteType(typeNo) == 1)? true : false;
		return isType;
	}

	public Type getTypeByNo(int typeNo) {
		return typeMapper.getTypeByNo(typeNo);
	}

	public List<Type> getTypes() {
		return typeMapper.getTypes();
	}
	
}
