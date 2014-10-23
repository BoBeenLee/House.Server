package com.house.model.code;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CM0007 {
	private String usrId;
	private String pushAppId;
	private String pushTokenId;
	private String pushYn;
	
	private String resultYn;

	@JsonIgnore
	public String getUsrId() {
		return usrId;
	}
	@JsonIgnore
	public String getPushAppId() {
		return pushAppId;
	}
	@JsonIgnore
	public String getPushTokenId() {
		return pushTokenId;
	}
	@JsonIgnore
	public String getPushYn() {
		return pushYn;
	}
	@JsonProperty("_rslt_yn")
	public String getResultYn() {
		return resultYn;
	}
	
	@JsonProperty("_usr_id")
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	@JsonProperty("_push_app_id")
	public void setPushAppId(String pushAppId) {
		this.pushAppId = pushAppId;
	}
	@JsonProperty("_push_token_id")
	public void setPushTokenId(String pushTokenId) {
		this.pushTokenId = pushTokenId;
	}
	@JsonProperty("_push_yn")
	public void setPushYn(String pushYn) {
		this.pushYn = pushYn;
	}
	@JsonIgnore
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}
