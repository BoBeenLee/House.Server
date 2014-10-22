package com.house.service.impl;

import com.house.mapper.CMMapper;
import com.house.model.APICode;
import com.house.model.Attach;
import com.house.model.Data;
import com.house.model.TransferMultipartFile;
import com.house.model.User;
import com.house.model.code.CM0001;
import com.house.model.code.CM0002;
import com.house.model.code.CM0003;
import com.house.model.code.CM0003.CM0003Img;
import com.house.model.code.CM0004;
import com.house.model.code.CM0005;
import com.house.model.code.CM0006;
import com.house.model.code.CM0006.CM0006Img;
import com.house.service.CMService;
import com.house.service.FileService;
import com.house.service.InteriorService;
import com.house.service.SudatalkService;
import com.house.service.TokenService;
import com.house.service.UserService;
import com.house.util.JacksonUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cmService")
public class CMServiceImpl implements CMService {
	@Autowired
	CMMapper cmMapper;
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

	public APICode responseCM0001(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap) reqCode.getTranData()
				.get(0);
		CM0001 cm = (CM0001) JacksonUtils
				.hashMapToObject(hashMap, CM0001.class);
		ArrayList<CM0001> cms = new ArrayList();

		User user = this.userService.getUserById(cm.getUsrId());
		String token = null;
		CM0001 resCM = null;
		if ((user != null) && (user.getUsrId().equals(cm.getUsrId()))
				&& (user.getUsrPw().equals(cm.getUsrPw()))) {
			resCM = this.cmMapper.getCM0001(user.getUsrId(), 1);
			token = this.tokenService.getToken(user);
			user.setToken(token);
			resCM.setToken(user.getToken());
			cms.add(resCM);
		}
		APICode<CM0001> resCode = processCommonResponse(reqCode, cms);
		return resCode;
	}

	public APICode responseCM0002(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap) reqCode.getTranData()
				.get(0);
		CM0002 cm = (CM0002) JacksonUtils
				.hashMapToObject(hashMap, CM0002.class);
		ArrayList<CM0002> cms = new ArrayList();

		APICode<CM0002> resCode = processCommonResponse(reqCode, cms);
		return resCode;
	}

	public APICode responseCM0003(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap) reqCode.getTranData()
				.get(0);
		CM0003 cm = (CM0003) JacksonUtils
				.hashMapToObject(hashMap, CM0003.class);
		ArrayList<CM0003> cms = new ArrayList();

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
		Attach attach = null;
		TransferMultipartFile mf = null;
		boolean isUser = false;
		if (img != null) {
			attach = new Attach();
			mf = new TransferMultipartFile(img.imgOriginNm, img.imgNm,
					img.imgContent, img.imgType, img.imgSize, false);
			attach.setTransferMultipartFile(mf);
			attach.setUploadUsr(user.getUsrNo());
		}
		isUser = this.userService.addUser(user, attach);

		CM0003 resCM = new CM0003();
		if (isUser) {
			resCM.setResultYn("Y");
		} else {
			resCM.setResultYn("N");
		}
		cms.add(resCM);

		APICode<CM0003> resCode = processCommonResponse(reqCode, cms);
		return resCode;
	}

	public APICode responseCM0004(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap) reqCode.getTranData()
				.get(0);
		CM0004 cm = (CM0004) JacksonUtils
				.hashMapToObject(hashMap, CM0004.class);
		ArrayList<CM0004> cms = new ArrayList();

		User user = this.userService.getUserById(cm.getUsrId());
		boolean isUser = false;
		if (user.getUsrPw().equals(cm.getUsrPw())) {
			isUser = this.userService.removeUser(user.getUsrNo());
		}
		CM0004 resCM = new CM0004();
		if (isUser) {
			resCM.setResultYn("Y");
		} else {
			resCM.setResultYn("N");
		}
		cms.add(resCM);

		APICode<CM0004> resCode = processCommonResponse(reqCode, cms);
		return resCode;
	}

	public APICode responseCM0005(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap) reqCode.getTranData()
				.get(0);
		CM0005 cm = (CM0005) JacksonUtils
				.hashMapToObject(hashMap, CM0005.class);
		ArrayList<CM0005> cms = new ArrayList();

		CM0005 resCM = this.cmMapper.getCM0005(cm.getUsrId(), 1);
		cms.add(resCM);
		APICode<CM0005> resCode = processCommonResponse(reqCode, cms);
		return resCode;
	}

	public APICode responseCM0006(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap) reqCode.getTranData()
				.get(0);
		CM0006 cm = (CM0006) JacksonUtils
				.hashMapToObject(hashMap, CM0006.class);
		ArrayList<CM0006> cms = new ArrayList();

		User user = this.userService.getUserById(cm.getUsrId());
		Attach attach = null;
		boolean isUser = false;
		if (cm.getUsrPw() != null) {
			user.setUsrPw(cm.getUsrPw());
		}
		if (cm.getCustName() != null) {
			user.setUsrNm(cm.getCustName());
		}
		if (cm.getUsrSts() != 0) {
			user.setUsrSts(cm.getUsrSts());
		}
		if (cm.getUsrImg() != null) {
			CM0006.CM0006Img img = cm.getUsrImg();
			attach = new Attach();
			TransferMultipartFile mf = new TransferMultipartFile(
					img.imgOriginNm, img.imgNm, img.imgContent, img.imgType,
					img.imgSize, false);
			attach.setTransferMultipartFile(mf);
			attach.setUploadUsr(user.getUsrNo());
		}
		isUser = this.userService.modifyUser(user, attach);

		CM0006 resCM = new CM0006();
		if (isUser) {
			resCM.setResultYn("Y");
		} else {
			resCM.setResultYn("N");
		}
		cms.add(resCM);
		APICode<CM0006> resCode = processCommonResponse(reqCode, cms);
		return resCode;
	}

	public APICode responseCM0007(APICode reqCode) {
		return null;
	}

	public <T> APICode<T> processCommonResponse(APICode reqCode,
			ArrayList<T> cms) {
		APICode<T> resCode = new APICode();
		resCode.setTranCd(reqCode.getTranCd());
		resCode.setTranData(cms);
		return resCode;
	}

	public APICode responseCM0008(APICode reqCode) {
		return null;
	}
}
