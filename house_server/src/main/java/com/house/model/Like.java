package com.house.model;

import com.house.util.DateUtils;
import java.sql.Timestamp;

public class Like {
	private long likeNo;
	private long usrNo;
	private int srcType;
	private long srcNo;
	private int cateNo;
	private String created;

	public int getCateNo() {
		return this.cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public long getLikeNo() {
		return this.likeNo;
	}

	public void setLikeNo(long likeNo) {
		this.likeNo = likeNo;
	}

	public long getUsrNo() {
		return this.usrNo;
	}

	public void setUsrNo(long usrNo) {
		this.usrNo = usrNo;
	}

	public int getSrcType() {
		return this.srcType;
	}

	public void setSrcType(int srcType) {
		this.srcType = srcType;
	}

	public long getSrcNo() {
		return this.srcNo;
	}

	public void setSrcNo(long srcNo) {
		this.srcNo = srcNo;
	}

	public void setCreatedByDate(Timestamp timestamp) {
		this.created = DateUtils.dateToString(timestamp, DateUtils.dateForm1);
	}

	public String getCreated() {
		return this.created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
}