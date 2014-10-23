package com.house.model;

import java.sql.Timestamp;
import java.text.ParseException;

import com.house.util.DateUtils;

public class Interior {
	private long interiorNo;
	private long usrNo;
	private String subject;
	private byte[] contents;
	private int cateCd;
	private String tagNm;
	private String modified;
	private String created;
	
	public long getInteriorNo() {
		return interiorNo;
	}
	public void setInteriorNo(long interiorNo) {
		this.interiorNo = interiorNo;
	}
	public long getUsrNo() {
		return usrNo;
	}
	public void setUsrNo(long usrNo) {
		this.usrNo = usrNo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public byte[] getContents() {
		return contents;
	}
	public void setContents(byte[] contents) {
		this.contents = contents;
	}
	public int getCateCd() {
		return cateCd;
	}
	public void setCateCd(int cateCd) {
		this.cateCd = cateCd;
	}
	public String getTagNm() {
		return tagNm;
	}
	public void setTagNm(String tagNm) {
		this.tagNm = tagNm;
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
}
