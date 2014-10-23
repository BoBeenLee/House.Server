package com.house.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.mapper.SudatalkMapper;
import com.house.model.Attach;
import com.house.model.Comment;
import com.house.model.InteriorCategory;
import com.house.model.SrcType;
import com.house.model.Sudatalk;
import com.house.model.SudatalkCategory;
import com.house.service.FileService;
import com.house.service.SudatalkService;

@Service("sudatalkService")
public class SudatalkServiceImpl implements SudatalkService{
	// Mapper
	@Autowired
	SudatalkMapper sudatalkMapper;
	
	// Service
	@Autowired
	FileService fileService;

	/*
		외부 usrNo, subject, contents, tagNm;
	 * 	내부 cateCd, modified, created
	 *  srcType, srcNo
	 */
	public boolean addSudatalk(Sudatalk sudatalk, Attach[] attachs) {
		boolean isSudatalk = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
		
		sudatalk.setCreatedByDate(timestamp);
		sudatalk.setModifiedByDate(timestamp);
		
		isSudatalk = (1 == sudatalkMapper.insertSudatalk(sudatalk))? true : false;
		
		if(attachs != null){
			for(Attach attach : attachs){
				attach.setSrcType(SrcType.SUDATALK_TYPE);
				attach.setSrcNo(sudatalk.getTalkNo());
				
				isSudatalk = fileService.addAttach(attach);
			}
		}
		return isSudatalk;
	}

	public boolean modifySudatalk(Sudatalk sudatalk, Attach[] attachs) {
		boolean isSudatalk = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
		
		sudatalk.setModifiedByDate(timestamp);
		
		isSudatalk = (1 == sudatalkMapper.updateSudatalk(sudatalk))? true : false;
		
		isSudatalk = fileService.removeAttachsByNoType(sudatalk.getTalkNo(), SrcType.SUDATALK_TYPE);
		for(Attach attach : attachs){
			attach.setSrcType(SrcType.SUDATALK_TYPE);
			attach.setSrcNo(sudatalk.getTalkNo());
			
			isSudatalk = fileService.addAttach(attach);
		}
		return isSudatalk;
	}

	public boolean removeSudatalk(long talkNo) {
		boolean isSudatalk = false;
		
		isSudatalk = fileService.removeAttachsByNoType(talkNo, SrcType.SUDATALK_TYPE);
		isSudatalk = (1 == sudatalkMapper.deleteSudatalk(talkNo))? true : false;
		return isSudatalk;
	}

	public Sudatalk getSudatalkByNo(long talkNo) {
		return sudatalkMapper.getSudatalkByNo(talkNo);
	}

	public List<Sudatalk> getSudatalksByCateNo(int cateNo){
		List<Sudatalk> sudatalks = sudatalkMapper.getSudatalksByCateNo(cateNo);
		return sudatalks;
	}
	
	/*
	 * 외부 depth, cateNm, 
	 * 내부 modified, created;
	 */
	public boolean addSudatalkCategory(SudatalkCategory sudatalkCategory) {
		boolean isSudatalkCategory = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
		
		sudatalkCategory.setCateNo(1);
		sudatalkCategory.setCreatedByDate(timestamp);
		sudatalkCategory.setModifiedByDate(timestamp);
		
		isSudatalkCategory = (1 == sudatalkMapper.insertSudatalkCategory(sudatalkCategory))? true : false;
		return isSudatalkCategory;
	}

	public boolean modifySudatalkCategory(SudatalkCategory sudatalkCategory) {
		boolean isSudatalkCategory = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
		SudatalkCategory tSudatalkCategory = getSudatalkCategoryByNo(sudatalkCategory.getCateNo());
		
		tSudatalkCategory.setDepth(sudatalkCategory.getDepth());
		tSudatalkCategory.setCateNm(sudatalkCategory.getCateNm());
		tSudatalkCategory.setModifiedByDate(timestamp);
		
		isSudatalkCategory = (1 == sudatalkMapper.updateSudatalkCategory(tSudatalkCategory))? true : false;
		return isSudatalkCategory;
	}

	public boolean removeSudatalkCategory(int cateNo) {
		boolean isSudatalkCategory = false;
		
//		TODO 파일 첨부 수동으로 삭제해야될것.
		isSudatalkCategory = (1 == sudatalkMapper.deleteSudatalkCategory(cateNo))? true : false;
		return isSudatalkCategory;
	}

	public SudatalkCategory getSudatalkCategoryByNo(int cateNo) {
		SudatalkCategory sudatalkCategory = sudatalkMapper.getSudatalkCategoryByNo(cateNo);
		return sudatalkCategory;
	}

	/*
	 * 		내부 depth, modified, created;
			외부 srcNo, contents
	 */
	public boolean addComment(Comment comment) {
		boolean isSudatalk = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
		
		comment.setDepth(1);
		comment.setCreatedByDate(timestamp);
		comment.setModifiedByDate(timestamp);
		isSudatalk = (1 == sudatalkMapper.insertComment(comment))? true : false;
		return isSudatalk;
	}

	public boolean modifyComment(Comment comment) {
		boolean isSudatalk = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		comment.setModifiedByDate(timestamp);
		isSudatalk = (1 == sudatalkMapper.updateComment(comment))? true : false;
		return isSudatalk;
	}

	public boolean removeComment(long commentNo) {
		boolean isSudatalk = false;
		
		isSudatalk = (1 == sudatalkMapper.deleteComment(commentNo))? true : false;
		return isSudatalk;
	}

	public Comment getCommentByNo(long commentNo, int profileType) {
		return sudatalkMapper.getCommentByNo(commentNo, profileType);
	}

	public Comment[] getCommentBySrcNo(long srcNo, int profileType) {
		return sudatalkMapper.getCommentBySrcNo(srcNo, profileType);
	}
}
