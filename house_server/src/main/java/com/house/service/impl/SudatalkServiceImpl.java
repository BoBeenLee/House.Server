package com.house.service.impl;

import com.house.mapper.SudatalkMapper;
import com.house.model.Attach;
import com.house.model.Comment;
import com.house.model.Sudatalk;
import com.house.model.SudatalkCategory;
import com.house.service.FileService;
import com.house.service.SudatalkService;
import com.house.service.UserService;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sudatalkService")
public class SudatalkServiceImpl implements SudatalkService {
	@Autowired
	SudatalkMapper sudatalkMapper;
	@Autowired
	FileService fileService;
	@Autowired
	UserService userService;

	public boolean addSudatalk(Sudatalk sudatalk, Attach[] attachs) {
		boolean isSudatalk = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		sudatalk.setCreatedByDate(timestamp);
		sudatalk.setModifiedByDate(timestamp);

		isSudatalk = 1 == this.sudatalkMapper.insertSudatalk(sudatalk);
		if (attachs != null) {
			Attach[] arrayOfAttach;
			int j = (arrayOfAttach = attachs).length;
			for (int i = 0; i < j; i++) {
				Attach attach = arrayOfAttach[i];
				attach.setSrcType(3);
				attach.setSrcNo(sudatalk.getTalkNo());

				isSudatalk = this.fileService.addAttach(attach);
			}
		}
		return isSudatalk;
	}

	public boolean modifySudatalk(Sudatalk sudatalk, Attach[] attachs) {
		boolean isSudatalk = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		sudatalk.setModifiedByDate(timestamp);

		isSudatalk = 1 == this.sudatalkMapper.updateSudatalk(sudatalk);

		isSudatalk = this.fileService.removeAttachsByNoType(
				sudatalk.getTalkNo(), 3);
		Attach[] arrayOfAttach;
		int j = (arrayOfAttach = attachs).length;
		for (int i = 0; i < j; i++) {
			Attach attach = arrayOfAttach[i];
			attach.setSrcType(3);
			attach.setSrcNo(sudatalk.getTalkNo());

			isSudatalk = this.fileService.addAttach(attach);
		}
		return isSudatalk;
	}

	public boolean removeSudatalk(long talkNo) {
		boolean isSudatalk = false;

		isSudatalk = this.fileService.removeAttachsByNoType(talkNo, 3);
		this.userService.removeLikeBySrcNo(talkNo);
		this.userService.removeScrapBySrcNo(talkNo);
		isSudatalk = 1 == this.sudatalkMapper.deleteSudatalk(talkNo);
		return isSudatalk;
	}

	public Sudatalk getSudatalkByNo(long talkNo) {
		return this.sudatalkMapper.getSudatalkByNo(talkNo);
	}

	public List<Sudatalk> getSudatalksByCateNo(int cateNo) {
		List<Sudatalk> sudatalks = this.sudatalkMapper
				.getSudatalksByCateNo(cateNo);
		return sudatalks;
	}

	public boolean addSudatalkCategory(SudatalkCategory sudatalkCategory) {
		boolean isSudatalkCategory = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		sudatalkCategory.setCateNo(1);
		sudatalkCategory.setCreatedByDate(timestamp);
		sudatalkCategory.setModifiedByDate(timestamp);

		isSudatalkCategory = 1 == this.sudatalkMapper
				.insertSudatalkCategory(sudatalkCategory);
		return isSudatalkCategory;
	}

	public boolean modifySudatalkCategory(SudatalkCategory sudatalkCategory) {
		boolean isSudatalkCategory = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
		SudatalkCategory tSudatalkCategory = getSudatalkCategoryByNo(sudatalkCategory
				.getCateNo());

		tSudatalkCategory.setDepth(sudatalkCategory.getDepth());
		tSudatalkCategory.setCateNm(sudatalkCategory.getCateNm());
		tSudatalkCategory.setModifiedByDate(timestamp);

		isSudatalkCategory = 1 == this.sudatalkMapper
				.updateSudatalkCategory(tSudatalkCategory);
		return isSudatalkCategory;
	}

	public boolean removeSudatalkCategory(int cateNo) {
		boolean isSudatalkCategory = false;

		this.fileService.removeAttachsByCateNo(cateNo, 3);
		this.userService.removeLikeByCateNo(cateNo, 3);
		this.userService.removeScrapByCateNo(cateNo, 3);
		isSudatalkCategory = 1 == this.sudatalkMapper
				.deleteSudatalkCategory(cateNo);

		return isSudatalkCategory;
	}

	public SudatalkCategory getSudatalkCategoryByNo(int cateNo) {
		SudatalkCategory sudatalkCategory = this.sudatalkMapper
				.getSudatalkCategoryByNo(cateNo);
		return sudatalkCategory;
	}

	public boolean addComment(Comment comment) {
		boolean isSudatalk = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		comment.setDepth(1);
		comment.setCreatedByDate(timestamp);
		comment.setModifiedByDate(timestamp);
		isSudatalk = 1 == this.sudatalkMapper.insertComment(comment);
		return isSudatalk;
	}

	public boolean modifyComment(Comment comment) {
		boolean isSudatalk = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		comment.setModifiedByDate(timestamp);
		isSudatalk = 1 == this.sudatalkMapper.updateComment(comment);
		return isSudatalk;
	}

	public boolean removeComment(long commentNo) {
		boolean isSudatalk = false;

		isSudatalk = 1 == this.sudatalkMapper.deleteComment(commentNo);
		return isSudatalk;
	}

	public Comment getCommentByNo(long commentNo, int profileType) {
		return this.sudatalkMapper.getCommentByNo(commentNo, profileType);
	}

	public Comment[] getCommentBySrcNo(long srcNo, int profileType,
			long commentNo, int commentCnt) {
		return this.sudatalkMapper.getCommentBySrcNo(srcNo, profileType,
				commentNo, commentCnt);
	}
}
