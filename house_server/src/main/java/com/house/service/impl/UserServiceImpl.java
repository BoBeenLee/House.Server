package com.house.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.mapper.FileMapper;
import com.house.mapper.UserMapper;
import com.house.model.Attach;
import com.house.model.Like;
import com.house.model.Scrap;
import com.house.model.SrcType;
import com.house.model.TransferMultipartFile;
import com.house.model.User;
import com.house.service.FileService;
import com.house.service.UserService;
import com.house.util.BeanUtils;

@Service("userService")
public class UserServiceImpl implements UserService {
	public static final String EXTERNAL_URL = "";
	public static final String IN_URL = "";

	// Mapper
	@Autowired
	public UserMapper userMapper;

	// Service
	@Autowired
	public FileService fileService;

	// User
	// 외부 - usrId, usrPw, usrNm, ,termsYN, psPlatform, psId, psRevokeYN,
	// psAppVer, deviceNM, usrSts
	// 내부 - usrSs, modified, created

	public boolean addUser(User user, Attach attach) {
		boolean isUser = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		user.setUsrSs("1234");
		user.setCreatedByDate(timestamp);
		user.setModifiedByDate(timestamp);

		isUser = (1 == userMapper.insertUser(user)) ? true : false;
		if (attach != null) {
			attach.setUploadUsr(user.getUsrNo());
			attach.setSrcType(SrcType.PROFILE_TYPE);
			isUser = fileService.addAttach(attach);
		}
		return isUser;
	}

	public boolean removeUser(long userNo) {
		boolean isUser = false;

		Attach[] attachs = fileService.getAttachByUsrType(userNo,
				SrcType.PROFILE_TYPE);
		Attach attach = null;

//		System.out.println(attachs.length);
		if (attachs.length > 0 && attachs != null)
			attach = attachs[0];
		if (attach != null)
			isUser = fileService.removeAttach(attach.getAttachNo());
		isUser = (1 == userMapper.deleteUser(userNo)) ? true : false;
		return isUser;
	}

	public boolean modifyUser(User user, Attach attach) {
		boolean isUser = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
		
		user.setModifiedByDate(timestamp);
		
		isUser = (1 == userMapper.updateUser(user)) ? true : false;

		if(attach != null){
			Attach[] attachs = fileService.getAttachByUsrType(user.getUsrNo(), SrcType.PROFILE_TYPE);
	
			if (attachs != null) 
				isUser = fileService.removeAttach(attachs[0].getAttachNo());
			attach.setUploadUsr(user.getUsrNo());
			attach.setSrcType(SrcType.PROFILE_TYPE);
		
			isUser = fileService.addAttach(attach);
		}
		return isUser;
	}

	public User getUserById(String userId) {
		User user = userMapper.getUserById(userId);
		return user;
	}

	public User getUserByNo(long userNo) {
		User user = userMapper.getUserByNo(userNo);
		return user;
	}

	// Like
	/*
	 * 외부 usrNo, srcType, srcNo, 내부 created;
	 */
	public boolean addLike(Like like) {
		boolean isLike = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		like.setCreatedByDate(timestamp);
		isLike = (1 == userMapper.insertLike(like)) ? true : false;
		return isLike;
	}

	public boolean removeLike(long likeNo) {
		boolean isLike = false;
		isLike = (1 == userMapper.deleteLike(likeNo)) ? true : false;
		return isLike;
	}

	public Like getLikeByNo(long likeNo) {
		return userMapper.getLikeByNo(likeNo);
	}

	public Like getLikeByNoType(long usrNo, long srcNo, int srcType) {
		return userMapper.getLikeByNoType(usrNo, srcNo, srcType);
	}

	public int getLikeCount(long srcNo, int srcType) {
		return userMapper.getLikeCount(srcNo, srcType);
	}
	
	// Scrap
	/*
	 * 외부 usrNo, srcType, srcNo, 내부 created
	 */
	public boolean addScrap(Scrap scrap) {
		boolean isScrap = false;
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		scrap.setCreatedByDate(timestamp);
		isScrap = (1 == userMapper.insertScrap(scrap)) ? true : false;
		return isScrap;
	}

	public boolean removeScrap(long scrapNo) {
		boolean isScrap = false;
		isScrap = (1 == userMapper.deleteScrap(scrapNo)) ? true : false;
		return isScrap;
	}

	public Scrap getScrapByNo(long scrapNo) {
		return userMapper.getScrapByNo(scrapNo);
	}
	
	public Scrap getScrapByNoType(long usrNo, long srcNo, int srcType) {
		return  userMapper.getScrapByNoType(usrNo, srcNo, srcType);
	}

	public int getScrapCount(long srcNo, int srcType) {
		return userMapper.getScrapCount(srcNo, srcType);
	}
	
}
