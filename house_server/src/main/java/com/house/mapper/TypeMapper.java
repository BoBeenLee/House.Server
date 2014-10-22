package com.house.mapper;

import com.house.model.Type;
import java.util.List;

public interface TypeMapper {
	public int insertType(Type type);

	public int updateType(Type type);

	public int deleteType(int no);

	public Type getTypeByNo(int no);

	public List<Type> getTypes();
}
