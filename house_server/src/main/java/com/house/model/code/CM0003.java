package com.house.model.code;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CM0003 {
	private String usrId;
	private String usrPw;
	private String custName;
	private String termsYN;
	private String psPlatform;
	private String psId;
	private String psRevokeYN;
	private String psAppVer;
	private String deviceNM;
	private int usrSts;
	private CM0003Img usrImg;
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
	public String getTermsYN() {
		return this.termsYN;
	}

	@JsonIgnore
	public String getPsPlatform() {
		return this.psPlatform;
	}

	@JsonIgnore
	public String getPsId() {
		return this.psId;
	}

	@JsonIgnore
	public String getPsRevokeYN() {
		return this.psRevokeYN;
	}

	@JsonIgnore
	public String getPsAppVer() {
		return this.psAppVer;
	}

	@JsonIgnore
	public String getDeviceNM() {
		return this.deviceNM;
	}

	@JsonIgnore
	public int getUsrSts() {
		return this.usrSts;
	}

	@JsonIgnore
	public CM0003Img getUsrImg() {
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

	@JsonProperty("_term_yn")
	public void setTermsYN(String termsYN) {
		this.termsYN = termsYN;
	}

	@JsonProperty("_ps_platform")
	public void setPsPlatform(String psPlatform) {
		this.psPlatform = psPlatform;
	}

	@JsonProperty("_ps_id")
	public void setPsId(String psId) {
		this.psId = psId;
	}

	@JsonProperty("_ps_revoke_yn")
	public void setPsRevokeYN(String psRevokeYN) {
		this.psRevokeYN = psRevokeYN;
	}

	@JsonProperty("_ps_app_ver")
	public void setPsAppVer(String psAppVer) {
		this.psAppVer = psAppVer;
	}

	@JsonProperty("_devie_nm")
	public void setDeviceNM(String deviceNM) {
		this.deviceNM = deviceNM;
	}

	@JsonProperty("_sts")
	public void setUsrSts(int usrSts) {
		this.usrSts = usrSts;
	}

	@JsonIgnore
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}

	@JsonProperty("_usr_img")
	public void setUsrImg(CM0003Img usrImg) {
		this.usrImg = usrImg;
	}

	public static class CM0003Img {
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
