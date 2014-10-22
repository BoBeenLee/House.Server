package com.house.service;

import com.house.model.Attach;
import com.house.model.Like;
import com.house.model.Scrap;
import com.house.model.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {
	public boolean addUser(User paramUser, Attach paramAttach);

	public boolean modifyUser(User paramUser, Attach paramAttach);

	public boolean removeUser(long paramLong);

	public User getUserById(String paramString);

	public User getUserByNo(long paramLong);

	public boolean addLike(Like paramLike);

	public boolean removeLike(long paramLong);

	public boolean removeLikeBySrcNo(long paramLong);

	public boolean removeLikeByCateNo(long paramLong, int paramInt);

	public Like getLikeByNo(long paramLong);

	public Like getLikeByNoType(long paramLong1, long paramLong2, int paramInt);

	public int getLikeCount(long paramLong, int paramInt);

	public boolean addScrap(Scrap paramScrap);

	public boolean removeScrap(long paramLong);

	public boolean removeScrapBySrcNo(long paramLong);

	public boolean removeScrapByCateNo(long paramLong, int paramInt);

	public Scrap getScrapByNo(long paramLong);

	public Scrap getScrapByNoType(long paramLong1, long paramLong2, int paramInt);

	public int getScrapCount(long paramLong, int paramInt);
}
