package com.house.mapper;

import com.house.model.Comment;
import com.house.model.Sudatalk;
import com.house.model.SudatalkCategory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SudatalkMapper {
	public int insertSudatalk(Sudatalk paramSudatalk);

	public int updateSudatalk(Sudatalk paramSudatalk);

	public int deleteSudatalk(long paramLong);

	public Sudatalk getSudatalkByNo(long paramLong);

	public List<Sudatalk> getSudatalksByCateNo(int paramInt);

	public int insertSudatalkCategory(SudatalkCategory paramSudatalkCategory);

	public int updateSudatalkCategory(SudatalkCategory paramSudatalkCategory);

	public int deleteSudatalkCategory(int paramInt);

	public SudatalkCategory getSudatalkCategoryByNo(int paramInt);

	public int insertComment(Comment paramComment);

	public int updateComment(Comment paramComment);

	public int deleteComment(long paramLong);

	public Comment getCommentByNo(@Param("commentNo") long paramLong,
			@Param("profileType") int paramInt);

	public Comment[] getCommentBySrcNo(@Param("srcNo") long paramLong1,
			@Param("profileType") int paramInt1,
			@Param("commentNo") long paramLong2, @Param("pageNum") int paramInt2);
}
