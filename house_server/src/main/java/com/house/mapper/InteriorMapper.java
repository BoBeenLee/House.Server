package com.house.mapper;

import com.house.model.Comment;
import com.house.model.Interior;
import com.house.model.InteriorCategory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InteriorMapper {
	public int insertInterior(Interior paramInterior);

	public int updateInterior(Interior paramInterior);

	public int deleteInterior(long paramLong);

	public Interior getInteriorByNo(long paramLong);

	public List<Interior> getInteriorsByCateNo(int paramInt);

	public int insertInteriorCategory(InteriorCategory paramInteriorCategory);

	public int updateInteriorCategory(InteriorCategory paramInteriorCategory);

	public int deleteInteriorCategory(int paramInt);

	public InteriorCategory getInteriorCategoryByNo(int paramInt);

	public int insertComment(Comment paramComment);

	public int updateComment(Comment paramComment);

	public int deleteComment(long paramLong);

	public Comment getCommentByNo(@Param("commentNo") long paramLong,
			@Param("profileType") int paramInt);

	public Comment[] getCommentBySrcNo(@Param("srcNo") long paramLong1,
			@Param("profileType") int paramInt1,
			@Param("commentNo") long paramLong2, @Param("pageNum") int paramInt2);
}
