package com.house.model.reqcode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CM0007 {
	private String usrId;
	private String pushAppId;
	private String pushTokenId;
	private String pushYn;
	private String resultYn;

	@JsonProperty("_usr_id")
	public String getUsrId() {
		return this.usrId;
	}

	@JsonProperty("_push_app_id")
	public String getPushAppId() {
		return this.pushAppId;
	}

	@JsonProperty("_push_token_id")
	public String getPushTokenId() {
		return this.pushTokenId;
	}

	@JsonProperty("_push_yn")
	public String getPushYn() {
		return this.pushYn;
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
	public void setPushAppId(String pushAppId) {
		this.pushAppId = pushAppId;
	}

	@JsonIgnore
	public void setPushTokenId(String pushTokenId) {
		this.pushTokenId = pushTokenId;
	}

	@JsonIgnore
	public void setPushYn(String pushYn) {
		this.pushYn = pushYn;
	}

	@JsonProperty("_push_yn")
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}
