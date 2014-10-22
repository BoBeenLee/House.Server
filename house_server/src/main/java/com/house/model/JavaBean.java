package com.house.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

public class JavaBean implements Serializable {
	private int num;
	private String name;
	private String content;
	private byte[] image;
	private boolean check;
	private TransferMultipartFile upload;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@JsonIgnore
	public boolean isCheck() {
		return this.check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public TransferMultipartFile getUpload() {
		return this.upload;
	}

	public void setUpload(TransferMultipartFile upload) {
		this.upload = upload;
	}
}
