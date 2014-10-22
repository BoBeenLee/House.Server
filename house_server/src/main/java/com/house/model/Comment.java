package com.house.model;

import com.house.util.DateUtils;
import java.sql.Timestamp;

public class Comment {
	private long commentNo;
	private long usrNo;
	private String usrId;
	private String usrNm;
	private String profileImg;
	private long srcNo;
	private int depth;
	private byte[] contents;
	private String modified;
	private String created;

	public long getCommentNo() {
		return this.commentNo;
	}

	public void setCommentNo(long commentNo) {
		this.commentNo = commentNo;
	}

	public long getUsrNo() {
		return this.usrNo;
	}

	public void setUsrNo(long usrNo) {
		this.usrNo = usrNo;
	}

	public String getUsrId() {
		return this.usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getUsrNm() {
		return this.usrNm;
	}

	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}

	public String getProfileImg() {
		return this.profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public long getSrcNo() {
		return this.srcNo;
	}

	public void setSrcNo(long srcNo) {
		this.srcNo = srcNo;
	}

	public int getDepth() {
		return this.depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public byte[] getContents() {
		return this.contents;
	}

	public void setContents(byte[] contents) {
		this.contents = contents;
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
