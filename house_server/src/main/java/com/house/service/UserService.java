package com.house.service;

import java.sql.Timestamp;
import java.util.Calendar;

import com.house.model.Attach;
import com.house.model.Like;
import com.house.model.Scrap;
import com.house.model.User;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {
	public boolean addUser(User user, Attach attach);

	public boolean removeUser(long userNo);

	public boolean modifyUser(User user, Attach attach);

	public User getUserById(String usrId);

	public User getUserByNo(long userNo);

	public boolean addLike(Like like);

	public boolean removeLike(long likeNo);

	public Like getLikeByNo(long likeNo);

	public Like getLikeByNoType(long usrNo, long srcNo, int srcType);

	public int getLikeCount(long srcNo, int srcType);

	public boolean addScrap(Scrap scrap);

	public boolean removeScrap(long scrapNo);

	public Scrap getScrapByNo(long scrapNo);

	public Scrap getScrapByNoType(long usrNo, long srcNo, int srcType);

	public int getScrapCount(long srcNo, int srcType);

	public boolean removeLikeBySrcNo(long srcNo);

	public boolean removeScrapBySrcNo(long srcNo);

	public boolean removeLikeByCateNo(long cateNo, int srcType);

	public boolean removeScrapByCateNo(long cateNo, int srcType);
}
