package com.house.mapper;

import com.house.model.code.AP0001;
import com.house.model.code.AP0001.AP0001Res;
import com.house.model.code.AP0003;

import org.apache.ibatis.annotations.Param;

public interface APMapper {
	public AP0001.AP0001Res[] getInteriorAP0001Res(
			@Param("startNo") long startNo, @Param("srcType") int srcType,
			@Param("profileType") int profileType, @Param("pgCnt") int pgCnt,
			@Param("poType") int poType, @Param("usrId") String usrId,
			@Param("upAndDown") boolean upAndDown);

	public AP0001.AP0001Res[] getSudatalkAP0001Res(
			@Param("startNo") long startNo, @Param("srcType") int srcType,
			@Param("profileType") int profileType, @Param("pgCnt") int pgCnt,
			@Param("poType") int poType, @Param("usrId") String usrId,
			@Param("upAndDown") boolean upAndDown);

	public AP0003 getInteriorAP0003(@Param("brdNo") long brdNo,
			@Param("srcType") int srcType, @Param("profileType") int profileType);

	public AP0003 getSudatalkAP0003(@Param("brdNo") long brdNo,
			@Param("srcType") int srcType, @Param("profileType") int profileType);
}
