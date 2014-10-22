package com.house.model;

import com.house.util.DateUtils;
import java.sql.Timestamp;

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
		return this.talkNo;
	}

	public void setTalkNo(long talkNo) {
		this.talkNo = talkNo;
	}

	public long getUsrNo() {
		return this.usrNo;
	}

	public void setUsrNo(long usrNo) {
		this.usrNo = usrNo;
	}

	public int getCateCd() {
		return this.cateCd;
	}

	public void setCateCd(int cateCd) {
		this.cateCd = cateCd;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public byte[] getContents() {
		return this.contents;
	}

	public void setContents(byte[] contents) {
		this.contents = contents;
	}

	public String getTagNm() {
		return this.tagNm;
	}

	public void setTagNm(String tagNm) {
		this.tagNm = tagNm;
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
}
