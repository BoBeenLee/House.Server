package com.house.model.reqcode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class CM0001 implements Serializable {
	private String usrId;
	private String usrPw;
	private String custName;
	private String token;
	private String profileImg;

	@JsonProperty("_usr_id")
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	@JsonIgnore
	public void setUsrPw(String usrPw) {
		this.usrPw = usrPw;
	}

	@JsonProperty("_custname")
	public void setCustName(String custName) {
		this.custName = custName;
	}

	@JsonProperty("_token")
	public void setToken(String token) {
		this.token = token;
	}

	@JsonProperty("_profile_img")
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	@JsonIgnore
	public String getProfileImg() {
		return this.profileImg;
	}

	@JsonProperty("_usr_id")
	public String getUsrId() {
		return this.usrId;
	}

	@JsonProperty("_usr_pw")
	public String getUsrPw() {
		return this.usrPw;
	}

	@JsonIgnore
	public String getCustName() {
		return this.custName;
	}

	@JsonIgnore
	public String getToken() {
		return this.token;
	}
}
