package com.house.service.impl;

import com.house.mapper.APMapper;
import com.house.model.APICode;
import com.house.model.Attach;
import com.house.model.Comment;
import com.house.model.Interior;
import com.house.model.Like;
import com.house.model.Scrap;
import com.house.model.Sudatalk;
import com.house.model.TransferMultipartFile;
import com.house.model.User;
import com.house.model.code.AP0001;
import com.house.model.code.AP0001.AP0001Img;
import com.house.model.code.AP0001.AP0001Res;
import com.house.model.code.AP0003;
import com.house.model.code.AP0003.AP0003Comment;
import com.house.model.code.AP0004;
import com.house.model.code.AP0005;
import com.house.model.code.AP0006;
import com.house.model.code.AP0007;
import com.house.model.code.AP0008;
import com.house.model.code.AP0009;
import com.house.model.code.AP0010;
import com.house.service.APService;
import com.house.service.FileService;
import com.house.service.InteriorService;
import com.house.service.SudatalkService;
import com.house.service.TokenService;
import com.house.service.UserService;
import com.house.util.DateUtils;
import com.house.util.JacksonUtils;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("apService")
public class APServiceImpl implements APService {
	@Autowired
	APMapper apMapper;
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

	public APICode responseAP0001(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap) reqCode.getTranData()
				.get(0);
		AP0001 ap = (AP0001) JacksonUtils
				.hashMapToObject(hashMap, AP0001.class);
		ArrayList<AP0001> aps = new ArrayList();

		int type = ap.getType();
		int poType = ap.getReqPoType();
		int srcType = 0;
		String usrId = ap.getUsrId();
		boolean upAndDown = ap.getReqPoCnt() >= 0;
		int reqPoCnt = Math.abs(ap.getReqPoCnt());

		List<AP0001.AP0001Res> res = new ArrayList();

		System.out.println("AP0001 + " + ap.getReqPoNo());
		if (1 == type) {
			srcType = 2;
			AP0001.AP0001Res[] datas = this.apMapper.getInteriorAP0001Res(
					ap.getReqPoNo(), srcType, 1, reqPoCnt, poType, usrId,
					upAndDown);
			res = Arrays.asList(datas);
		} else if (2 == type) {
			srcType = 3;
			AP0001.AP0001Res[] datas = this.apMapper.getSudatalkAP0001Res(
					ap.getReqPoNo(), srcType, 1, reqPoCnt, poType, usrId,
					upAndDown);
			res = Arrays.asList(datas);
		}
		if (res.size() > 0) {
			ap.setResCnt(res.size());
			for (int i = 0; i < ap.getResCnt(); i++) {
				Attach[] attachs = this.fileService.getAttachByNoType(
						((AP0001.AP0001Res) res.get(i)).brdNo, srcType);
				ArrayList<AP0001.AP0001Img> imgs = new ArrayList();
				for (int j = 0; j < attachs.length; j++) {
					AP0001.AP0001Img img = new AP0001.AP0001Img();
					img.brdOriginImg = attachs[j].getExUrl();
					img.brdThumbImg = attachs[j].getExThumUrl();
					imgs.add(img);
				}
				((AP0001.AP0001Res) res.get(i)).brdImg = imgs;
			}
			ap.setRes(res);
			ap.setResDate(DateUtils.currentTime(DateUtils.dateForm1));
			ap.setResLastNo(((AP0001.AP0001Res) res.get(ap.getResCnt() - 1)).brdNo);
		}
		AP0001 resAP = ap;
		aps.add(resAP);

