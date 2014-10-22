package com.house.model;

import com.house.util.DateUtils;
import java.sql.Timestamp;

public class User {
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
		return this.usrNo;
	}

	public void setUsrNo(long usrNo) {
		this.usrNo = usrNo;
	}

	public int getUsrSts() {
		return this.usrSts;
	}

	public void setUsrSts(int usrSts) {
		this.usrSts = usrSts;
	}

	public String getUsrNm() {
		return this.usrNm;
	}

	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}

	public String getUsrId() {
		return this.usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getUsrPw() {
		return this.usrPw;
	}

	public void setUsrPw(String usrPw) {
		this.usrPw = usrPw;
	}

	public String getUsrSs() {
		return this.usrSs;
	}

	public void setUsrSs(String usrSs) {
		this.usrSs = usrSs;
	}

	public String getTermsYN() {
		return this.termsYN;
	}

	public void setTermsYN(String termsYN) {
		this.termsYN = termsYN;
	}

	public String getPsPlatform() {
		return this.psPlatform;
	}

	public void setPsPlatform(String psPlatform) {
		this.psPlatform = psPlatform;
	}

	public String getPsId() {
		return this.psId;
	}

	public void setPsId(String psId) {
		this.psId = psId;
	}

	public String getPsRevokeYN() {
		return this.psRevokeYN;
	}

	public void setPsRevokeYN(String psRevokeYN) {
		this.psRevokeYN = psRevokeYN;
	}

	public String getPsAppVer() {
		return this.psAppVer;
	}

	public void setPsAppVer(String psAppVer) {
		this.psAppVer = psAppVer;
	}

	public String getDeviceNM() {
		return this.deviceNM;
	}

	public void setDeviceNM(String deviceNM) {
		this.deviceNM = deviceNM;
	}

	public void setModifiedByDate(Timestamp timestamp) {
		this.modified = DateUtils.dateToString(timestamp, DateUtils.dateForm1);
	}

	public void setCreatedByDate(Timestamp timestamp) {
		this.created = DateUtils.dateToString(timestamp, DateUtils.dateForm1);
	}

	public String getModified() {
		return this.modified;
	}

	public String getCreated() {
		return this.created;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
