package com.house.service;

import com.house.model.Type;
import java.util.List;

public interface TypeService {
	public boolean addType(Type paramType);

	public boolean modifyType(Type paramType);

	public boolean removeType(int paramInt);

	public Type getTypeByNo(int paramInt);

	public List<Type> getTypes();
}
