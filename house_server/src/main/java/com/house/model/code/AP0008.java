package com.house.model.code;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AP0008 {
	private int type;
	private long reqPoNo;
	private long commentNo;
	private String commentId;
	private byte[] commentContents;
	
	private String resultYn;

	@JsonIgnore
	public int getType() {
		return type;
	}
	@JsonIgnore
	public long getReqPoNo() {
		return reqPoNo;
	}
	@JsonIgnore
	public long getCommentNo() {
		return commentNo;
	}
	@JsonIgnore
	public String getCommentId() {
		return commentId;
	}
	@JsonIgnore
	public byte[] getCommentContents() {
		return commentContents;
	}
	@JsonProperty("_rslt_yn")
	public String getResultYn() {
		return resultYn;
	}
	
	@JsonProperty("_type")
	public void setType(int type) {
		this.type = type;
	}
	@JsonProperty("_req_po_no")
	public void setReqPoNo(long reqPoNo) {
		this.reqPoNo = reqPoNo;
	}
	@JsonProperty("_comment_no")
	public void setCommentNo(long commentNo) {
		this.commentNo = commentNo;
	}
	@JsonProperty("_comment_id")
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	@JsonProperty("_comment_contents")
	public void setCommentContents(byte[] commentContents) {
		this.commentContents = commentContents;
	}
	@JsonIgnore
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}
