package com.house.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import org.springframework.web.multipart.MultipartFile;

public class TransferMultipartFile implements Serializable {
	private String originalFilename;
	private String name;
	private byte[] content;
	private String contentType;
	private long size;
	private boolean isEmpty;

	public TransferMultipartFile() {
	}

	public TransferMultipartFile(String originalFilename, String name,
			byte[] content, String contentType, long size, boolean isEmpty) {
		this.originalFilename = originalFilename;
		this.name = name;
		this.content = content;
		this.contentType = contentType;
		this.size = size;
		this.isEmpty = isEmpty;
	}

	public TransferMultipartFile(String originalFilename, String name,
			InputStream inputStream, String contentType, long size,
			boolean isEmpty) throws IOException {
		this.originalFilename = originalFilename;
		this.name = name;
		this.contentType = contentType;
		this.size = size;
		this.isEmpty = isEmpty;

		this.content = new byte[(int) (this.size + 1L)];
		inputStream.read(this.content);
	}

	public TransferMultipartFile(MultipartFile mf) throws IOException {
		this.isEmpty = mf.isEmpty();
		this.size = mf.getSize();
		this.originalFilename = mf.getOriginalFilename();
		this.name = mf.getName();
		this.contentType = mf.getContentType();

		this.content = new byte[(int) (this.size + 1L)];
		mf.getInputStream().read(this.content);
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public String getContentType() {
		return this.contentType;
	}

	public String getName() {
		return this.name;
	}

	public String getOriginalFilename() {
		return this.originalFilename;
	}

	public long getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.isEmpty;
	}

	public void transferTo(File dest) throws IOException, IllegalStateException {
		new FileOutputStream(dest).write(this.content);
	}

	public byte[] getContent() {
		return this.content;
	}
}
