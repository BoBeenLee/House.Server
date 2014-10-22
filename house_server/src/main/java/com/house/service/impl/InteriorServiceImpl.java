package com.house.service.impl;

import com.house.mapper.InteriorMapper;
import com.house.model.Attach;
import com.house.model.Comment;
import com.house.model.Interior;
import com.house.model.InteriorCategory;
import com.house.model.InteriorCategory.CATEGORY_TYPE;
import com.house.service.FileService;
import com.house.service.InteriorService;
import com.house.service.UserService;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("interiorService")
public class InteriorServiceImpl implements InteriorService {
	@Autowired
	InteriorMapper interiorMapper;
	@Autowired
	FileService fileService;
	@Autowired
	UserService userService;

	public boolean addInterior(Interior interior, Attach[] attachs) {
		boolean isInterior = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		interior.setCateCd(InteriorCategory.CATEGORY_TYPE.ALL.value);
		interior.setCreatedByDate(timestamp);
		interior.setModifiedByDate(timestamp);

		isInterior = 1 == this.interiorMapper.insertInterior(interior);
		if (attachs != null) {
			Attach[] arrayOfAttach;
			int j = (arrayOfAttach = attachs).length;
			for (int i = 0; i < j; i++) {
				Attach attach = arrayOfAttach[i];
				attach.setSrcType(2);
				attach.setSrcNo(interior.getInteriorNo());

				isInterior = this.fileService.addAttach(attach);
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

		isInterior = 1 == this.interiorMapper.updateInterior(interior);

		isInterior = this.fileService.removeAttachsByNoType(
				interior.getInteriorNo(), 2);
		Attach[] arrayOfAttach;
		int j = (arrayOfAttach = attachs).length;
		for (int i = 0; i < j; i++) {
			Attach attach = arrayOfAttach[i];
			attach.setSrcType(2);
			attach.setSrcNo(interior.getInteriorNo());

			isInterior = this.fileService.addAttach(attach);
		}
		return isInterior;
	}

	public boolean removeInterior(long interiorNo) {
		boolean isInterior = false;

		isInterior = this.fileService.removeAttachsByNoType(interiorNo, 2);
		this.userService.removeLikeBySrcNo(interiorNo);
		this.userService.removeScrapBySrcNo(interiorNo);
		isInterior = 1 == this.interiorMapper.deleteInterior(interiorNo);
		return isInterior;
	}

	public Interior getInteriorByNo(long interiorNo) {
		return this.interiorMapper.getInteriorByNo(interiorNo);
	}

	public List<Interior> getInteriorsByCateNo(int cateNo) {
		List<Interior> Interiors = this.interiorMapper
				.getInteriorsByCateNo(cateNo);
		return Interiors;
	}

	public boolean addInteriorCategory(InteriorCategory interiorCategory) {
		boolean isInteriorCategory = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		interiorCategory.setDepth(1);
		interiorCategory.setCreatedByDate(timestamp);
		interiorCategory.setModifiedByDate(timestamp);

		isInteriorCategory = 1 == this.interiorMapper
				.insertInteriorCategory(interiorCategory);

		return isInteriorCategory;
	}

	public boolean modifyInteriorCategory(InteriorCategory interiorCategory) {
		boolean isInteriorCategory = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
		InteriorCategory tInteriorCategory = getInteriorCategoryByNo(interiorCategory
				.getCateNo());

		tInteriorCategory.setDepth(interiorCategory.getDepth());
		tInteriorCategory.setCateNm(interiorCategory.getCateNm());
		tInteriorCategory.setModifiedByDate(timestamp);

		isInteriorCategory = 1 == this.interiorMapper
				.updateInteriorCategory(tInteriorCategory);
		return isInteriorCategory;
	}

	public boolean removeInteriorCategory(int cateNo) {
		boolean isInteriorCategory = false;

		this.fileService.removeAttachsByCateNo(cateNo, 2);
		this.userService.removeLikeByCateNo(cateNo, 2);
		this.userService.removeScrapByCateNo(cateNo, 2);
		isInteriorCategory = 1 == this.interiorMapper
				.deleteInteriorCategory(cateNo);

		return isInteriorCategory;
	}

	public InteriorCategory getInteriorCategoryByNo(int cateNo) {
		InteriorCategory InteriorCategory = this.interiorMapper
				.getInteriorCategoryByNo(cateNo);
		return InteriorCategory;
	}

	public boolean addComment(Comment comment) {
		boolean isInterior = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		comment.setDepth(1);
		comment.setCreatedByDate(timestamp);
		comment.setModifiedByDate(timestamp);

		isInterior = 1 == this.interiorMapper.insertComment(comment);
		return isInterior;
	}

	public boolean modifyComment(Comment comment) {
		boolean isInterior = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		comment.setModifiedByDate(timestamp);
		isInterior = 1 == this.interiorMapper.updateComment(comment);
		return isInterior;
	}

	public boolean removeComment(long commentNo) {
		boolean isInterior = false;

		isInterior = 1 == this.interiorMapper.deleteComment(commentNo);
		return isInterior;
	}

	public Comment getCommentByNo(long commentNo, int profileType) {
		return this.interiorMapper.getCommentByNo(commentNo, profileType);
	}

	public Comment[] getCommentBySrcNo(long srcNo, int profileType,
			long commentNo, int commentCnt) {
		return this.interiorMapper.getCommentBySrcNo(srcNo, profileType,
				commentNo, commentCnt);
	}
}
