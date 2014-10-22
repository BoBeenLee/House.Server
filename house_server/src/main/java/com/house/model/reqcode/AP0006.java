package com.house.model.reqcode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class AP0006 implements Serializable {
	private int type;
	private String brdId;
	private String brdSubject;
	private int brdCateNo;
	private String brdTag;
	private byte[] brdContents;
	private long brdNo;
	private String resultYn;

	@JsonProperty("_type")
	public int getType() {
		return this.type;
	}

	@JsonProperty("_brd_id")
	public String getBrdId() {
		return this.brdId;
	}

	@JsonProperty("_brd_subject")
	public String getBrdSubject() {
		return this.brdSubject;
	}

	@JsonProperty("_brd_cate_no")
	public int getBrdCateNo() {
		return this.brdCateNo;
	}

	@JsonProperty("_brd_tag")
	public String getBrdTag() {
		return this.brdTag;
	}

	@JsonProperty("_brd_contents")
	public byte[] getBrdContents() {
		return this.brdContents;
	}

	@JsonProperty("_brd_no")
	public long getBrdNo() {
		return this.brdNo;
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
	public void setBrdId(String brdId) {
		this.brdId = brdId;
	}

	@JsonIgnore
	public void setBrdSubject(String brdSubject) {
		this.brdSubject = brdSubject;
	}

	@JsonIgnore
	public void setBrdCateNo(int brdCateNo) {
		this.brdCateNo = brdCateNo;
	}

	@JsonIgnore
	public void setBrdTag(String brdTag) {
		this.brdTag = brdTag;
	}

	@JsonIgnore
	public void setBrdContents(byte[] brdContents) {
		this.brdContents = brdContents;
	}

	@JsonProperty("_brd_no")
	public void setBrdNo(long articleId) {
		this.brdNo = articleId;
	}

	@JsonProperty("_rslt_yn")
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}
