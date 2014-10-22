package com.house.mapper;

import com.house.model.Like;
import com.house.model.Scrap;
import com.house.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	public int insertUser(User paramUser);

	public int deleteUser(long paramLong);

	public int updateUser(User paramUser);

	public User getUserById(String paramString);

	public User getUserByNo(long paramLong);

	public int insertLike(Like paramLike);

	public int deleteLike(long paramLong);

	public int deleteLikeBySrcNo(long paramLong);

	public int deleteLikeByCateNo(@Param("cateNo") long paramLong,
			@Param("srcType") int paramInt);

	public Like getLikeByNo(long paramLong);

	public Like getLikeByNoType(@Param("usrNo") long paramLong1,
			@Param("srcNo") long paramLong2, @Param("srcType") int paramInt);

	public int getLikeCount(@Param("srcNo") long paramLong,
			@Param("srcType") int paramInt);

	public int insertScrap(Scrap paramScrap);

	public int deleteScrap(long paramLong);

	public int deleteScrapBySrcNo(long paramLong);

	public int deleteScrapByCateNo(@Param("cateNo") long paramLong,
			@Param("srcType") int paramInt);

	public Scrap getScrapByNo(long paramLong);

	public Scrap getScrapByNoType(@Param("usrNo") long paramLong1,
			@Param("srcNo") long paramLong2, @Param("srcType") int paramInt);

	public int getScrapCount(@Param("srcNo") long paramLong,
			@Param("srcType") int paramInt);
}
