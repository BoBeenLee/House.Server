package com.house.service;

import com.house.model.Attach;
import com.house.model.Comment;
import com.house.model.Sudatalk;
import com.house.model.SudatalkCategory;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SudatalkService {
	public boolean addSudatalk(Sudatalk paramSudatalk,
			Attach[] paramArrayOfAttach);

	public boolean modifySudatalk(Sudatalk paramSudatalk,
			Attach[] paramArrayOfAttach);

	public boolean removeSudatalk(long paramLong);

	public Sudatalk getSudatalkByNo(long paramLong);

	public List<Sudatalk> getSudatalksByCateNo(int paramInt);

	public boolean addSudatalkCategory(SudatalkCategory paramSudatalkCategory);

	public boolean modifySudatalkCategory(SudatalkCategory paramSudatalkCategory);

	public boolean removeSudatalkCategory(int paramInt);

	public SudatalkCategory getSudatalkCategoryByNo(int paramInt);

	public boolean addComment(Comment paramComment);

	public boolean modifyComment(Comment paramComment);

	public boolean removeComment(long paramLong);

	public Comment getCommentByNo(long paramLong, int paramInt);

	public Comment[] getCommentBySrcNo(long paramLong1, int paramInt1,
			long paramLong2, int paramInt2);
}
