package com.house.model;

import com.house.util.DateUtils;
import java.sql.Timestamp;

public class Attach {
	private long attachNo;
	private int srcType;
	private long srcNo;
	private int srcSeq;
	private int cateNo;
	private String name;
	private String inUrl;
	private String inThumUrl;
	private String exUrl;
	private String exThumUrl;
	private long uploadUsr;
	private String modified;
	private String created;
	private TransferMultipartFile transferMultipartFile;

	public int getCateNo() {
		return this.cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public long getAttachNo() {
		return this.attachNo;
	}

	public void setAttachNo(long attachNo) {
		this.attachNo = attachNo;
	}

	public int getSrcType() {
		return this.srcType;
	}

	public void setSrcType(int srcType) {
		if (1 == srcType) {
			this.srcType = 1;
		} else if (2 == srcType) {
			this.srcType = 2;
		} else if (3 == srcType) {
			this.srcType = 3;
		}
	}

	public long getSrcNo() {
		return this.srcNo;
	}

	public void setSrcNo(long srcNo) {
		this.srcNo = srcNo;
	}

	public int getSrcSeq() {
		return this.srcSeq;
	}

	public void setSrcSeq(int srcSeq) {
		this.srcSeq = srcSeq;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInUrl() {
		return this.inUrl;
	}

	public void setInUrl(String inUrl) {
		this.inUrl = inUrl;
	}

	public String getExUrl() {
		return this.exUrl;
	}

	public void setExUrl(String exUrl) {
		this.exUrl = exUrl;
	}

	public long getUploadUsr() {
		return this.uploadUsr;
	}

	public void setUploadUsr(long uploadUsr) {
		this.uploadUsr = uploadUsr;
	}

	public TransferMultipartFile getTransferMultipartFile() {
		return this.transferMultipartFile;
	}

	public void setTransferMultipartFile(
			TransferMultipartFile transferMultipartFile) {
		this.transferMultipartFile = transferMultipartFile;
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

	public String getInThumUrl() {
		return this.inThumUrl;
	}

	public String getExThumUrl() {
		return this.exThumUrl;
	}

	public void setInThumUrl(String inThumUrl) {
		this.inThumUrl = inThumUrl;
	}

	public void setExThumUrl(String exThumUrl) {
		this.exThumUrl = exThumUrl;
	}
}
