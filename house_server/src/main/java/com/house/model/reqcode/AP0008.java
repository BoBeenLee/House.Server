package com.house.model.reqcode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AP0008 {
	private int type;
	private long reqPoNo;
	private long commentNo;
	private String commentId;
	private byte[] commentContents;
	private String resultYn;

	@JsonProperty("_type")
	public int getType() {
		return this.type;
	}

	@JsonProperty("_req_po_no")
	public long getReqPoNo() {
		return this.reqPoNo;
	}

	@JsonProperty("_comment_no")
	public long getCommentNo() {
		return this.commentNo;
	}

	@JsonProperty("_comment_id")
	public String getCommentId() {
		return this.commentId;
	}

	@JsonProperty("_comment_contents")
	public byte[] getCommentContents() {
		return this.commentContents;
	}

	@JsonIgnore
	public String getResultYn() {
		return this.resultYn;
	}

	@JsonIgnore
	public void setType(int type) {
		this.type = type;
	}

	@JsonIgnore
	public void setReqPoNo(long reqPoNo) {
		this.reqPoNo = reqPoNo;
	}

	@JsonIgnore
	public void setCommentNo(long commentNo) {
		this.commentNo = commentNo;
	}

	@JsonIgnore
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	@JsonIgnore
	public void setCommentContents(byte[] commentContents) {
		this.commentContents = commentContents;
	}

	@JsonProperty("_rslt_yn")
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}
