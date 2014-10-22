package com.house.model.reqcode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class AP0005 implements Serializable {
	private int type;
	private int cateNo;
	private String usrId;
	private long brdNo;
	private int scrapCnt;
	private String resultYn;

	@JsonProperty("_cate_no")
	public int getCateNo() {
		return this.cateNo;
	}

	@JsonIgnore
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	@JsonProperty("_type")
	public int getType() {
		return this.type;
	}

	@JsonProperty("_usr_id")
	public String getUsrId() {
		return this.usrId;
	}

	@JsonProperty("_brd_no")
	public long getBrdNo() {
		return this.brdNo;
	}

	@JsonIgnore
	public int getScrapCnt() {
		return this.scrapCnt;
	}

	@JsonIgnore
	public String getResultYn() {
		return this.resultYn;
	}

	@JsonIgnore
	public void setType(int type) {
		this.type = type;
	}

	@JsonIgnore
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	@JsonIgnore
	public void setBrdNo(long reqPoNo) {
		this.brdNo = reqPoNo;
	}

	@JsonProperty("_scrap_cnt")
	public void setScrapCnt(int scrapCnt) {
		this.scrapCnt = scrapCnt;
	}

	@JsonProperty("_rslt_yn")
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}
