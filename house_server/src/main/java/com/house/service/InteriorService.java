package com.house.service;

import com.house.model.Attach;
import com.house.model.Comment;
import com.house.model.Interior;
import com.house.model.InteriorCategory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface InteriorService {
	public boolean addInterior(Interior paramInterior,
			Attach[] paramArrayOfAttach);

	public boolean modifyInterior(Interior paramInterior,
			Attach[] paramArrayOfAttach);

	public boolean removeInterior(long paramLong);

	public Interior getInteriorByNo(long paramLong);

	public boolean addInteriorCategory(InteriorCategory paramInteriorCategory);

	public boolean modifyInteriorCategory(InteriorCategory paramInteriorCategory);

	public boolean removeInteriorCategory(int paramInt);

	public InteriorCategory getInteriorCategoryByNo(int paramInt);

	public boolean addComment(Comment paramComment);

	public boolean modifyComment(Comment paramComment);

	public boolean removeComment(long paramLong);

	public Comment getCommentByNo(long paramLong, int paramInt);

	public Comment[] getCommentBySrcNo(long paramLong1, int paramInt1,
			long paramLong2, int paramInt2);
}
