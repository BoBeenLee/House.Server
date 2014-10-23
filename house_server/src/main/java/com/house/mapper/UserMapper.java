package com.house.mapper;

import org.apache.ibatis.annotations.Param;

import com.house.model.Like;
import com.house.model.Scrap;
import com.house.model.User;

public interface UserMapper {
	public int insertUser(User user);
	public int deleteUser(long userNo);
	public int updateUser(User user);
	public User getUserById(String userId);
	public User getUserByNo(long userNo);
	
	public int insertLike(Like like);
	public int deleteLike(long likeNo);
	public Like getLikeByNo(long likeNo);
	public Like getLikeByNoType(@Param("usrNo") long usrNo, @Param("srcNo") long srcNo, @Param("srcType") int srcType);
	public int getLikeCount(@Param("srcNo") long srcNo, @Param("srcType") int srcType);
	
	public int insertScrap(Scrap scrap);
	public int deleteScrap(long scrapNo);
	public Scrap getScrapByNo(long scrapNo);
	public Scrap getScrapByNoType(@Param("usrNo") long usrNo, @Param("srcNo") long srcNo, @Param("srcType") int srcType);
	public int getScrapCount(@Param("srcNo") long srcNo, @Param("srcType") int srcType);
}
