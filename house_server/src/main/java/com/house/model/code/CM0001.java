package com.house.model.code;

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

	@JsonProperty("_usr_pw")
	public void setUsrPw(String usrPw) {
		this.usrPw = usrPw;
	}

	@JsonIgnore
	public void setCustName(String custName) {
		this.custName = custName;
	}

	@JsonIgnore
	public void setToken(String token) {
		this.token = token;
	}

	@JsonIgnore
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	@JsonProperty("_usr_id")
	public String getUsrId() {
		return this.usrId;
	}

	@JsonIgnore
	public String getUsrPw() {
		return this.usrPw;
	}

	@JsonProperty("_custname")
	public String getCustName() {
		return this.custName;
	}

	@JsonProperty("_token")
	public String getToken() {
		return this.token;
	}

	@JsonProperty("_profile_img")
	public String getProfileImg() {
		return this.profileImg;
	}
}
