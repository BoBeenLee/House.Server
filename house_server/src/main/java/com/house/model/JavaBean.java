package com.house.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JavaBean implements Serializable {
	private int num;
	private String name;
	private String content;
	private byte[] image;
	private boolean check;
	private TransferMultipartFile upload;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@JsonIgnore
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public TransferMultipartFile getUpload() {
		return upload;
	}
	public void setUpload(TransferMultipartFile upload) {
		this.upload = upload;
	}
}
