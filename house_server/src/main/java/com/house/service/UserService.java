package com.house.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import com.house.model.Attach;
import com.house.model.Like;
import com.house.model.Scrap;
import com.house.model.User;

@Transactional
public interface UserService{
	public boolean addUser(User user, Attach attach);
	public boolean modifyUser(User user, Attach attach);
	public boolean removeUser(long userNo);

	public User getUserById(String userId);
	public User getUserByNo(long userNo);
	
	public boolean addLike(Like like);
	public boolean removeLike(long likeNo);
	public Like getLikeByNo(long likeNo);
	public Like getLikeByNoType(long usrNo, long srcNo,  int srcType);
	public int getLikeCount(long srcNo, int srcType);

	public boolean addScrap(Scrap scrap);
	public boolean removeScrap(long scrapNo);
	public Scrap getScrapByNo(long scrapNo);
	public Scrap getScrapByNoType(long usrNo, long srcNo, int srcType);
	public int getScrapCount(long srcNo, int srcType);
}
