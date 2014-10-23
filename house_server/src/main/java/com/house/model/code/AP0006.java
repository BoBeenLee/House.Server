package com.house.model.code;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AP0006 implements Serializable {
	private int type;
	private String brdId;
	private String brdSubject;
	private int brdCateNo;
	private String brdTag;
	private byte[] brdContents;
	private List<AP0006Img> brdImg;
	private long brdNo;
	
	private String resultYn;

	@JsonIgnore
	public int getType() {
		return type;
	}
	@JsonIgnore
	public String getBrdId() {
		return brdId;
	}
	@JsonIgnore
	public String getBrdSubject() {
		return brdSubject;
	}
	@JsonIgnore
	public int getBrdCateNo() {
		return brdCateNo;
	}
	@JsonIgnore
	public String getBrdTag() {
		return brdTag;
	}
	@JsonIgnore
	public byte[] getBrdContents() {
		return brdContents;
	}
	@JsonIgnore
	public List<AP0006Img> getBrdImg() {
		return brdImg;
	}
	@JsonIgnore
	public long getBrdNo() {
		return brdNo;
	}
	
	@JsonProperty("_rslt_yn")
	public String getResultYn() {
		return resultYn;
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
	@JsonProperty("_brd_img")
	public void setBrdImg(List<AP0006Img> brdImg) {
		this.brdImg = brdImg;
	}
	@JsonProperty("_brd_no")
	public void setBrdNo(long articleId) {
		this.brdNo = articleId;
	}
	@JsonIgnore
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}

	public static class AP0006Img {
		@JsonProperty("_img_nm")
		public String imgNm;
		@JsonProperty("_img_origin_nm")
		public String imgOriginNm;
		@JsonProperty("_img_content")
		public byte[] imgContent;
		@JsonProperty("_img_type")
		public String imgType;
		@JsonProperty("_img_size")
		public long imgSize;
	}
}