package com.house.model;

import java.io.Serializable;
import java.util.HashMap;

public class Data implements Serializable {
	private Status status;
	public HashMap<String, Object> body;

	public Data() {
		status = Status.OK;
		body = new HashMap<String, Object>();
	}
	
	public HashMap<String, Object> getBody() {
		return body;
	}

	public void setBody(HashMap<String, Object> body) {
		this.body = body;
	}

	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public static enum Status {
		OK, FAIL;
	}
}
