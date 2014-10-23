package com.house.model.code;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.house.model.User;

public class CM0001 implements Serializable {
	private String usrId;
	private String usrPw;
	private String regNo;
	private String custName;
	private String firstLogin;
	private String token;
	
	@JsonProperty("_usr_id")
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	@JsonProperty("_usr_pw")
	public void setUsrPw(String usrPw) {
		this.usrPw = usrPw;
	}
	@JsonIgnore
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	@JsonIgnore
	public void setCustName(String custName) {
		this.custName = custName;
	}
	@JsonIgnore
	public void setFirstLogin(String firstLogin) {
		this.firstLogin = firstLogin;
	}
	@JsonIgnore
	public void setToken(String token) {
		this.token = token;
	}

	@JsonProperty("_usr_id")
	public String getUsrId() {
		return usrId;
	}
	@JsonIgnore
	public String getUsrPw() {
		return usrPw;
	}
	@JsonProperty("_regno")
	public String getRegNo() {
		return regNo;
	}
	@JsonProperty("_custname")
	public String getCustName() {
		return custName;
	}
	@JsonProperty("_firstlogin")
	public String getFirstLogin() {
		return firstLogin;
	}
	@JsonProperty("_token")
	public String getToken() {
		return token;
	}
	
	public User newInstance() {
		User user = new User();
		user.setUsrId(usrId);
		user.setUsrPw(usrPw);
		/*
		 * 	public String regNo;
			public String custName;
			public String firstLogin;
		 */
		return user;
	}
}