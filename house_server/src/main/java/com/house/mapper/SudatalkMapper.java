package com.house.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.house.model.Comment;
import com.house.model.JavaBean;
import com.house.model.Sudatalk;
import com.house.model.SudatalkCategory;

public interface SudatalkMapper {
	public int insertSudatalk(Sudatalk sudatalk);
	public int updateSudatalk(Sudatalk sudatalk);
	public int deleteSudatalk(long talkNo);
	public Sudatalk getSudatalkByNo(long talkNo);
	public List<Sudatalk> getSudatalksByCateNo(int cateNo);
	
	public int insertSudatalkCategory(SudatalkCategory sudatalkCategory);
	public int updateSudatalkCategory(SudatalkCategory sudatalkCategory);
	public int deleteSudatalkCategory(int cateNo);
	public SudatalkCategory getSudatalkCategoryByNo(int cateNo);
	
	public int insertComment(Comment comment);
	public int updateComment(Comment comment);
	public int deleteComment(long commentNo);
	public Comment getCommentByNo(@Param("commentNo") long commentN, @Param("profileType") int profileType);
	public Comment[] getCommentBySrcNo(@Param("srcNo") long srcNo, @Param("profileType") int profileType);
}
