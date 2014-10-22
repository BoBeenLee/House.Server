package com.house.model.code;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

public class AP0003 implements Serializable {
	private int type;
	private long reqPoNo;
	private long reqCommentNo;
	private int reqCommentCnt;
	private String usrId;
	private long brdNo;
	private String brdNm;
	private String brdId;
	private String brdProfileImg;
	private String brdSubject;
	private byte[] brdContents;
	private String brdTag;
	private String brdModified;
	private String brdCreated;
	private String brdCateNm;
	private int brdCate;
	private int brdLikeState;
	private int brdScrapState;
	private int brdLikeCnt;
	private int brdScrapCnt;
	private List<String> brdImg;
	private int brdCommentCnt;
	private long brdCommentLastNo;
	private List<AP0003Comment> brdComment;

	@JsonIgnore
	public long getReqCommentNo() {
		return this.reqCommentNo;
	}

	@JsonIgnore
	public int getReqCommentCnt() {
		return this.reqCommentCnt;
	}

	@JsonProperty("_brd_comment_last_no")
	public long getBrdCommentLastNo() {
		return this.brdCommentLastNo;
	}

	@JsonIgnore
	public int getType() {
		return this.type;
	}

	@JsonIgnore
	public long getReqPoNo() {
		return this.reqPoNo;
	}

	@JsonProperty("_brd_no")
	public long getBrdNo() {
		return this.brdNo;
	}

	@JsonProperty("_brd_nm")
	public String getBrdNm() {
		return this.brdNm;
	}

	@JsonProperty("_brd_id")
	public String getBrdId() {
		return this.brdId;
	}

	@JsonProperty("_brd_profile_img")
	public String getBrdProfileImg() {
		return this.brdProfileImg;
	}

	@JsonProperty("_brd_subject")
	public String getBrdSubject() {
		return this.brdSubject;
	}

	@JsonProperty("_brd_contents")
	public byte[] getBrdContents() {
		return this.brdContents;
	}

	@JsonProperty("_brd_tag")
	public String getBrdTag() {
		return this.brdTag;
	}

	@JsonProperty("_brd_cate_nm")
	public String getBrdCateNm() {
		return this.brdCateNm;
	}

	@JsonProperty("_brd_cate")
	public int getBrdCate() {
		return this.brdCate;
	}

	@JsonProperty("_brd_created")
	public String getBrdCreated() {
		return this.brdCreated;
	}

	@JsonProperty("_brd_like_cnt")
	public int getBrdLikeCnt() {
		return this.brdLikeCnt;
	}

	@JsonProperty("_brd_img")
	public List<String> getBrdImg() {
		return this.brdImg;
	}

	@JsonProperty("_brd_scrap_cnt")
	public int getBrdScrapCnt() {
		return this.brdScrapCnt;
	}

	@JsonProperty("_brd_comment_cnt")
	public int getBrdCommentCnt() {
		return this.brdCommentCnt;
	}

	@JsonProperty("_brd_comment")
	public List<AP0003Comment> getBrdComment() {
		return this.brdComment;
	}

	@JsonIgnore
	public String getUsrId() {
		return this.usrId;
	}

	@JsonProperty("_brd_like_state")
	public int getBrdLikeState() {
		return this.brdLikeState;
	}

	@JsonProperty("_brd_scrap_state")
	public int getBrdScrapState() {
		return this.brdScrapState;
	}

	@JsonProperty("_brd_modified")
	public String getBrdModified() {
		return this.brdModified;
	}

	@JsonProperty("_req_comment_no")
	public void setReqCommentNo(long reqCommentNo) {
		this.reqCommentNo = reqCommentNo;
	}

	@JsonProperty("_req_comment_cnt")
	public void setReqCommentCnt(int reqCommentCnt) {
		this.reqCommentCnt = reqCommentCnt;
	}

	@JsonIgnore
	public void setBrdCommentLastNo(long brdCommentLastNo) {
		this.brdCommentLastNo = brdCommentLastNo;
	}

	@JsonProperty("_type")
	public void setType(int type) {
		this.type = type;
	}

	@JsonProperty("_req_po_no")
	public void setReqPoNo(long reqPoNo) {
		this.reqPoNo = reqPoNo;
	}

	@JsonIgnore
	public void setBrdNo(long brdNo) {
		this.brdNo = brdNo;
	}

	@JsonIgnore
	public void setBrdNm(String brdNm) {
		this.brdNm = brdNm;
	}

	@JsonIgnore
	public void setBrdId(String brdId) {
		this.brdId = brdId;
	}

	@JsonIgnore
	public void setBrdProfileImg(String brdProfileImg) {
		this.brdProfileImg = brdProfileImg;
	}

	@JsonIgnore
	public void setBrdSubject(String brdSubject) {
		this.brdSubject = brdSubject;
	}

	@JsonIgnore
	public void setBrdContents(byte[] brdContents) {
		this.brdContents = brdContents;
	}

	@JsonIgnore
	public void setBrdTag(String brdTag) {
		this.brdTag = brdTag;
	}

	@JsonIgnore
	public void setBrdCateNm(String brdCateNm) {
		this.brdCateNm = brdCateNm;
	}

	@JsonIgnore
	public void setBrdCate(int brdCate) {
		this.brdCate = brdCate;
	}

	@JsonIgnore
	public void setBrdCreated(String brdCreated) {
		this.brdCreated = brdCreated;
	}

	@JsonIgnore
	public void setBrdLikeCnt(int brdLikeCnt) {
		this.brdLikeCnt = brdLikeCnt;
	}

	@JsonIgnore
	public void setBrdImg(List<String> brdImg) {
		this.brdImg = brdImg;
	}

	@JsonIgnore
	public void setBrdScrapCnt(int brdScrapCnt) {
		this.brdScrapCnt = brdScrapCnt;
	}

	@JsonIgnore
	public void setBrdCommentCnt(int brdCommentCnt) {
		this.brdCommentCnt = brdCommentCnt;
	}

	@JsonIgnore
	public void setBrdComment(List<AP0003Comment> brdComment) {
		this.brdComment = brdComment;
	}

	@JsonProperty("_usr_id")
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	@JsonIgnore
	public void setBrdLikeState(int brdLikeState) {
		this.brdLikeState = brdLikeState;
	}

	@JsonIgnore
	public void setBrdScrapState(int brdScrapState) {
		this.brdScrapState = brdScrapState;
	}

	@JsonIgnore
	public void setBrdModified(String brdModified) {
		this.brdModified = brdModified;
	}

	public static class AP0003Comment {
		@JsonProperty("_brd_comment_no")
		public long brdCommentNo;
		@JsonProperty("_brd_comment_created")
		public String brdCommentCreated;
		@JsonProperty("_brd_comment_nm")
		public String brdCommentNm;
		@JsonProperty("brd_comment_id")
		public String brdCommentId;
		@JsonProperty("_brd_comment_profile_img")
		public String brdCommentProfileImg;
		@JsonProperty("_brd_comment_contents")
		public byte[] brdCommentContents;
	}
}