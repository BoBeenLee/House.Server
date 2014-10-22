package com.house.model.code;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AP0009 {
	private int type;
	private String commentId;
	private long commentNo;
	private String resultYn;

	@JsonIgnore
	public int getType() {
		return this.type;
	}

	@JsonIgnore
	public String getCommentId() {
		return this.commentId;
	}

	@JsonIgnore
	public long getCommentNo() {
		return this.commentNo;
	}

	@JsonProperty("_type")
	public String getResultYn() {
		return this.resultYn;
	}

	@JsonProperty("_type")
	public void setType(int type) {
		this.type = type;
	}

	@JsonProperty("_comment_id")
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	@JsonProperty("_comment_no")
	public void setCommentNo(long commentNo) {
		this.commentNo = commentNo;
	}

	@JsonIgnore
	public void setResultYn(String resultYn) {
		this.resultYn = resultYn;
	}
}
