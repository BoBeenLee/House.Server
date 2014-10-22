package com.house.model.code;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AP0007 {
	private int type;
	private String brdId;
	private long brdNo;
	private String resultYn;

	@JsonIgnore
	public int getType() {
		return this.type;
	}

	@JsonIgnore
	public String getBrdId() {
		return this.brdId;
	}

	@JsonIgnore
	public long getBrdNo() {
		return this.brdNo;
	}

	@JsonProperty("_rslt_yn")
	public String getResultYn() {
		return this.resultYn;
	}

	@JsonProperty("_type")
	public void setType(int type) {
		this.type = type;
	}

	@JsonProperty("_brd_id")
	public void setBrdId(String brdId) {
		this.brdId = brdId;
	}

	@JsonProperty("_brd_no")
	public void setBrdNo(long articleId) {
		this.brdNo = articleId;
	}

	@JsonIgnore
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}
