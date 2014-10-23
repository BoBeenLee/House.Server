package com.house.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.mapper.CMMapper;
import com.house.model.APICode;
import com.house.model.Attach;
import com.house.model.Data;
import com.house.model.SrcType;
import com.house.model.TransferMultipartFile;
import com.house.model.User;
import com.house.model.code.*;
import com.house.service.CMService;
import com.house.service.FileService;
import com.house.service.InteriorService;
import com.house.service.SudatalkService;
import com.house.service.TokenService;
import com.house.service.UserService;
import com.house.util.JacksonUtils;

@Service("cmService")
public class CMServiceImpl implements CMService {
	// mapper
	@Autowired
	CMMapper cmMapper;
	
	// service
	@Autowired
	FileService fileService;
	@Autowired
	UserService userService;
	@Autowired
	InteriorService interiorService;
	@Autowired
	SudatalkService sudatalkService;
	@Autowired
	TokenService tokenService;
	
	public APICode responseCM0001(APICode reqCode){
		HashMap<String, String> hashMap = (HashMap<String, String>) reqCode.getTranData().get(0);
		CM0001 cm = JacksonUtils.<CM0001>hashMapToObject(hashMap, CM0001.class);
		ArrayList<CM0001> cms = new ArrayList<CM0001>();
		
		// usrId, usrPw
		User user = userService.getUserById(cm.getUsrId());
		String token = null;
		
		if(user.getUsrId().equals(cm.getUsrId()) && user.getUsrPw().equals(cm.getUsrPw())){
			 token = tokenService.getToken(user);
			 user.setToken(token);
		}
		
		// Response
		CM0001 resCM = new CM0001();
		resCM.setUsrId(user.getUsrId());
		resCM.setRegNo("" + user.getUsrNo());
		resCM.setToken(user.getToken());
		cms.add(resCM);
		
		APICode<CM0001> resCode = this.<CM0001>processCommonResponse(reqCode, cms);
		return resCode;
	}

	public APICode responseCM0002(APICode reqCode){
		HashMap<String, String> hashMap = (HashMap<String, String>) reqCode.getTranData().get(0);
		CM0002 cm = JacksonUtils.<CM0002>hashMapToObject(hashMap, CM0002.class);
		ArrayList<CM0002> cms = new ArrayList<CM0002>();
		
		APICode<CM0002> resCode = this.<CM0002>processCommonResponse(reqCode, cms);
		return resCode;
	}

	public APICode responseCM0003(APICode reqCode){
		HashMap<String, String> hashMap = (HashMap<String, String>) reqCode.getTranData().get(0);
		CM0003 cm = JacksonUtils.<CM0003>hashMapToObject(hashMap, CM0003.class);
		ArrayList<CM0003> cms = new ArrayList<CM0003>();
		
		// usrId, usrPw, usrNm, ,termsYN, psPlatform, psId, psRevokeYN, psAppVer, deviceNM, usrSts
		Data data = new Data();
		User user = new User();
		user.setUsrId(cm.getUsrId());
		user.setUsrPw(cm.getUsrPw());
		user.setUsrNm(cm.getCustName());
		user.setTermsYN(cm.getTermsYN());
		user.setPsPlatform(cm.getPsPlatform());
		user.setPsId(cm.getPsId());
		user.setPsRevokeYN(cm.getPsRevokeYN());
		user.setPsAppVer(cm.getPsAppVer());
		user.setDeviceNM(cm.getDeviceNM());
		user.setUsrSts(cm.getUsrSts());

		CM0003.CM0003Img img = cm.getUsrImg();
		Attach attach = new Attach();
		TransferMultipartFile mf = new TransferMultipartFile(img.imgOriginNm, img.imgNm, img.imgContent, img.imgType, img.imgSize, false);
		attach.setTransferMultipartFile(mf);
		attach.setUploadUsr(user.getUsrNo());
		
		boolean isUser = userService.addUser(user, attach);
		
		CM0003 resCM = new CM0003();
		if(isUser)
			resCM.setResultYn("Y");
		else
			resCM.setResultYn("N");
		cms.add(resCM);
		
		APICode<CM0003> resCode = this.<CM0003>processCommonResponse(reqCode, cms);
		return resCode;
	}

	public APICode responseCM0004(APICode reqCode){
		HashMap<String, String> hashMap = (HashMap<String, String>) reqCode.getTranData().get(0);
		CM0004 cm = JacksonUtils.<CM0004>hashMapToObject(hashMap, CM0004.class);
		ArrayList<CM0004> cms = new ArrayList<CM0004>();
		
		// usrId, usrPw
		User user = userService.getUserById(cm.getUsrId());
		boolean isUser = false;
		
		if(user.getUsrPw().equals(cm.getUsrPw()))
			isUser = userService.removeUser(user.getUsrNo());
		
		// Response
		CM0004 resCM = new CM0004();
		if(isUser)
			resCM.setResultYn("Y");
		else
			resCM.setResultYn("N");
		cms.add(resCM);
		
		APICode<CM0004> resCode = this.<CM0004>processCommonResponse(reqCode, cms);
		return resCode;
	}

	public APICode responseCM0005(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap<String, String>) reqCode.getTranData().get(0);
		CM0005 cm = JacksonUtils.<CM0005>hashMapToObject(hashMap, CM0005.class);
		ArrayList<CM0005> cms = new ArrayList<CM0005>();
		
		// Response
		CM0005 resCM = cmMapper.getCM0005(cm.getUsrId(), SrcType.PROFILE_TYPE);
		cms.add(resCM);
		APICode<CM0005> resCode = this.<CM0005>processCommonResponse(reqCode, cms);
		return resCode;
	}

	public APICode responseCM0006(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap<String, String>) reqCode.getTranData().get(0);
		CM0006 cm = JacksonUtils.<CM0006>hashMapToObject(hashMap, CM0006.class);
		ArrayList<CM0006> cms = new ArrayList<CM0006>();
		
		User user = userService.getUserById(cm.getUsrId());
		Attach attach = null;
		boolean isUser = false;
		
		if(cm.getUsrPw() != null)
			user.setUsrPw(cm.getUsrPw());
		if(cm.getCustName() != null)
			user.setUsrNm(cm.getCustName());
		if(cm.getUsrSts() != 0)
			user.setUsrSts(cm.getUsrSts());
		if(cm.getUsrImg() != null){
			CM0006.CM0006Img img = cm.getUsrImg();
			attach = new Attach();
			TransferMultipartFile mf = new TransferMultipartFile(img.imgOriginNm, img.imgNm, img.imgContent, img.imgType, img.imgSize, false);
			attach.setTransferMultipartFile(mf);
			attach.setUploadUsr(user.getUsrNo());
		}
		isUser = userService.modifyUser(user, attach);	
		
		// Response
		CM0006 resCM = new CM0006();
		if(isUser)
			resCM.setResultYn("Y");
		else
			resCM.setResultYn("N");
		cms.add(resCM);
		APICode<CM0006> resCode = this.<CM0006>processCommonResponse(reqCode, cms);
		return resCode;
	}

	public APICode responseCM0007(APICode reqCode) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> APICode<T> processCommonResponse(APICode reqCode, ArrayList<T> cms){
		// post Response
		APICode<T> resCode = new APICode<T>();
		resCode.setTranCd(reqCode.getTranCd());
		resCode.setTranData(cms);
		return resCode;
	}

	public APICode responseCM0008(APICode reqCode) {
		// TODO Auto-generated method stub
		return null;
	}
}
