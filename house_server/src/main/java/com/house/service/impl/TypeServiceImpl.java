package com.house.service.impl;

import com.house.mapper.TypeMapper;
import com.house.model.Type;
import com.house.service.TypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("typeService")
public class TypeServiceImpl implements TypeService {
	@Autowired
	TypeMapper typeMapper;

	public boolean addType(Type type) {
		boolean isType = this.typeMapper.insertType(type) == 1;
		return isType;
	}

	public boolean modifyType(Type type) {
		boolean isType = this.typeMapper.updateType(type) == 1;
		return isType;
	}

	public boolean removeType(int typeNo) {
		boolean isType = this.typeMapper.deleteType(typeNo) == 1;
		return isType;
	}

	public Type getTypeByNo(int typeNo) {
		return this.typeMapper.getTypeByNo(typeNo);
	}

	public List<Type> getTypes() {
		return this.typeMapper.getTypes();
	}
}
