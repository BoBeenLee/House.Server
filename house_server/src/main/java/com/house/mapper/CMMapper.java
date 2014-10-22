package com.house.mapper;

import com.house.model.code.CM0001;
import com.house.model.code.CM0005;
import org.apache.ibatis.annotations.Param;

public interface CMMapper {
	public CM0001 getCM0001(@Param("usrId") String usrId,
			@Param("profileType") int profileType);

	public CM0005 getCM0005(@Param("usrId") String usrId,
			@Param("profileType") int profileType);
}
