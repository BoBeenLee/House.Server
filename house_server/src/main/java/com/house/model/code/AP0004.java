package com.house.model.code;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class AP0004 implements Serializable {
	private int type;
	private int cateNo;
	private String usrId;
	private long brdNo;
	private int likeCnt;
	private String resultYn;

	@JsonIgnore
	public int getCateNo() {
		return this.cateNo;
	}

	@JsonProperty("_cate_no")
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	@JsonIgnore
	public int getType() {
		return this.type;
	}

	@JsonIgnore
	public String getUsrId() {
		return this.usrId;
	}

	@JsonIgnore
	public long getBrdNo() {
		return this.brdNo;
	}

	@JsonProperty("_like_cnt")
	public int getLikeCnt() {
		return this.likeCnt;
	}

	@JsonProperty("_rslt_yn")
	public String getResultYn() {
		return this.resultYn;
	}

	@JsonProperty("_type")
	public void setType(int type) {
		this.type = type;
	}

	@JsonProperty("_usr_id")
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	@JsonProperty("_brd_no")
	public void setBrdNo(long reqPoNo) {
		this.brdNo = reqPoNo;
	}

	@JsonIgnore
	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	@JsonIgnore
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}
