package com.house.mapper;

import org.apache.ibatis.annotations.Param;

import com.house.model.code.AP0001.AP0001Res;
import com.house.model.code.AP0003;

public interface APMapper { 
	public AP0001Res[] getInteriorAP0001Res(@Param("startNo") long startNo, @Param("srcType") int srcType, @Param("profileType") int profileType, @Param("pgCnt") int pgCnt);
	public AP0001Res[] getSudatalkAP0001Res(@Param("startNo") long startNo, @Param("srcType") int srcType, @Param("profileType") int profileType, @Param("pgCnt") int pgCnt);
	
	public AP0003 getInteriorAP0003(@Param("brdNo") long brdNo, @Param("srcType") int srcType, @Param("profileType") int profileType);
	public AP0003 getSudatalkAP0003(@Param("brdNo") long brdNo, @Param("srcType") int srcType, @Param("profileType") int profileType);
}
