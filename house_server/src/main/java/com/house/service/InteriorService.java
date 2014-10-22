package com.house.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import com.house.model.Attach;
import com.house.model.Comment;
import com.house.model.Interior;
import com.house.model.InteriorCategory;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface InteriorService {
	public boolean addInterior(Interior interior, Attach[] attachs);

	public boolean modifyInterior(Interior interior, Attach[] attachs);

	public boolean removeInterior(long interiorNo);

	public Interior getInteriorByNo(long interiorNo);

	public List<Interior> getInteriorsByCateNo(int cateNo);

	public boolean addInteriorCategory(InteriorCategory interiorCategory);

	public boolean modifyInteriorCategory(InteriorCategory interiorCategory);

	public boolean removeInteriorCategory(int cateNo);

	public InteriorCategory getInteriorCategoryByNo(int cateNo);

	public boolean addComment(Comment comment);

	public boolean modifyComment(Comment comment);

	public boolean removeComment(long commentNo);

	public Comment getCommentByNo(long commentNo, int profileType);

	public Comment[] getCommentBySrcNo(long srcNo, int profileType,
			long commentNo, int commentCnt);
}
