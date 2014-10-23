package com.house.model.code;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AP0005 implements Serializable {
	private int type;
	private String usrId;
	private long brdNo;
	
	private int scrapCnt;
	private String resultYn;

	@JsonIgnore
	public int getType() {
		return type;
	}
	@JsonIgnore
	public String getUsrId() {
		return usrId;
	}
	@JsonIgnore
	public long getBrdNo() {
		return brdNo;
	}
	@JsonProperty("_scrap_cnt")
	public int getScrapCnt() {
		return scrapCnt;
	}
	@JsonProperty("_rslt_yn")
	public String getResultYn() {
		return resultYn;
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
	public void setScrapCnt(int scrapCnt) {
		this.scrapCnt = scrapCnt;
	}
	@JsonIgnore
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}