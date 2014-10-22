package com.house.model.reqcode;

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

	@JsonIgnore
	public String getCustName() {
		return this.custName;
	}

	@JsonIgnore
	public int getUsrSts() {
		return this.usrSts;
	}

	@JsonIgnore
	public String getProfileImg() {
		return this.profileImg;
	}

	@JsonProperty("_usr_id")
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	@JsonProperty("_custname")
	public void setCustName(String custName) {
		this.custName = custName;
	}

	@JsonProperty("_sts")
	public void setUsrSts(int usrSts) {
		this.usrSts = usrSts;
	}

	@JsonProperty("_profile_img")
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
}
