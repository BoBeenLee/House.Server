package com.house.mapper;

import org.apache.ibatis.annotations.Param;

import com.house.model.code.*;


public interface CMMapper {
	public CM0005 getCM0005(@Param("usrId") String usrId, @Param("profileType") int profileType);
}
