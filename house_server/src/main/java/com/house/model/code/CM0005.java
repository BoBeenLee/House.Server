package com.house.model.code;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CM0005 {
	private String usrId;
	private String usrPw;
	private String custName;
	private int usrSts;
	private String profileImg;
	
	@JsonProperty("_usr_id")
	public String getUsrId() {
		return usrId;
	}
	@JsonIgnore
	public String getUsrPw() {
		return usrPw;
	}
	@JsonProperty("_custname")
	public String getCustName() {
		return custName;
	}
	@JsonProperty("_sts")
	public int getUsrSts() {
		return usrSts;
	}
	@JsonProperty("_profile_img")
	public String getProfileImg() {
		return profileImg;
	}
	
	@JsonProperty("_usr_id")
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	@JsonProperty("_usr_pw")
	public void setUsrPw(String usrPw) {
		this.usrPw = usrPw;
	}
	@JsonIgnore
	public void setCustName(String custName) {
		this.custName = custName;
	}
	@JsonIgnore
	public void setUsrSts(int usrSts) {
		this.usrSts = usrSts;
	}
	@JsonIgnore
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
}
