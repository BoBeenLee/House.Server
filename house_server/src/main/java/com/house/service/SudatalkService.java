package com.house.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.house.model.Attach;
import com.house.model.Comment;
import com.house.model.Sudatalk;
import com.house.model.SudatalkCategory;
import com.house.model.TransferMultipartFile;

@Transactional
public interface SudatalkService {
	public boolean addSudatalk(Sudatalk sudatalk, Attach[] attachs);
	public boolean modifySudatalk(Sudatalk sudatalk, Attach[] attachs);
	public boolean removeSudatalk(long talkNo);
	public Sudatalk getSudatalkByNo(long talkNo);
	public List<Sudatalk> getSudatalksByCateNo(int cateNo);
	
	public boolean addSudatalkCategory(SudatalkCategory sudatalkCategory);
	public boolean modifySudatalkCategory(SudatalkCategory sudatalkCategory);
	public boolean removeSudatalkCategory(int cateNo);
	public SudatalkCategory getSudatalkCategoryByNo(int cateNo);
	
	public boolean addComment(Comment comment);
	public boolean modifyComment(Comment comment);
	public boolean removeComment(long commentNo);
	public Comment getCommentByNo(long commentNo, int profileType);
	public Comment[] getCommentBySrcNo(long srcNo, int profileType);
}
