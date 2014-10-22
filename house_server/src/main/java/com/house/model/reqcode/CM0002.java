package com.house.model.reqcode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class CM0002 implements Serializable {
	private String token;
	private String resultYn;

	@JsonProperty("_token")
	public String getToken() {
		return this.token;
	}

	@JsonIgnore
	public String getResultYn() {
		return this.resultYn;
	}

	@JsonIgnore
	public void setToken(String token) {
		this.token = token;
	}

	@JsonProperty("_rslt_yn")
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}
