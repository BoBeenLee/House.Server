package com.house.mapper;

import org.apache.ibatis.annotations.Param;

import com.house.model.Attach;

public interface FileMapper {
	public int insertAttach(Attach attach);
	public int updateAttach(Attach attach);
	public int deleteAttach(long attachNo);
	public int deleteAttachsByNoType(@Param("srcNo") long srcNo, @Param("srcType") int srcType);
	public Attach[] getAttachByNoType(@Param("srcNo") long srcNo, @Param("srcType") int srcType, @Param("uploadUsr") long uploadUsr);
}
