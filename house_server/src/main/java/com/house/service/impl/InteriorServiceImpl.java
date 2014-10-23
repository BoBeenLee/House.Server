package com.house.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.mapper.InteriorMapper;
import com.house.model.Attach;
import com.house.model.Comment;
import com.house.model.Interior;
import com.house.model.InteriorCategory;
import com.house.model.SrcType;
import com.house.model.code.AP0001;
import com.house.model.code.AP0001.AP0001Res;
import com.house.service.FileService;
import com.house.service.InteriorService;

@Service("interiorService")
public class InteriorServiceImpl implements InteriorService {
	@Autowired
	InteriorMapper interiorMapper;
	
	@Autowired
	FileService fileService;
	
	/* Interior
		외부 usrNo, subject, contents, tagNm;
	 * 	내부 cateCd, modified, created
	 *  srcType, srcNo
	 */
	public boolean addInterior(Interior interior, Attach[] attachs) {
		boolean isInterior = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
		
		interior.setCateCd(InteriorCategory.CATEGORY_TYPE.ALL.value);
		interior.setCreatedByDate(timestamp);
		interior.setModifiedByDate(timestamp);
		
		isInterior = (1 == interiorMapper.insertInterior(interior))? true : false;
		
		if(attachs != null){
			for(Attach attach : attachs){
				attach.setSrcType(SrcType.INTERIOR_TYPE);
				attach.setSrcNo(interior.getInteriorNo());
				
				isInterior = fileService.addAttach(attach);
			}
		}
		return isInterior;
	}

	public boolean modifyInterior(Interior interior, Attach[] attachs) {
		boolean isInterior = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
		
		interior.setCateCd(InteriorCategory.CATEGORY_TYPE.ALL.value);
		interior.setModifiedByDate(timestamp);
		
		isInterior = (1 == interiorMapper.updateInterior(interior))? true : false;

		isInterior = fileService.removeAttachsByNoType(interior.getInteriorNo(), SrcType.INTERIOR_TYPE);
		for(Attach attach : attachs){
			attach.setSrcType(SrcType.INTERIOR_TYPE);
			attach.setSrcNo(interior.getInteriorNo());
			
			isInterior = fileService.addAttach(attach);
		}
		return isInterior;
	}

	public boolean removeInterior(long interiorNo) {
		boolean isInterior = false;
		
		isInterior = fileService.removeAttachsByNoType(interiorNo, SrcType.INTERIOR_TYPE);
		isInterior = (1 == interiorMapper.deleteInterior(interiorNo))? true : false;
		return isInterior;
	}

	public Interior getInteriorByNo(long interiorNo) {
		return interiorMapper.getInteriorByNo(interiorNo);
	}

	public List<Interior> getInteriorsByCateNo(int cateNo){
		List<Interior> Interiors = interiorMapper.getInteriorsByCateNo(cateNo);
		return Interiors;
	}
	
	/* InteriorCategory
	 * 외부 depth, 	cateNm, 
	 * 내부 cateNo, modified, created
	*/
	public boolean addInteriorCategory(InteriorCategory interiorCategory) {
		boolean isInteriorCategory = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
		
		interiorCategory.setDepth(1);
		interiorCategory.setCreatedByDate(timestamp);
		interiorCategory.setModifiedByDate(timestamp);
		
		isInteriorCategory = (1 == interiorMapper.insertInteriorCategory(interiorCategory))? true : false;
		
		return isInteriorCategory;
	}

	public boolean modifyInteriorCategory(InteriorCategory interiorCategory) {
		boolean isInteriorCategory = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
		InteriorCategory tInteriorCategory = getInteriorCategoryByNo(interiorCategory.getCateNo());
		
		tInteriorCategory.setDepth(interiorCategory.getDepth());
		tInteriorCategory.setCateNm(interiorCategory.getCateNm());
		tInteriorCategory.setModifiedByDate(timestamp);
		
		isInteriorCategory = (1 == interiorMapper.updateInteriorCategory(tInteriorCategory))? true : false;
		return isInteriorCategory;
	}

	public boolean removeInteriorCategory(int cateNo) {
		boolean isInteriorCategory = false;
//		TODO 파일 첨부 수동으로 삭제해야될것.
		
		isInteriorCategory = (1 == interiorMapper.deleteInteriorCategory(cateNo))? true : false;
		return isInteriorCategory;
	}

	public InteriorCategory getInteriorCategoryByNo(int cateNo) {
		InteriorCategory InteriorCategory = interiorMapper.getInteriorCategoryByNo(cateNo);
		return InteriorCategory;
	}

	/*
	 * 		내부 depth, modified, created;
			외부 srcNo, contents
	 */
	public boolean addComment(Comment comment) {
		boolean isInterior = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
		
		comment.setDepth(1);
		comment.setCreatedByDate(timestamp);
		comment.setModifiedByDate(timestamp);
		
		isInterior = (1 == interiorMapper.insertComment(comment))? true : false;
		return isInterior;
	}

	public boolean modifyComment(Comment comment) {
		boolean isInterior = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		comment.setModifiedByDate(timestamp);
		isInterior = (1 == interiorMapper.updateComment(comment))? true : false;
		return isInterior;
	}

	public boolean removeComment(long commentNo) {
		boolean isInterior = false;
		
		isInterior = (1 == interiorMapper.deleteComment(commentNo))? true : false;
		return isInterior;
	}

	public Comment getCommentByNo(long commentNo, int profileType) {
		return interiorMapper.getCommentByNo(commentNo, profileType);
	}

	public Comment[] getCommentBySrcNo(long srcNo, int profileType) {
		return interiorMapper.getCommentBySrcNo(srcNo, profileType);
	}
}
