package com.house.mapper;

import com.house.model.Attach;
import org.apache.ibatis.annotations.Param;

public interface FileMapper {
	public int insertAttach(Attach paramAttach);

	public int updateAttach(Attach paramAttach);

	public int deleteAttach(long paramLong);

	public int deleteAttachsByNoType(@Param("srcNo") long paramLong,
			@Param("srcType") int paramInt);

	public int deleteAttachsByCateNo(@Param("cateNo") long paramLong,
			@Param("srcType") int paramInt);

	public Attach[] getAttachByNoType(@Param("srcNo") long paramLong1,
			@Param("srcType") int paramInt, @Param("uploadUsr") long paramLong2);

	public Attach getAttachByExUrl(@Param("exUrl") String paramString);
}
