package com.house.model;

import java.sql.Timestamp;
import java.text.ParseException;

import com.house.util.DateUtils;

public class Attach {
	private long attachNo;
	private int srcType;
	private long srcNo;
	private int srcSeq;
	private String name;
	private String inUrl;
	private String inThumUrl;
	private String exUrl;
	private String exThumUrl;
	private long uploadUsr;
	private String modified;
	private String created;
	private TransferMultipartFile transferMultipartFile;
	
	public long getAttachNo() {
		return attachNo;
	}
	public void setAttachNo(long attachNo) {
		this.attachNo = attachNo;
	}
	public int getSrcType() {
		return srcType;
	}
	public void setSrcType(int srcType) {
		if(SrcType.PROFILE_TYPE == srcType)
			this.srcType = SrcType.PROFILE_TYPE;
		else if(SrcType.INTERIOR_TYPE == srcType)
			this.srcType = SrcType.INTERIOR_TYPE;
		else if(SrcType.SUDATALK_TYPE == srcType)
			this.srcType = SrcType.SUDATALK_TYPE;
	}
	public long getSrcNo() {
		return srcNo;
	}
	public void setSrcNo(long srcNo) {
		this.srcNo = srcNo;
	}
	public int getSrcSeq() {
		return srcSeq;
	}
	public void setSrcSeq(int srcSeq) {
		this.srcSeq = srcSeq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInUrl() {
		return inUrl;
	}
	public void setInUrl(String inUrl) {
		this.inUrl = inUrl;
	}
	public String getExUrl() {
		return exUrl;
	}
	public void setExUrl(String exUrl) {
		this.exUrl = exUrl;
	}
	public long getUploadUsr() {
		return uploadUsr;
	}
	public void setUploadUsr(long uploadUsr) {
		this.uploadUsr = uploadUsr;
	}
	public TransferMultipartFile getTransferMultipartFile() {
		return transferMultipartFile;
	}
	public void setTransferMultipartFile(TransferMultipartFile transferMultipartFile) {
		this.transferMultipartFile = transferMultipartFile;
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
	public String getInThumUrl() {
		return inThumUrl;
	}
	public String getExThumUrl() {
		return exThumUrl;
	}
	public void setInThumUrl(String inThumUrl) {
		this.inThumUrl = inThumUrl;
	}
	public void setExThumUrl(String exThumUrl) {
		this.exThumUrl = exThumUrl;
	}
}
