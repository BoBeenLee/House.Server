package com.house.model;

import java.sql.Timestamp;
import java.text.ParseException;

import com.house.util.DateUtils;

public class SudatalkCategory {
	private int cateNo;
	private int depth;
	private String cateNm;
	private String modified;
	private String created;
	
	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getCateNm() {
		return cateNm;
	}
	public void setCateNm(String cateNm) {
		this.cateNm = cateNm;
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
	
	public static enum CATEGORY_TYPE {
		QNA(1), REVIEW(2), NORMAL(3);
		public int value;
		
		private CATEGORY_TYPE(int value){
			this.value = value;
		}
	}
}
