package com.house.model.code;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CM0006 {
	private String usrId;
	private String usrPw;
	private String custName;
	private int usrSts;
	private CM0006Img usrImg;
	private String resultYn;

	@JsonIgnore
	public String getUsrId() {
		return this.usrId;
	}

	@JsonIgnore
	public String getUsrPw() {
		return this.usrPw;
	}

	@JsonIgnore
	public String getCustName() {
		return this.custName;
	}

	@JsonIgnore
	public int getUsrSts() {
		return this.usrSts;
	}

	@JsonIgnore
	public CM0006Img getUsrImg() {
		return this.usrImg;
	}

	@JsonProperty("_rslt_yn")
	public String getResultYn() {
		return this.resultYn;
	}

	@JsonProperty("_usr_id")
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	@JsonProperty("_usr_pw")
	public void setUsrPw(String usrPw) {
		this.usrPw = usrPw;
	}

	@JsonProperty("_custname")
	public void setCustName(String custName) {
		this.custName = custName;
	}

	@JsonProperty("_sts")
	public void setUsrSts(int usrSts) {
		this.usrSts = usrSts;
	}

	@JsonProperty("_usr_img")
	public void setUsrImg(CM0006Img usrImg) {
		this.usrImg = usrImg;
	}

	@JsonIgnore
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}

	public static class CM0006Img {
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
