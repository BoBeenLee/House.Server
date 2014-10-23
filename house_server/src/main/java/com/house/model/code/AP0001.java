package com.house.model.code;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.house.model.reqcode.AP0001.AP0001Img;

public class AP0001 implements Serializable {
	private int type;
	private String orderType;
	private int reqPo;
	private int reqPoCnt;
	private long reqPoNo;
	
	private int resCnt;
	private List<AP0001Res> res;
	private String resDate;
	private long resLastNo;
	
	@JsonIgnore
	public int getType() {
		return type;
	}
	@JsonIgnore
	public String getOrderType() {
		return orderType;
	}
	@JsonIgnore
	public int getReqPo() {
		return reqPo;
	}
	@JsonIgnore
	public int getReqPoCnt() {
		return reqPoCnt;
	}
	@JsonIgnore
	public long getReqPoNo() {
		return reqPoNo;
	}
	@JsonProperty("_res_cnt")
	public int getResCnt() {
		return resCnt;
	}
	@JsonProperty("_res")
	public List<AP0001Res> getRes() {
		return res;
	}
	@JsonProperty("_res_date")
	public String getResDate() {
		return resDate;
	}
	@JsonProperty("_res_last_no")
	public long getResLastNo() {
		return resLastNo;
	}
	
	@JsonProperty("_type")
	public void setType(int type) {
		this.type = type;
	}
	@JsonProperty("_order_type")
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	@JsonProperty("_req_po")
	public void setReqPo(int reqPo) {
		this.reqPo = reqPo;
	}
	@JsonProperty("_req_po_cnt")
	public void setReqPoCnt(int reqPoCnt) {
		this.reqPoCnt = reqPoCnt;
	}
	@JsonProperty("_req_po_no")
	public void setReqPoNo(long reqPoNo) {
		this.reqPoNo = reqPoNo;
	}
	@JsonIgnore
	public void setResCnt(int resCnt) {
		this.resCnt = resCnt;
	}
	@JsonIgnore
	public void setRes(List<AP0001Res> res) {
		this.res = res;
	}
	@JsonIgnore
	public void setResDate(String resDate) {
		this.resDate = resDate;
	}
	@JsonIgnore
	public void setResLastNo(long resLastNo) {
		this.resLastNo = resLastNo;
	}

	public static class AP0001Res {
		@JsonProperty("_brd_no")
		public long brdNo;
		@JsonProperty("_brd_nm")
		public String brdNm;
		@JsonProperty("_brd_id")
		public String brdId;
		@JsonProperty("_brd_profile_img")
		public String brdProfileImg;
		@JsonProperty("_brd_subject")
		public String brdSubject;
		@JsonProperty("_brd_contents")
		public byte[] brdContents;
		@JsonProperty("_brd_tag")
		public String brdTag;
		@JsonProperty("_brd_cate_nm")
		public String brdCateNm;
		@JsonProperty("_brd_cate")
		public int brdCate;
		@JsonProperty("_brd_modified")
		public String brdModified;
		@JsonProperty("_brd_created")
		public String brdCreated;
		@JsonProperty("_brd_like_cnt")
		public int brdLikeCnt;
		@JsonProperty("_brd_comment_cnt")
		public int brdCommentCnt;
		@JsonProperty("_brd_img")
		public List<AP0001Img> brdImg;
	}
	
	public static class AP0001Img {
		@JsonProperty("_brd_thumb_img")
		public String brdThumbImg;
		@JsonProperty("_brd_origin_img")
		public String brdOriginImg;
	}
}
