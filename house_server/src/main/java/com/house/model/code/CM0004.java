package com.house.model.code;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class CM0004 implements Serializable {
	private String usrId;
	private String usrPw;
	private String resultYn;

	@JsonIgnore
	public String getUsrId() {
		return this.usrId;
	}

	@JsonIgnore
	public String getUsrPw() {
		return this.usrPw;
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

	@JsonIgnore
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}
