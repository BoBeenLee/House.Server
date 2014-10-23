package com.house.service;

import org.springframework.transaction.annotation.Transactional;

import com.house.model.Attach;

@Transactional
public interface FileService {
	public boolean addAttach(Attach attach);
	public boolean modifyAttach(Attach attach);
	public boolean removeAttach(long attachNo);
	public boolean removeAttachsByNoType(long srcNo, int srcType);
	public Attach[] getAttachByNoType(long srcNo, int srcType);
	public Attach[] getAttachByUsrType(long uploadUsr, int srcType);
}
