package com.house.service;

import com.house.model.Attach;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FileService {
	public boolean addAttach(Attach paramAttach);

	public boolean modifyAttach(Attach paramAttach);

	public boolean removeAttach(long paramLong);

	public boolean removeAttachsByNoType(long paramLong, int paramInt);

	public boolean removeAttachsByCateNo(long paramLong, int paramInt);

	public Attach[] getAttachByNoType(long paramLong, int paramInt);

	public Attach[] getAttachByUsrType(long paramLong, int paramInt);

	public Attach getAttachByExUrl(String paramString);
}
