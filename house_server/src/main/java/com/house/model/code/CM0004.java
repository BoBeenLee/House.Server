package com.house.model.code;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CM0004 implements Serializable {
	private String usrId;
	private String usrPw;
	
	private String resultYn;
	
	@JsonIgnore
	public String getUsrId() {
		return usrId;
	}
	@JsonIgnore
	public String getUsrPw() {
		return usrPw;
	}
	@JsonProperty("_rslt_yn")
	public String getResultYn() {
		return resultYn;
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
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}