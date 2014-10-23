package com.house.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.mapper.APMapper;
import com.house.model.APICode;
import com.house.model.Attach;
import com.house.model.CodeType;
import com.house.model.Comment;
import com.house.model.Interior;
import com.house.model.Like;
import com.house.model.Scrap;
import com.house.model.SrcType;
import com.house.model.Sudatalk;
import com.house.model.TransferMultipartFile;
import com.house.model.User;
import com.house.model.code.*;
import com.house.model.code.AP0001.AP0001Res;
import com.house.model.code.AP0003.AP0003Comment;
import com.house.model.code.AP0006.AP0006Img;
import com.house.service.APService;
import com.house.service.FileService;
import com.house.service.InteriorService;
import com.house.service.SudatalkService;
import com.house.service.TokenService;
import com.house.service.UserService;
import com.house.util.DateUtils;
import com.house.util.JacksonUtils;

@Service("apService")
public class APServiceImpl implements APService {
	// mapper
	@Autowired
	APMapper apMapper;
	
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
	
	public APICode responseAP0001(APICode reqCode){
		HashMap<String, String> hashMap = (HashMap<String, String>) reqCode.getTranData().get(0);
		AP0001 ap = JacksonUtils.<AP0001>hashMapToObject(hashMap, AP0001.class);
		ArrayList<AP0001> aps = new ArrayList<AP0001>();
		
		int type = ap.getType();
		int srcType = 0;
		List<AP0001.AP0001Res> res = new ArrayList();
		
		if(CodeType.INTERIOR_TYPE == type){
			srcType = SrcType.INTERIOR_TYPE;
			AP0001Res[] datas = apMapper.getInteriorAP0001Res(ap.getReqPoNo(), srcType, SrcType.PROFILE_TYPE, ap.getReqPoCnt());
			res = Arrays.asList(datas);
		} else if(CodeType.SUDATALK_TYPE == type){
			srcType = SrcType.SUDATALK_TYPE;
			AP0001Res[] datas = apMapper.getSudatalkAP0001Res(ap.getReqPoNo(), srcType, SrcType.PROFILE_TYPE, ap.getReqPoCnt());
			res = Arrays.asList(datas);
		}
		if(res.size() > 0){
			ap.setResCnt(res.size());
			for(int i=0; i<ap.getResCnt(); i++){
				Attach[] attachs = fileService.getAttachByNoType(res.get(i).brdNo, srcType);
				ArrayList<AP0001.AP0001Img> imgs = new ArrayList<AP0001.AP0001Img>();
				for(int j=0; j<attachs.length; j++){
					AP0001.AP0001Img img = new AP0001.AP0001Img();
					img.brdOriginImg = attachs[j].getExUrl();
					img.brdThumbImg = attachs[j].getExThumUrl();
					imgs.add(img);
				}
				res.get(i).brdImg = imgs;
			}
			ap.setRes(res);
			ap.setResDate(DateUtils.currentTime());
			ap.setResLastNo(res.get(ap.getResCnt() - 1).brdNo);
		}
		AP0001 resAP = ap;
		aps.add(resAP);
		
		APICode<AP0001> resCode = this.<AP0001>processCommonResponse(reqCode, aps);
		return resCode;
	}

	public APICode responseAP0002(APICode reqCode) {
		return null;
	}

	public APICode responseAP0003(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap<String, String>) reqCode.getTranData().get(0);
		AP0003 ap = JacksonUtils.<AP0003>hashMapToObject(hashMap, AP0003.class);
		ArrayList<AP0003> aps = new ArrayList<AP0003>();
		
		int type = ap.getType();
		int srcType = 0;
		long articleId = ap.getReqPoNo();
		User user = userService.getUserById(ap.getUsrId());
		
		Comment[] comments = null;
		
		// Response
		AP0003 resAP = null;
		
