package com.house.mapper;

import com.house.model.code.AP0001;
import com.house.model.code.AP0001.AP0001Res;
import com.house.model.code.AP0003;

import org.apache.ibatis.annotations.Param;

public interface APMapper {
	public AP0001.AP0001Res[] getInteriorAP0001Res(
			@Param("startNo") long paramLong, @Param("srcType") int paramInt1,
			@Param("profileType") int paramInt2, @Param("pgCnt") int paramInt3,
			@Param("poType") int paramInt4, @Param("usrId") String paramString,
			@Param("upAndDown") boolean paramBoolean);

	public AP0001.AP0001Res[] getSudatalkAP0001Res(
			@Param("startNo") long paramLong, @Param("srcType") int paramInt1,
			@Param("profileType") int paramInt2, @Param("pgCnt") int paramInt3,
			@Param("poType") int paramInt4, @Param("usrId") String paramString,
			@Param("upAndDown") boolean paramBoolean);

	public AP0003 getInteriorAP0003(@Param("brdNo") long paramLong,
			@Param("srcType") int paramInt1, @Param("profileType") int paramInt2);

	public AP0003 getSudatalkAP0003(@Param("brdNo") long paramLong,
			@Param("srcType") int paramInt1, @Param("profileType") int paramInt2);
}
