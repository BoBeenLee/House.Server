package com.house.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

import com.house.model.Attach;
import com.house.model.TransferMultipartFile;
import com.house.util.FileUtils;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FileService {
	public boolean addAttach(Attach attach);

	public boolean modifyAttach(Attach attach);

	public boolean removeAttach(long attachNo);

	public boolean removeAttachsByNoType(long srcNo, int srcType);

	public Attach[] getAttachByNoType(long srcNo, int srcType);

	public Attach[] getAttachByUsrType(long uploadUsr, int srcType);

	public boolean removeAttachsByCateNo(long cateNo, int srcType);

	public Attach getAttachByExUrl(String exUrl);
}
