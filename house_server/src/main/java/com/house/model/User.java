package com.house.model;

import java.sql.Timestamp;
import java.text.ParseException;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.house.util.DateUtils;

public class User {
//	@JsonIgnore
//	@JsonProperty("_usr_id")
	private long usrNo;
	private int usrSts;
	private String usrNm;
	private String usrId;
	private String usrPw;
	private String usrSs;
	private String termsYN;
	private String psPlatform;
	private String psId;
	private String psRevokeYN;
	private String psAppVer;
	private String deviceNM;
	private String modified;
	private String created;
	
	private String token;
	
	public long getUsrNo() {
		return usrNo;
	}
	public void setUsrNo(long usrNo) {
		this.usrNo = usrNo;
	}
	public int getUsrSts() {
		return usrSts;
	}
	public void setUsrSts(int usrSts) {
		this.usrSts = usrSts;
	}
	public String getUsrNm() {
		return usrNm;
	}
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getUsrPw() {
		return usrPw;
	}
	public void setUsrPw(String usrPw) {
		this.usrPw = usrPw;
	}
	public String getUsrSs() {
		return usrSs;
	}
	public void setUsrSs(String usrSs) {
		this.usrSs = usrSs;
	}
	public String getTermsYN() {
		return termsYN;
	}
	public void setTermsYN(String termsYN) {
		this.termsYN = termsYN;
	}
	public String getPsPlatform() {
		return psPlatform;
	}
	public void setPsPlatform(String psPlatform) {
		this.psPlatform = psPlatform;
	}
	public String getPsId() {
		return psId;
	}
	public void setPsId(String psId) {
		this.psId = psId;
	}
	public String getPsRevokeYN() {
		return psRevokeYN;
	}
	public void setPsRevokeYN(String psRevokeYN) {
		this.psRevokeYN = psRevokeYN;
	}
	public String getPsAppVer() {
		return psAppVer;
	}
	public void setPsAppVer(String psAppVer) {
		this.psAppVer = psAppVer;
	}
	public String getDeviceNM() {
		return deviceNM;
	}
	public void setDeviceNM(String deviceNM) {
		this.deviceNM = deviceNM;
	}
	// yyyy-MM-dd HH:mm:ss
	public void setModifiedByDate(Timestamp timestamp) {
		this.modified = DateUtils.dateToString(timestamp);
	}
	// yyyy-MM-dd HH:mm:ss
	public void setCreatedByDate(Timestamp timestamp) {
		this.created = DateUtils.dateToString(timestamp);
	}
	public String getModified() {
		return modified;
	}
	public String getCreated() {
		return created;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
