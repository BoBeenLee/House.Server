package com.house.service.impl;

import com.house.mapper.UserMapper;
import com.house.model.Attach;
import com.house.model.Like;
import com.house.model.Scrap;
import com.house.model.User;
import com.house.service.FileService;
import com.house.service.UserService;
import java.sql.Timestamp;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	public static final String EXTERNAL_URL = "";
	public static final String IN_URL = "";
	@Autowired
	public UserMapper userMapper;
	@Autowired
	public FileService fileService;

	public boolean addUser(User user, Attach attach) {
		boolean isUser = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		user.setUsrSs("1234");
		user.setCreatedByDate(timestamp);
		user.setModifiedByDate(timestamp);

		isUser = 1 == this.userMapper.insertUser(user);
		if (attach != null) {
			attach.setUploadUsr(user.getUsrNo());
			attach.setSrcType(1);
			isUser = this.fileService.addAttach(attach);
		}
		return isUser;
	}

	public boolean removeUser(long userNo) {
		boolean isUser = false;

		Attach[] attachs = this.fileService.getAttachByUsrType(userNo, 1);
		Attach attach = null;
		if ((attachs.length > 0) && (attachs != null)) {
			attach = attachs[0];
		}
		if (attach != null) {
			isUser = this.fileService.removeAttach(attach.getAttachNo());
		}
		isUser = 1 == this.userMapper.deleteUser(userNo);
		return isUser;
	}

	public boolean modifyUser(User user, Attach attach) {
		boolean isUser = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		user.setModifiedByDate(timestamp);

		isUser = 1 == this.userMapper.updateUser(user);
		if (attach != null) {
			Attach[] attachs = this.fileService.getAttachByUsrType(
					user.getUsrNo(), 1);
			if (attachs != null) {
				isUser = this.fileService
						.removeAttach(attachs[0].getAttachNo());
			}
			attach.setUploadUsr(user.getUsrNo());
			attach.setSrcType(1);

			isUser = this.fileService.addAttach(attach);
		}
		return isUser;
	}

	public User getUserById(String usrId) {
		User user = this.userMapper.getUserById(usrId);
		return user;
	}

	public User getUserByNo(long userNo) {
		User user = this.userMapper.getUserByNo(userNo);
		return user;
	}

	public boolean addLike(Like like) {
		boolean isLike = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		like.setCreatedByDate(timestamp);
		isLike = 1 == this.userMapper.insertLike(like);
		return isLike;
	}

	public boolean removeLike(long likeNo) {
		boolean isLike = false;
		isLike = 1 == this.userMapper.deleteLike(likeNo);
		return isLike;
	}

	public Like getLikeByNo(long likeNo) {
		return this.userMapper.getLikeByNo(likeNo);
	}

	public Like getLikeByNoType(long usrNo, long srcNo, int srcType) {
		return this.userMapper.getLikeByNoType(usrNo, srcNo, srcType);
	}

	public int getLikeCount(long srcNo, int srcType) {
		return this.userMapper.getLikeCount(srcNo, srcType);
	}

	public boolean addScrap(Scrap scrap) {
		boolean isScrap = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		scrap.setCreatedByDate(timestamp);
		isScrap = 1 == this.userMapper.insertScrap(scrap);
		return isScrap;
	}

	public boolean removeScrap(long scrapNo) {
		boolean isScrap = false;
		isScrap = 1 == this.userMapper.deleteScrap(scrapNo);
		return isScrap;
	}

	public Scrap getScrapByNo(long scrapNo) {
		return this.userMapper.getScrapByNo(scrapNo);
	}

	public Scrap getScrapByNoType(long usrNo, long srcNo, int srcType) {
		return this.userMapper.getScrapByNoType(usrNo, srcNo, srcType);
	}

	public int getScrapCount(long srcNo, int srcType) {
		return this.userMapper.getScrapCount(srcNo, srcType);
	}

	public boolean removeLikeBySrcNo(long srcNo) {
		boolean isLike = false;
		isLike = 1 == this.userMapper.deleteLikeBySrcNo(srcNo);
		return isLike;
	}

	public boolean removeScrapBySrcNo(long srcNo) {
		boolean isScrap = false;
		isScrap = 1 == this.userMapper.deleteScrapBySrcNo(srcNo);
		return isScrap;
	}

	public boolean removeLikeByCateNo(long cateNo, int srcType) {
		boolean isLike = false;
		isLike = 1 == this.userMapper.deleteLikeByCateNo(cateNo, srcType);
		return isLike;
	}

	public boolean removeScrapByCateNo(long cateNo, int srcType) {
		boolean isScrap = false;
		isScrap = 1 == this.userMapper.deleteLikeByCateNo(cateNo, srcType);
		return isScrap;
	}
}
