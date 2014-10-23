package com.house.model;

import java.sql.Timestamp;
import java.text.ParseException;

import com.house.util.DateUtils;

public class Sudatalk {
	private long talkNo;
	private long usrNo;
	private int cateCd;
	private String subject;
	private byte[] contents;
	private String tagNm;
	private String modified;
	private String created;
	
	public long getTalkNo() {
		return talkNo;
	}
	public void setTalkNo(long talkNo) {
		this.talkNo = talkNo;
	}
	public long getUsrNo() {
		return usrNo;
	}
	public void setUsrNo(long usrNo) {
		this.usrNo = usrNo;
	}
	public int getCateCd() {
		return cateCd;
	}
	public void setCateCd(int cateCd) {
		this.cateCd = cateCd;
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
