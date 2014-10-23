package com.house.mapper;

import java.util.List;

import com.house.model.Type;

public interface TypeMapper {
	public int insertType(Type type);
	public int updateType(Type type);
	public int deleteType(int typeNo);
	public Type getTypeByNo(int typeNo);
	public List<Type> getTypes();
}
