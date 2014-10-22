package com.house.mapper;

import com.house.model.Like;
import com.house.model.Scrap;
import com.house.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	public int insertUser(User user);

	public int deleteUser(long userNo);

	public int updateUser(User user);

	public User getUserById(String userId);

	public User getUserByNo(long userNo);

	public int insertLike(Like like);

	public int deleteLike(long likeNo);

	public int deleteLikeBySrcNo(long srcNo);

	public int deleteLikeByCateNo(@Param("cateNo") long cateNo,
			@Param("srcType") int srcType);

	public Like getLikeByNo(long likeNo);

	public Like getLikeByNoType(@Param("usrNo") long usrNo,
			@Param("srcNo") long srcNo, @Param("srcType") int srcType);

	public int getLikeCount(@Param("srcNo") long srcNo,
			@Param("srcType") int srcType);

	public int insertScrap(Scrap scrap);

	public int deleteScrap(long scrapNo);

	public int deleteScrapBySrcNo(long srcNo);

	public int deleteScrapByCateNo(@Param("cateNo") long cateNo,
			@Param("srcType") int srcType);

	public Scrap getScrapByNo(long scrapNo);

	public Scrap getScrapByNoType(@Param("usrNo") long usrNo,
			@Param("srcNo") long srcNo, @Param("srcType") int srcType);

	public int getScrapCount(@Param("srcNo") long srcNo,
			@Param("srcType") int srcType);
}
