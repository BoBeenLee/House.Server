package com.house.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Test implements Serializable {
	private String tranCd;
	private String errorCd;
//	private String errorMsg;
//	/*
//			ʺ1000ʺ;  페이지 유지         
//			ʺ1001ʺ;  거래 첫화면으로 분기      
//			ʺ1002ʺ;  홈으로 분기(자동으로 로그아웃 됨) 
//			ʺ9999ʺ;  프로그램 종료 
//	 */
//	private int errorAction;
	
	@JsonProperty("_tran_cd")
	public void setTranCd(String tranCd) {
		this.tranCd = tranCd;
	}
	@JsonIgnore
	public void setErrorCd(String errorCd) {
		this.errorCd = errorCd;
	}
//	public void setErrorMsg(String errorMsg) {
//		this.errorMsg = errorMsg;
//	}
//	public void setErrorAction(int errorAction) {
//		this.errorAction = errorAction;
//	}
	@JsonProperty("_tran_cd")
	public String getTranCd() {
		return tranCd;
	}
	@JsonProperty("_error_cd")
	public String getErrorCd() {
		return errorCd;
	}
//	@JsonProperty("_error_msg")
//	public String getErrorMsg() {
//		return errorMsg;
//	}
//	@JsonProperty("_error_action")
//	public int getErrorAction() {
//		return errorAction;
//	}
}
