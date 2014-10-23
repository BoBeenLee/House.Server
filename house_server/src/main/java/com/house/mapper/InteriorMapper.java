package com.house.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.house.model.Comment;
import com.house.model.Interior;
import com.house.model.InteriorCategory;

public interface InteriorMapper {
	public int insertInterior(Interior interior);
	public int updateInterior(Interior interior);
	public int deleteInterior(long interiorNo);
	public Interior getInteriorByNo(long interiorNo);
	public List<Interior> getInteriorsByCateNo(int cateNo);
	
	public int insertInteriorCategory(InteriorCategory interiorCategory);
	public int updateInteriorCategory(InteriorCategory interiorCategory);
	public int deleteInteriorCategory(int cateNo);
	public InteriorCategory getInteriorCategoryByNo(int cateNo);
	
	public int insertComment(Comment comment);
	public int updateComment(Comment comment);
	public int deleteComment(long commentNo);
	public Comment getCommentByNo(@Param("commentNo") long commentN, @Param("profileType") int profileType);
	public Comment[] getCommentBySrcNo(@Param("srcNo") long srcNo, @Param("profileType") int profileType);
}