		APICode<AP0001> resCode = processCommonResponse(reqCode, aps);
		return resCode;
	}

	public APICode responseAP0002(APICode reqCode) {
		return null;
	}

	public APICode responseAP0003(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap) reqCode.getTranData()
				.get(0);
		AP0003 ap = (AP0003) JacksonUtils
				.hashMapToObject(hashMap, AP0003.class);
		ArrayList<AP0003> aps = new ArrayList();

		int type = ap.getType();
		int srcType = 0;
		long articleId = ap.getReqPoNo();
		long commentNo = ap.getReqCommentNo();
		int commentCnt = ap.getReqCommentCnt();
		User user = this.userService.getUserById(ap.getUsrId());

		Comment[] comments = null;

		AP0003 resAP = null;
		if (1 == type) {
			srcType = 2;
			resAP = this.apMapper.getInteriorAP0003(articleId, srcType, 1);
			comments = this.interiorService.getCommentBySrcNo(articleId, 1,
					commentNo, commentCnt);
		} else if (2 == type) {
			srcType = 3;
			resAP = this.apMapper.getSudatalkAP0003(articleId, srcType, 1);
			comments = this.sudatalkService.getCommentBySrcNo(articleId, 1,
					commentNo, commentCnt);
		}
		if (commentNo != 0L) {
			resAP.setBrdContents(null);
		}
		if (resAP != null) {
			long lastNo = 0L;
			int likeState = this.userService.getLikeByNoType(user.getUsrNo(),
					articleId, srcType) == null ? 0 : 1;
			int scrapState = this.userService.getScrapByNoType(user.getUsrNo(),
					articleId, srcType) == null ? 0 : 1;

			resAP.setBrdLikeState(likeState);
			resAP.setBrdScrapState(scrapState);

			ArrayList<AP0003.AP0003Comment> apComments = new ArrayList();
			for (int i = 0; (comments != null) && (i < comments.length); i++) {
				AP0003.AP0003Comment comment = new AP0003.AP0003Comment();
				comment.brdCommentNo = comments[i].getCommentNo();
				comment.brdCommentCreated = comments[i].getCreated();
				comment.brdCommentId = comments[i].getUsrId();
				comment.brdCommentProfileImg = comments[i].getProfileImg();
				comment.brdCommentNm = comments[i].getUsrNm();
				comment.brdCommentContents = comments[i].getContents();
				lastNo = comments[i].getCommentNo();
				apComments.add(comment);
			}
			resAP.setBrdComment(apComments);
			resAP.setBrdCommentCnt(apComments.size());
			resAP.setBrdCommentLastNo(lastNo);

			ArrayList<String> imgs = new ArrayList();
			Attach[] attachs = this.fileService.getAttachByNoType(articleId,
					srcType);
			for (int i = 0; (attachs != null) && (i < attachs.length); i++) {
				imgs.add(attachs[i].getExUrl());
			}
			resAP.setBrdImg(imgs);
		} else {
			resAP = new AP0003();
		}
		aps.add(resAP);
		APICode<AP0003> resCode = processCommonResponse(reqCode, aps);
		return resCode;
	}

	public APICode responseAP0004(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap) reqCode.getTranData()
				.get(0);
		AP0004 ap = (AP0004) JacksonUtils
				.hashMapToObject(hashMap, AP0004.class);
		ArrayList<AP0004> aps = new ArrayList();

		int type = ap.getType();
		int srcType = 0;
		int cateNo = ap.getCateNo();
		long articleNo = ap.getBrdNo();
		long usrNo = this.userService.getUserById(ap.getUsrId()).getUsrNo();
		boolean isLike = false;
		Like like = null;
		if (1 == type) {
			like = this.userService.getLikeByNoType(usrNo, articleNo, 2);
			srcType = 2;
		} else if (2 == type) {
			like = this.userService.getLikeByNoType(usrNo, articleNo, 3);
			srcType = 3;
		}
		if (like != null) {
			isLike = this.userService.removeLike(like.getLikeNo());
		} else {
			like = new Like();
			like.setSrcNo(articleNo);
			like.setUsrNo(usrNo);
			like.setSrcType(srcType);
			like.setCateNo(cateNo);
			isLike = this.userService.addLike(like);
		}
		AP0004 resAP = new AP0004();
		resAP.setLikeCnt(this.userService.getLikeCount(articleNo, srcType));
		if (isLike) {
			resAP.setResultYn("Y");
		} else {
			resAP.setResultYn("N");
		}
		aps.add(resAP);
		APICode<AP0004> resCode = processCommonResponse(reqCode, aps);
		return resCode;
	}

	public APICode responseAP0005(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap) reqCode.getTranData()
				.get(0);
		AP0005 ap = (AP0005) JacksonUtils
				.hashMapToObject(hashMap, AP0005.class);
		ArrayList<AP0005> aps = new ArrayList();

		int type = ap.getType();
		int srcType = 0;
		int cateNo = ap.getCateNo();
		long articleNo = ap.getBrdNo();
		long usrNo = this.userService.getUserById(ap.getUsrId()).getUsrNo();
		boolean isScrap = false;
		Scrap scrap = null;
		if (1 == type) {
			scrap = this.userService.getScrapByNoType(usrNo, articleNo, 2);
			srcType = 2;
		} else if (2 == type) {
			scrap = this.userService.getScrapByNoType(usrNo, articleNo, 3);
			srcType = 3;
		}
		if (scrap != null) {
			isScrap = this.userService.removeScrap(scrap.getScrapNo());
		} else {
			scrap = new Scrap();
			scrap.setSrcNo(articleNo);
			scrap.setUsrNo(usrNo);
			scrap.setSrcType(srcType);
			scrap.setCateNo(cateNo);
			isScrap = this.userService.addScrap(scrap);
		}
		AP0005 resAP = new AP0005();
		resAP.setScrapCnt(this.userService.getScrapCount(articleNo, srcType));
		if (isScrap) {
			resAP.setResultYn("Y");
		} else {
			resAP.setResultYn("N");
		}
		aps.add(resAP);
		APICode<AP0005> resCode = processCommonResponse(reqCode, aps);
		return resCode;
	}

	public APICode responseAP0006(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap) reqCode.getTranData()
				.get(0);
		AP0006 ap = (AP0006) JacksonUtils
				.hashMapToObject(hashMap, AP0006.class);
		ArrayList<AP0006> aps = new ArrayList();

		int type = ap.getType();
		long articleId = ap.getBrdNo();
		Interior interior = null;
		Sudatalk sudatalk = null;
		Attach[] attachs = null;
		User user = this.userService.getUserById(ap.getBrdId());
		boolean isArticle = false;
		if (1 == type) {
			interior = new Interior();
			interior.setInteriorNo(articleId);
			interior.setUsrNo(user.getUsrNo());
			interior.setSubject(ap.getBrdSubject());
			interior.setContents(ap.getBrdContents());
			interior.setCateCd(ap.getBrdCateNo());
			interior.setTagNm(ap.getBrdTag());

			isArticle = interior.getInteriorNo() == 0L ? this.interiorService
					.addInterior(interior, attachs) : this.interiorService
					.modifyInterior(interior, attachs);
		} else if (2 == type) {
			sudatalk = new Sudatalk();
			sudatalk.setTalkNo(articleId);
			sudatalk.setUsrNo(user.getUsrNo());
			sudatalk.setSubject(ap.getBrdSubject());
			sudatalk.setContents(ap.getBrdContents());
			sudatalk.setTagNm(ap.getBrdTag());
			sudatalk.setCateCd(ap.getBrdCateNo());

			isArticle = sudatalk.getTalkNo() == 0L ? this.sudatalkService
					.addSudatalk(sudatalk, attachs) : this.sudatalkService
					.modifySudatalk(sudatalk, attachs);
		}
		AP0006 resAP = new AP0006();
		if (isArticle) {
			resAP.setResultYn("Y");
		} else {
			resAP.setResultYn("N");
		}
		if (1 == type) {
			resAP.setBrdNo(interior.getInteriorNo());
		} else {
			resAP.setBrdNo(sudatalk.getTalkNo());
		}
		aps.add(resAP);
		APICode<AP0006> resCode = processCommonResponse(reqCode, aps);
		return resCode;
	}

	public APICode responseAP0010(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap) reqCode.getTranData()
				.get(0);
		AP0010 ap = (AP0010) JacksonUtils
				.hashMapToObject(hashMap, AP0010.class);
		ArrayList<AP0010> aps = new ArrayList();

		int type = ap.getType();
		Attach attach = null;
		User user = this.userService.getUserById(ap.getBrdId());
		boolean isAttach = false;

		attach = new Attach();

		TransferMultipartFile mf = new TransferMultipartFile(
				ap.getImgOriginNm(), ap.getImgNm(), ap.getImgContent(),
				ap.getImgType(), ap.getImgSize(), false);
		attach.setTransferMultipartFile(mf);
		attach.setUploadUsr(user.getUsrNo());
		if (1 == type) {
			attach.setSrcType(2);
		} else {
			attach.setSrcType(3);
		}
		attach.setSrcNo(ap.getBrdNo());

		isAttach = this.fileService.addAttach(attach);

		AP0010 resAP = new AP0010();
		if (isAttach) {
			resAP.setResultYn("Y");
		} else {
			resAP.setResultYn("N");
		}
		aps.add(resAP);
		APICode<AP0010> resCode = processCommonResponse(reqCode, aps);
		return resCode;
	}

	public APICode responseAP0007(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap) reqCode.getTranData()
				.get(0);
		AP0007 ap = (AP0007) JacksonUtils
				.hashMapToObject(hashMap, AP0007.class);
		ArrayList<AP0007> aps = new ArrayList();

		int type = ap.getType();
		long articleNo = ap.getBrdNo();
		boolean isArticle = false;
		if (1 == type) {
			isArticle = this.interiorService.removeInterior(articleNo);
		} else if (2 == type) {
			isArticle = this.sudatalkService.removeSudatalk(articleNo);
		}
		AP0007 resAP = new AP0007();
		if (isArticle) {
			resAP.setResultYn("Y");
		} else {
			resAP.setResultYn("N");
		}
		aps.add(resAP);
		APICode<AP0007> resCode = processCommonResponse(reqCode, aps);
		return resCode;
	}

	public APICode responseAP0008(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap) reqCode.getTranData()
				.get(0);
		AP0008 ap = (AP0008) JacksonUtils
				.hashMapToObject(hashMap, AP0008.class);
		ArrayList<AP0008> aps = new ArrayList();

		int type = ap.getType();
		long articleNo = ap.getReqPoNo();
		long usrNo = this.userService.getUserById(ap.getCommentId()).getUsrNo();
		long commentNo = ap.getCommentNo();
		boolean isComment = false;

		Comment comment = new Comment();
		if ((commentNo != 0L) && (1 == type)) {
			comment = this.interiorService.getCommentByNo(commentNo, 1);
		} else if ((commentNo != 0L) && (2 == type)) {
			comment = this.sudatalkService.getCommentByNo(commentNo, 1);
		}
		comment.setSrcNo(articleNo);
		comment.setUsrNo(usrNo);
		comment.setContents(ap.getCommentContents());
		if (1 == type) {
			isComment = comment.getCommentNo() == 0L ? this.interiorService
					.addComment(comment) : this.interiorService
					.modifyComment(comment);
		} else if (2 == type) {
			isComment = comment.getCommentNo() == 0L ? this.sudatalkService
					.addComment(comment) : this.sudatalkService
					.modifyComment(comment);
		}
		AP0008 resAP = new AP0008();
		if (isComment) {
			resAP.setResultYn("Y");
		} else {
			resAP.setResultYn("N");
		}
		aps.add(resAP);
		APICode<AP0008> resCode = processCommonResponse(reqCode, aps);
		return resCode;
	}

	public APICode responseAP0009(APICode reqCode) {
		HashMap<String, String> hashMap = (HashMap) reqCode.getTranData()
				.get(0);
		AP0009 ap = (AP0009) JacksonUtils
				.hashMapToObject(hashMap, AP0009.class);
		ArrayList<AP0009> aps = new ArrayList();

		int type = ap.getType();
		long usrNo = this.userService.getUserById(ap.getCommentId()).getUsrNo();
		long commentNo = ap.getCommentNo();
		boolean isComment = false;
		if (1 == type) {
			isComment = this.interiorService.removeComment(commentNo);
		} else if (2 == type) {
			isComment = this.sudatalkService.removeComment(commentNo);
		}
		AP0009 resAP = new AP0009();
		if (isComment) {
			resAP.setResultYn("Y");
		} else {
			resAP.setResultYn("N");
		}
		aps.add(resAP);
		APICode<AP0009> resCode = processCommonResponse(reqCode, aps);
		return resCode;
	}

	public <T> APICode<T> processCommonResponse(APICode reqCode,
			ArrayList<T> aps) {
		APICode<T> resCode = new APICode();
		resCode.setTranCd(reqCode.getTranCd());
		resCode.setTranData(aps);
		return resCode;
	}
}
