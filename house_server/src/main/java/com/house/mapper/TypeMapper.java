package com.house.mapper;

import com.house.model.Type;
import java.util.List;

public interface TypeMapper {
	public int insertType(Type paramType);

	public int updateType(Type paramType);

	public int deleteType(int paramInt);

	public Type getTypeByNo(int paramInt);

	public List<Type> getTypes();
}