		if(CodeType.INTERIOR_TYPE == type){
			srcType = SrcType.INTERIOR_TYPE;
			resAP = apMapper.getInteriorAP0003(articleId, srcType, SrcType.PROFILE_TYPE);
			comments = interiorService.getCommentBySrcNo(articleId, SrcType.PROFILE_TYPE);
		} else if(CodeType.SUDATALK_TYPE == type){
			srcType = SrcType.SUDATALK_TYPE;
			resAP = apMapper.getSudatalkAP0003(articleId, srcType, SrcType.PROFILE_TYPE);
			comments = sudatalkService.getCommentBySrcNo(articleId, SrcType.PROFILE_TYPE);
		}
		
		if(resAP != null){
			int likeState = (userService.getLikeByNoType(user.getUsrNo(), articleId, srcType) == null)? 0 : 1;
			int scrapState = (userService.getScrapByNoType(user.getUsrNo(), articleId, srcType) == null)? 0 : 1;

			resAP.setBrdLikeState(likeState);
			resAP.setBrdScrapCnt(scrapState);
			
			ArrayList<AP0003Comment> apComments = new ArrayList<AP0003Comment>();
			for(int i=0; comments != null && i<comments.length; i++){
				AP0003Comment comment = new AP0003Comment();
				comment.brdCommentNo = comments[i].getCommentNo();
				comment.brdCommentCreated = comments[i].getCreated();
				comment.brdCommentId = comments[i].getUsrId();
				comment.brdCommentProfileImg = comments[i].getProfileImg();
				comment.brdCommentNm = comments[i].getUsrNm();
				comment.brdCommentContents = comments[i].getContents();
				apComments.add(comment);
			}
			resAP.setBrdComment(apComments);
			
			ArrayList<String> imgs = new ArrayList<String>();
			Attach[] attachs = fileService.getAttachByNoType(articleId, srcType);
			
			for(int i=0; attachs != null && i<attachs.length; i++)
				imgs.add(attachs[i].getExUrl());
			resAP.setBrdImg(imgs);
		} else 
			resAP = new AP0003();
		
