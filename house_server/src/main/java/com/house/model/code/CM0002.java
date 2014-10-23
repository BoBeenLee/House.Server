package com.house.model.code;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CM0002 implements Serializable {
	private String token;
	
	private String resultYn;
	
	@JsonIgnore
	public String getToken() {
		return token;
	}
	@JsonProperty("_rslt_yn")
	public String getResultYn() {
		return resultYn;
	}
	@JsonProperty("_token")
	public void setToken(String token) {
		this.token = token;
	}
	@JsonIgnore
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}