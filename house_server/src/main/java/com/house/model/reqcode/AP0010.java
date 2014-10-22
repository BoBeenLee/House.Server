package com.house.model.reqcode;

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

	@JsonProperty("_type")
	public int getType() {
		return this.type;
	}

	@JsonProperty("_brd_id")
	public String getBrdId() {
		return this.brdId;
	}

	@JsonProperty("_brd_no")
	public long getBrdNo() {
		return this.brdNo;
	}

	@JsonProperty("_img_nm")
	public String getImgNm() {
		return this.imgNm;
	}

	@JsonProperty("_img_origin_nm")
	public String getImgOriginNm() {
		return this.imgOriginNm;
	}

	@JsonProperty("_img_content")
	public byte[] getImgContent() {
		return this.imgContent;
	}

	@JsonProperty("_img_type")
	public String getImgType() {
		return this.imgType;
	}

	@JsonProperty("_img_size")
	public long getImgSize() {
		return this.imgSize;
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
	public void setBrdNo(long brdNo) {
		this.brdNo = brdNo;
	}

	@JsonIgnore
	public void setImgNm(String imgNm) {
		this.imgNm = imgNm;
	}

	@JsonIgnore
	public void setImgOriginNm(String imgOriginNm) {
		this.imgOriginNm = imgOriginNm;
	}

	@JsonIgnore
	public void setImgContent(byte[] imgContent) {
		this.imgContent = imgContent;
	}

	@JsonIgnore
	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	@JsonIgnore
	public void setImgSize(long imgSize) {
		this.imgSize = imgSize;
	}

	@JsonProperty("_rslt_yn")
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}
