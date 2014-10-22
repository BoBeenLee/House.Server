package com.house.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class Test implements Serializable {
	private String tranCd;
	private String errorCd;

	@JsonProperty("_tran_cd")
	public void setTranCd(String tranCd) {
		this.tranCd = tranCd;
	}

	@JsonIgnore
	public void setErrorCd(String errorCd) {
		this.errorCd = errorCd;
	}

	@JsonProperty("_tran_cd")
	public String getTranCd() {
		return this.tranCd;
	}

	@JsonProperty("_error_cd")
	public String getErrorCd() {
		return this.errorCd;
	}
}
