package com.house.model.code;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class AP0010 implements Serializable {
	private int type;
	private String brdId;
	private long brdNo;
	public String imgNm;
	public String imgOriginNm;
	public byte[] imgContent;
	public String imgType;
	public long imgSize;
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

	@JsonIgnore
	public String getImgNm() {
		return this.imgNm;
	}

	@JsonIgnore
	public String getImgOriginNm() {
		return this.imgOriginNm;
	}

	@JsonIgnore
	public byte[] getImgContent() {
		return this.imgContent;
	}

	@JsonIgnore
	public String getImgType() {
		return this.imgType;
	}

	@JsonIgnore
	public long getImgSize() {
		return this.imgSize;
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
	public void setBrdNo(long brdNo) {
		this.brdNo = brdNo;
	}

	@JsonProperty("_img_nm")
	public void setImgNm(String imgNm) {
		this.imgNm = imgNm;
	}

	@JsonProperty("_img_origin_nm")
	public void setImgOriginNm(String imgOriginNm) {
		this.imgOriginNm = imgOriginNm;
	}

	@JsonProperty("_img_content")
	public void setImgContent(byte[] imgContent) {
		this.imgContent = imgContent;
	}

	@JsonProperty("_img_type")
	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	@JsonProperty("_img_size")
	public void setImgSize(long imgSize) {
		this.imgSize = imgSize;
	}

	@JsonIgnore
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}