		aps.add(resAP);
		APICode<AP0003> resCode = this.<AP0003>processCommonResponse(reqCode, aps);
		return resCode;
	}

	public APICode responseAP0004(APICode reqCode){
		HashMap<String, String> hashMap = (HashMap<String, String>) reqCode.getTranData().get(0);
		AP0004 ap = JacksonUtils.<AP0004>hashMapToObject(hashMap, AP0004.class);
		ArrayList<AP0004> aps = new ArrayList<AP0004>();
		
		int type = ap.getType();
		int srcType = 0;
		long articleNo = ap.getBrdNo();
		long usrNo = userService.getUserById(ap.getUsrId()).getUsrNo();
		boolean isLike = false;
		Like like = null;
		
		if(CodeType.INTERIOR_TYPE == type){
			like = userService.getLikeByNoType(usrNo, articleNo, SrcType.INTERIOR_TYPE);
			srcType = SrcType.INTERIOR_TYPE;
		} else if(CodeType.SUDATALK_TYPE == type) { 
			like = userService.getLikeByNoType(usrNo, articleNo, SrcType.SUDATALK_TYPE);
			srcType = SrcType.SUDATALK_TYPE;
		}
		
		if(like != null){
			isLike = userService.removeLike(like.getLikeNo());
		} else {
			like = new Like();
			like.setSrcNo(articleNo);
			like.setUsrNo(usrNo);
			like.setSrcType(srcType);
			isLike = userService.addLike(like);
		}
		
		// Response
		AP0004 resAP = new AP0004();
		resAP.setLikeCnt(userService.getLikeCount(articleNo, srcType));
		if(isLike)
			resAP.setResultYn("Y");
		else
			resAP.setResultYn("N");
		aps.add(resAP);
		APICode<AP0004> resCode = this.<AP0004>processCommonResponse(reqCode, aps);
		return resCode;
	}

	public APICode responseAP0005(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap<String, String>) reqCode.getTranData().get(0);
		AP0005 ap = JacksonUtils.<AP0005>hashMapToObject(hashMap, AP0005.class);
		ArrayList<AP0005> aps = new ArrayList<AP0005>();
		
		int type = ap.getType();
		int srcType = 0;
		long articleNo = ap.getBrdNo();
		long usrNo = userService.getUserById(ap.getUsrId()).getUsrNo();
		boolean isScrap = false;
		Scrap scrap = null;
		
		if(CodeType.INTERIOR_TYPE == type){
			scrap = userService.getScrapByNoType(usrNo, articleNo, SrcType.INTERIOR_TYPE);
			srcType = SrcType.INTERIOR_TYPE;
		} else if(CodeType.SUDATALK_TYPE == type) { 
			scrap = userService.getScrapByNoType(usrNo, articleNo, SrcType.SUDATALK_TYPE);
			srcType = SrcType.SUDATALK_TYPE;
		}
		
		if(scrap != null){
			isScrap = userService.removeScrap(scrap.getScrapNo());
		} else {
			scrap = new Scrap();
			scrap.setSrcNo(articleNo);
			scrap.setUsrNo(usrNo);
			scrap.setSrcType(srcType);
			isScrap = userService.addScrap(scrap);
		}
		
		// Response
		AP0005 resAP = new AP0005();
		resAP.setScrapCnt(userService.getScrapCount(articleNo, srcType));
		if(isScrap)
			resAP.setResultYn("Y");
		else
			resAP.setResultYn("N");
		aps.add(resAP);
		APICode<AP0005> resCode = this.<AP0005>processCommonResponse(reqCode, aps);
		return resCode;
	}

	public APICode responseAP0006(APICode reqCode){
		HashMap<String, String> hashMap = (HashMap<String, String>) reqCode.getTranData().get(0);
		AP0006 ap = JacksonUtils.<AP0006>hashMapToObject(hashMap, AP0006.class);
		ArrayList<AP0006> aps = new ArrayList<AP0006>();
		
		int type = ap.getType();
		long articleId = ap.getBrdNo();
		Interior interior = null;
		Sudatalk sudatalk = null;
		Attach[] attachs = null;
		User user = userService.getUserById(ap.getBrdId());
		boolean isArticle = false;
		
		if(ap.getBrdImg() != null && ap.getBrdImg().size() > 0){
			attachs = new Attach[ap.getBrdImg().size()];
			for(int i=0; i<attachs.length; i++){
				AP0006Img img = ap.getBrdImg().get(i);
				attachs[i] = new Attach();
				TransferMultipartFile mf = new TransferMultipartFile(img.imgOriginNm, img.imgNm, img.imgContent, img.imgType, img.imgSize, false);
				attachs[i].setTransferMultipartFile(mf);
				attachs[i].setUploadUsr(user.getUsrNo());
			}
		}
		
		/* interior, imgs */
		if(CodeType.INTERIOR_TYPE == type) {
			interior = new Interior();
			interior.setInteriorNo(articleId);
			interior.setUsrNo(user.getUsrNo());
			interior.setSubject(ap.getBrdSubject());
			interior.setContents(ap.getBrdContents());
			interior.setCateCd(ap.getBrdCateNo());
			interior.setTagNm(ap.getBrdTag());
			
			isArticle = (interior.getInteriorNo() == 0)?  interiorService.addInterior(interior, attachs) :  interiorService.modifyInterior(interior, attachs);
		} else if(CodeType.SUDATALK_TYPE == type){
			sudatalk = new Sudatalk();
			sudatalk.setTalkNo(articleId);
			sudatalk.setUsrNo(user.getUsrNo());
			sudatalk.setSubject(ap.getBrdSubject());
			sudatalk.setContents(ap.getBrdContents());
			sudatalk.setTagNm(ap.getBrdTag());
			sudatalk.setCateCd(ap.getBrdCateNo());
			
			isArticle = (sudatalk.getTalkNo() == 0)? sudatalkService.addSudatalk(sudatalk, attachs) : sudatalkService.modifySudatalk(sudatalk, attachs);
		}
		// Response
		AP0006 resAP = new AP0006();
		if(isArticle)
			resAP.setResultYn("Y");
		else
			resAP.setResultYn("N");
		aps.add(resAP);
		APICode<AP0006> resCode = this.<AP0006>processCommonResponse(reqCode, aps);
		return resCode;
	}
	public APICode responseAP0007(APICode reqCode){
		HashMap<String, String> hashMap = (HashMap<String, String>) reqCode.getTranData().get(0);
		AP0007 ap = JacksonUtils.<AP0007>hashMapToObject(hashMap, AP0007.class);
		ArrayList<AP0007> aps = new ArrayList<AP0007>();
		
		int type = ap.getType();
		long articleNo = ap.getBrdNo();
		boolean isArticle = false;
		
		if(CodeType.INTERIOR_TYPE == type)
			isArticle = interiorService.removeInterior(articleNo);
		else if(CodeType.SUDATALK_TYPE == type)
			isArticle = sudatalkService.removeSudatalk(articleNo);
		
		// Response
		AP0007 resAP = new AP0007();
		if(isArticle)
			resAP.setResultYn("Y");
		else
			resAP.setResultYn("N");
		aps.add(resAP);
		APICode<AP0007> resCode = this.<AP0007>processCommonResponse(reqCode, aps);
		return resCode;
	}

	public APICode responseAP0008(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap<String, String>) reqCode.getTranData().get(0);
		AP0008 ap = JacksonUtils.<AP0008>hashMapToObject(hashMap, AP0008.class);
		ArrayList<AP0008> aps = new ArrayList<AP0008>();
		
		int type = ap.getType();
		long articleNo = ap.getReqPoNo();
		long usrNo = userService.getUserById(ap.getCommentId()).getUsrNo();
		long commentNo = ap.getCommentNo();
		boolean isComment = false;
		
		Comment comment = new Comment();
	
		if(commentNo != 0 && CodeType.INTERIOR_TYPE == type)
			comment = interiorService.getCommentByNo(commentNo, SrcType.PROFILE_TYPE);
		else if(commentNo != 0 && CodeType.SUDATALK_TYPE == type)
			comment = sudatalkService.getCommentByNo(commentNo, SrcType.PROFILE_TYPE);
		comment.setSrcNo(articleNo);
		comment.setUsrNo(usrNo);
		comment.setContents(ap.getCommentContents());
		
		if(CodeType.INTERIOR_TYPE == type)
			isComment = (comment.getCommentNo() == 0)? interiorService.addComment(comment) : interiorService.modifyComment(comment);
		else if(CodeType.SUDATALK_TYPE == type)
			isComment = (comment.getCommentNo() == 0)? sudatalkService.addComment(comment) : sudatalkService.modifyComment(comment);
		
		// Response
		AP0008 resAP = new AP0008();
		if(isComment)
			resAP.setResultYn("Y");
		else
			resAP.setResultYn("N");
		aps.add(resAP);
		APICode<AP0008> resCode = this.<AP0008>processCommonResponse(reqCode, aps);
		return resCode;
	}
	
	public APICode responseAP0009(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap<String, String>) reqCode.getTranData().get(0);
		AP0009 ap = JacksonUtils.<AP0009>hashMapToObject(hashMap, AP0009.class);
		ArrayList<AP0009> aps = new ArrayList<AP0009>();
		
		int type = ap.getType();
		long usrNo = userService.getUserById(ap.getCommentId()).getUsrNo();
		long commentNo = ap.getCommentNo();
		boolean isComment = false;
		
		if(CodeType.INTERIOR_TYPE == type)
			isComment = interiorService.removeComment(commentNo);
		else if(CodeType.SUDATALK_TYPE == type)
			isComment = sudatalkService.removeComment(commentNo);
		
		// Response
		AP0009 resAP = new AP0009();
		if(isComment)
			resAP.setResultYn("Y");
		else
			resAP.setResultYn("N");
		aps.add(resAP);
		APICode<AP0009> resCode = this.<AP0009>processCommonResponse(reqCode, aps);
		return resCode;
	}
	
	public <T> APICode<T> processCommonResponse(APICode reqCode, ArrayList<T> aps){
		// post Response
		APICode<T> resCode = new APICode<T>();
		resCode.setTranCd(reqCode.getTranCd());
		resCode.setTranData(aps);
		return resCode;
	}
}
