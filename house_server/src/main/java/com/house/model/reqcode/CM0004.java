package com.house.model.reqcode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class CM0004 implements Serializable {
	private String usrId;
	private String usrPw;
	private String resultYn;

	@JsonProperty("_usr_id")
	public String getUsrId() {
		return this.usrId;
	}

	@JsonProperty("_usr_pw")
	public String getUsrPw() {
		return this.usrPw;
	}

	@JsonIgnore
	public String getResultYn() {
		return this.resultYn;
	}

	@JsonIgnore
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	@JsonIgnore
	public void setUsrPw(String usrPw) {
		this.usrPw = usrPw;
	}

	@JsonProperty("_rslt_yn")
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}
