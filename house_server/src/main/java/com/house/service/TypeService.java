package com.house.service;

import com.house.model.Type;
import java.util.List;

public interface TypeService {
	public boolean addType(Type type);

	public boolean modifyType(Type type);

	public boolean removeType(int typeNo);

	public Type getTypeByNo(int typeNo);

	public List<Type> getTypes();
}
