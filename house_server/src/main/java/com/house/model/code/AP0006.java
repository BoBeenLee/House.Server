package com.house.model.code;

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

	@JsonIgnore
	public int getType() {
		return this.type;
	}

	@JsonIgnore
	public String getBrdId() {
		return this.brdId;
	}

	@JsonIgnore
	public String getBrdSubject() {
		return this.brdSubject;
	}

	@JsonIgnore
	public int getBrdCateNo() {
		return this.brdCateNo;
	}

	@JsonIgnore
	public String getBrdTag() {
		return this.brdTag;
	}

	@JsonIgnore
	public byte[] getBrdContents() {
		return this.brdContents;
	}

	@JsonProperty("_brd_no")
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

	@JsonProperty("_brd_subject")
	public void setBrdSubject(String brdSubject) {
		this.brdSubject = brdSubject;
	}

	@JsonProperty("_brd_cate_no")
	public void setBrdCateNo(int brdCateNo) {
		this.brdCateNo = brdCateNo;
	}

	@JsonProperty("_brd_tag")
	public void setBrdTag(String brdTag) {
		this.brdTag = brdTag;
	}

	@JsonProperty("_brd_contents")
	public void setBrdContents(byte[] brdContents) {
		this.brdContents = brdContents;
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
