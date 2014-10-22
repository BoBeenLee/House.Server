package com.house.service.impl;

import com.house.mapper.FileMapper;
import com.house.model.Attach;
import com.house.model.TransferMultipartFile;
import com.house.service.FileService;
import com.house.util.FileUtils;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fileService")
public class FileServiceImpl implements FileService {
	public static final String EXTERNAL_URL = "/house/image";
	@Autowired
	public FileMapper fileMapper;

	public boolean addAttach(Attach attach) {
		Calendar calendar = Calendar.getInstance();
		Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());

		attach.setCreatedByDate(timestamp);
		attach.setModifiedByDate(timestamp);

		boolean isAttach = 1 == this.fileMapper.insertAttach(attach);

		TransferMultipartFile mf = attach.getTransferMultipartFile();
		String innerUrl = FileUtils.ROOT_URL;
		String name = attach.getAttachNo() + mf.getOriginalFilename();
		String type = "";
		if (name.indexOf('.') == -1) {
			type = ".png";
		} else {
			type = name.substring(name.indexOf('.'));
			name = name.replaceAll(type, "");
		}
		attach.setSrcSeq(0);
		attach.setName(name);
		attach.setExUrl("/house/image/" + name + ".app");
		attach.setExThumUrl("/house/image/" + name + ".app");
		attach.setInUrl(innerUrl + "/" + name + type);
		modifyAttach(attach);
		try {
			FileUtils.transferTo(name + type, mf.getContent());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isAttach;
	}

	public boolean modifyAttach(Attach attach) {
		boolean isAttach = 1 == this.fileMapper.updateAttach(attach);
		return isAttach;
	}

	public boolean removeAttach(long attachNo) {
		boolean isAttach = 1 == this.fileMapper.deleteAttach(attachNo);
		return isAttach;
	}

	public boolean removeAttachsByNoType(long srcNo, int srcType) {
		boolean isAttach = 1 == this.fileMapper.deleteAttachsByNoType(srcNo,
				srcType);
		return isAttach;
	}

	public Attach[] getAttachByNoType(long srcNo, int srcType) {
		Attach[] attachs = this.fileMapper
				.getAttachByNoType(srcNo, srcType, 0L);
		return attachs;
	}

	public Attach[] getAttachByUsrType(long uploadUsr, int srcType) {
		Attach[] attachs = this.fileMapper.getAttachByNoType(0L, srcType,
				uploadUsr);
		return attachs;
	}

	public boolean removeAttachsByCateNo(long cateNo, int srcType) {
		boolean isAttach = 1 == this.fileMapper.deleteAttachsByCateNo(cateNo,
				srcType);
		return isAttach;
	}

	public Attach getAttachByExUrl(String exUrl) {
		return this.fileMapper.getAttachByExUrl(exUrl);
	}
}
