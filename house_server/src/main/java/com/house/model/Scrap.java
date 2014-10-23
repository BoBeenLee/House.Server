package com.house.model;

import java.sql.Timestamp;
import java.text.ParseException;

import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.house.util.DateUtils;

public class Scrap {
	private long scrapNo;
	private long usrNo;
	private int srcType;
	private long srcNo;
	private String created;
	
	public long getScrapNo() {
		return scrapNo;
	}
	public void setScrapNo(long scrapNo) {
		this.scrapNo = scrapNo;
	}
	public long getUsrNo() {
		return usrNo;
	}
	public void setUsrNo(long usrNo) {
		this.usrNo = usrNo;
	}
	public int getSrcType() {
		return srcType;
	}
	public void setSrcType(int srcType) {
		this.srcType = srcType;
	}
	public long getSrcNo() {
		return srcNo;
	}
	public void setSrcNo(long srcNo) {
		this.srcNo = srcNo;
	}
	// yyyy-MM-dd HH:mm:ss
	public void setCreatedByDate(Timestamp timestamp) {
		this.created = DateUtils.dateToString(timestamp);
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
}
