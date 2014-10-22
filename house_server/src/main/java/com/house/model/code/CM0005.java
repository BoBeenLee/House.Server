package com.house.model.code;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CM0005 {
	private String usrId;
	private String custName;
	private int usrSts;
	private String profileImg;

	@JsonProperty("_usr_id")
	public String getUsrId() {
		return this.usrId;
	}

	@JsonProperty("_custname")
	public String getCustName() {
		return this.custName;
	}

	@JsonProperty("_sts")
	public int getUsrSts() {
		return this.usrSts;
	}

	@JsonProperty("_profile_img")
	public String getProfileImg() {
		return this.profileImg;
	}

	@JsonProperty("_usr_id")
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
