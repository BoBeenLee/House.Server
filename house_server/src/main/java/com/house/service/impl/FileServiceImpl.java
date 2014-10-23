package com.house.service.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.house.mapper.FileMapper;
import com.house.model.Attach;
import com.house.model.TransferMultipartFile;
import com.house.service.FileService;
import com.house.util.FileUtils;

@Service("fileService")
public class FileServiceImpl implements FileService {
	public static final String EXTERNAL_URL = "/image";
	
	@Autowired
	public FileMapper fileMapper;
	
	public boolean addAttach(Attach attach) {
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
		
		attach.setCreatedByDate(timestamp);
		attach.setModifiedByDate(timestamp);
		boolean isAttach = (1 == fileMapper.insertAttach(attach))? true :false;
		
		// 파일 서버 추가
		TransferMultipartFile mf = attach.getTransferMultipartFile();
		String innerUrl = FileUtils.innerUrl();
		String name = attach.getAttachNo() + mf.getOriginalFilename();
		
		attach.setSrcSeq(0); // ?
		attach.setName(name);
		attach.setExUrl(EXTERNAL_URL + "/" + name);
		attach.setInUrl(innerUrl + "/" + name);
		modifyAttach(attach);
		try {
			FileUtils.transferTo(name, mf.getContent());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isAttach;
	}

	public boolean modifyAttach(Attach attach) {
		boolean isAttach = (1 == fileMapper.updateAttach(attach))? true :false;
		return isAttach;
	}

	public boolean removeAttach(long attachNo) {
		boolean isAttach = (1 == fileMapper.deleteAttach(attachNo))? true :false;
		return isAttach;
	}

	public boolean removeAttachsByNoType(long srcNo, int srcType) {
		boolean isAttach = (1 == fileMapper.deleteAttachsByNoType(srcNo, srcType))? true :false;
		return isAttach;
	}
	
	public Attach[] getAttachByNoType(long srcNo, int srcType) {
		Attach[] attachs = fileMapper.getAttachByNoType(srcNo, srcType, 0);
		return attachs;
	}

	public Attach[] getAttachByUsrType(long uploadUsr, int srcType) {
		Attach[] attachs = fileMapper.getAttachByNoType(0, srcType, uploadUsr);
		return attachs;
	}
}
