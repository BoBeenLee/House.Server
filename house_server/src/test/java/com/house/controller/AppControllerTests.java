package com.house.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.house.model.APICode;
import com.house.model.CodeType;
import com.house.model.TransferMultipartFile;
import com.house.model.reqcode.*;
import com.house.util.JacksonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
public class AppControllerTests extends AbstractContextControllerTests {
	private MockMvc mockMvc;

	@Autowired
	Environment environment;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(
				status().isOk()).build();
	}
//	로그인
//	@Test
	public void CM0001() throws Exception{
		APICode<CM0001> reqCode = this.<CM0001>processCommonOne("CM0001");
		
		CM0001 cm = new CM0001();
		cm.setUsrId("id1");
		cm.setUsrPw("pw1");
		
		reqCode.getTranData().add(cm);
		System.out.println(JacksonUtils.<APICode<CM0001>>objectToJson(reqCode));
		
		this.mockMvc
				.perform(
						post("/house/CM0001.app?token=sdfdsfs").contentType(
								MediaType.APPLICATION_JSON).content(
										JacksonUtils.<APICode<CM0001>>objectToJson(reqCode).getBytes()))
				.andDo(print());
	}
//	회원가입
//	@Test
	public void CM0003() throws Exception{
		APICode<CM0003> reqCode = this.<CM0003>processCommonOne("CM0003");
		CM0003 cm = new CM0003();
		
		cm.setUsrId("id1");
		cm.setUsrPw("pw1");
		cm.setCustName("Lee");
		cm.setTermsYN("Y");
		cm.setPsPlatform("and");
		cm.setPsId("psId");
		cm.setPsRevokeYN("N");
		cm.setPsAppVer("1.0");
		cm.setDeviceNM("kitkat");
		cm.setUsrSts(1);
		
		CM0003.CM0003Img img = new CM0003.CM0003Img();
		TransferMultipartFile mf = getFile();
		img.imgNm = img.imgOriginNm = mf.getName();
		img.imgSize = mf.getSize();
		img.imgType = mf.getContentType();
		img.imgContent = mf.getContent();
		
		cm.setUsrImg(img);
		
		reqCode.getTranData().add(cm);
		System.out.println(JacksonUtils.objectToJson(reqCode));
		
		this.mockMvc
		.perform(
				post("/house/CM0003.app?token=sdfdsfs").contentType(
						MediaType.APPLICATION_JSON).content(
								JacksonUtils.<APICode<CM0003>>objectToJson(reqCode).getBytes()))
		.andDo(print());
	}
//	회원탈퇴
//	@Test
	public void CM0004() throws Exception{
		APICode<CM0004> reqCode = this.<CM0004>processCommonOne("CM0004");
		CM0004 cm = new CM0004();
		
		cm.setUsrId("id1");
		cm.setUsrPw("pw1");
		
		reqCode.getTranData().add(cm);
		System.out.println(JacksonUtils.objectToJson(reqCode));
		
		this.mockMvc
		.perform(
				post("/house/CM0004.app?token=sdfdsfs").contentType(
						MediaType.APPLICATION_JSON).content(
								JacksonUtils.<APICode<CM0004>>objectToJson(reqCode).getBytes()))
		.andDo(print());
	}
//	프로필조회
//	@Test
	public void CM0005() throws Exception{
		APICode<CM0005> reqCode = this.<CM0005>processCommonOne("CM0005");
		CM0005 cm = new CM0005();
		
		cm.setUsrId("id1");
		cm.setUsrPw("pw1");
		
		reqCode.getTranData().add(cm);
		System.out.println(JacksonUtils.objectToJson(reqCode));
		
		this.mockMvc
		.perform(
				post("/house/CM0005.app?token=sdfdsfs").contentType(
						MediaType.APPLICATION_JSON).content(
								JacksonUtils.<APICode<CM0005>>objectToJson(reqCode).getBytes()))
		.andDo(print());
	}
//	프로필수정
//	@Test
	public void CM0006() throws Exception{
		APICode<CM0006> reqCode = this.<CM0006>processCommonOne("CM0006");
		CM0006 cm = new CM0006();
		
		cm.setUsrId("id1");
		cm.setUsrPw("pw1");
		cm.setCustName("Su");
		cm.setUsrSts(2);
		
		CM0006.CM0006Img img = new CM0006.CM0006Img();
		TransferMultipartFile mf = getFile();
		img.imgNm = img.imgOriginNm = "test" + mf.getName();
		img.imgSize = mf.getSize();
		img.imgType = mf.getContentType();
		img.imgContent = mf.getContent();
		cm.setUsrImg(img);
		
		reqCode.getTranData().add(cm);
		System.out.println(JacksonUtils.objectToJson(reqCode));
		
		this.mockMvc
		.perform(
				post("/house/CM0006.app?token=sdfdsfs").contentType(
						MediaType.APPLICATION_JSON).content(
								JacksonUtils.<APICode<CM0006>>objectToJson(reqCode).getBytes()))
		.andDo(print());
	}
//	페이지 조회
//	@Test
	public void AP0001() throws Exception{
		APICode<AP0001> reqCode = this.<AP0001>processCommonOne("AP0001");
		AP0001 ap = new AP0001();
		
		ap.setType(CodeType.INTERIOR_TYPE);
		ap.setOrderType("new");
		ap.setReqPo(0);
		ap.setReqPoCnt(3);
		ap.setReqPoNo(0);
		
		reqCode.getTranData().add(ap);
		System.out.println(JacksonUtils.objectToJson(reqCode));
		this.mockMvc
		.perform(
				post("/house/AP0001.app?token=sdfdsfs").contentType(
						MediaType.APPLICATION_JSON).content(
								JacksonUtils.<APICode<AP0001>>objectToJson(reqCode).getBytes()))
		.andDo(print());
	}
//	글 조회
//	@Test
	public void AP0003() throws Exception{
		APICode<AP0003> reqCode = this.<AP0003>processCommonOne("AP0003");
		AP0003 ap = new AP0003();
		
		ap.setType(CodeType.INTERIOR_TYPE);
		ap.setReqPoNo(2014083122170900001L);
		ap.setUsrId("id1");
		
		reqCode.getTranData().add(ap);
		System.out.println(JacksonUtils.objectToJson(reqCode));
		this.mockMvc
		.perform(
				post("/house/AP0003.app?token=sdfdsfs").contentType(
						MediaType.APPLICATION_JSON).content(
								JacksonUtils.<APICode<AP0003>>objectToJson(reqCode).getBytes()))
		.andDo(print());
	}
// 스크랩 
//	@Test
	public void AP0005() throws Exception{
		APICode<AP0005> reqCode = this.<AP0005>processCommonOne("AP0005");
		AP0005 ap = new AP0005();
		
		ap.setType(CodeType.INTERIOR_TYPE);
		ap.setUsrId("id1");
		ap.setBrdNo(2014083015244700001L);
		
		reqCode.getTranData().add(ap);
		System.out.println(JacksonUtils.objectToJson(reqCode));
		
		this.mockMvc
		.perform(
				post("/house/AP0005.app?token=sdfdsfs").contentType(
						MediaType.APPLICATION_JSON).content(
								JacksonUtils.<APICode<AP0005>>objectToJson(reqCode).getBytes()))
		.andDo(print());
	}
	
//	좋아요 
//	@Test
	public void AP0004() throws Exception{
		APICode<AP0004> reqCode = this.<AP0004>processCommonOne("AP0004");
		AP0004 ap = new AP0004();
		
		ap.setType(CodeType.INTERIOR_TYPE);
		ap.setUsrId("id1");
		ap.setBrdNo(2014082915392200001L);
		
		reqCode.getTranData().add(ap);
		System.out.println(JacksonUtils.objectToJson(reqCode));
		
		this.mockMvc
		.perform(
				post("/house/AP0004.app?token=sdfdsfs").contentType(
						MediaType.APPLICATION_JSON).content(
								JacksonUtils.<APICode<AP0004>>objectToJson(reqCode).getBytes()))
		.andDo(print());
	}
	
//	글 삭제
//	@Test
	public void AP0007() throws Exception{
		APICode<AP0007> reqCode = this.<AP0007>processCommonOne("AP0007");
		AP0007 ap = new AP0007();
		
		ap.setType(CodeType.INTERIOR_TYPE);
		ap.setBrdNo(2014083010521700001L);
		ap.setBrdId("id1");
		
		reqCode.getTranData().add(ap);
		System.out.println(JacksonUtils.objectToJson(reqCode));
		
		this.mockMvc
		.perform(
				post("/house/AP0007.app?token=sdfdsfs").contentType(
						MediaType.APPLICATION_JSON).content(
								JacksonUtils.<APICode<AP0007>>objectToJson(reqCode).getBytes()))
		.andDo(print());
	}
	
//	글 쓰기
//	@Test
	public void AP0006() throws Exception{
		APICode<AP0006> reqCode = this.<AP0006>processCommonOne("AP0006");
		AP0006 ap = new AP0006();
		
//		ap.setReqPoNo(2014082912133000001L);
		ap.setType(CodeType.INTERIOR_TYPE);
		ap.setBrdId("id1");
		ap.setBrdSubject("TitleModify");
		ap.setBrdContents("Hello".getBytes());
		ap.setBrdTag("asdf,adfas");
		
		ArrayList<AP0006.AP0006Img> al = new ArrayList<AP0006.AP0006Img>();
		
		for(int i=0; i<10; i++){
			AP0006.AP0006Img img = new AP0006.AP0006Img();
			
			TransferMultipartFile mf = getFile();
			img.imgNm = img.imgOriginNm = mf.getName();
			img.imgSize = mf.getSize();
			img.imgType = mf.getContentType();
			img.imgContent = mf.getContent();
			al.add(img);
		}
		ap.setBrdImg(al);
		
		reqCode.getTranData().add(ap);
		
		System.out.println(JacksonUtils.objectToJson(reqCode));
		
		this.mockMvc
		.perform(
				post("/house/AP0006.app?token=sdfdsfs").contentType(
						MediaType.APPLICATION_JSON).content(
								JacksonUtils.<APICode<AP0006>>objectToJson(reqCode).getBytes()))
		.andDo(print());
	}
	
//	댓글쓰기
//	@Test
	public void AP0008() throws Exception{
		APICode<AP0008> reqCode = this.<AP0008>processCommonOne("AP0008");
		AP0008 ap = new AP0008();
		
		ap.setType(CodeType.INTERIOR_TYPE);
//		ap.setCommentNo(2014083009220100001L);
		ap.setReqPoNo(2014083107354500001L);
		ap.setCommentId("id1");
		ap.setCommentContents("dddddsfdsHelloWorl11d!".getBytes());
		
		reqCode.getTranData().add(ap);
		System.out.println(JacksonUtils.objectToJson(reqCode));
		
		this.mockMvc
		.perform(
				post("/house/AP0008.app?token=sdfdsfs").contentType(
						MediaType.APPLICATION_JSON).content(
								JacksonUtils.<APICode<AP0008>>objectToJson(reqCode).getBytes()))
		.andDo(print());
	}
	
//	댓글삭제
//	@Test
	public void AP0009() throws Exception{
		APICode<AP0009> reqCode = this.<AP0009>processCommonOne("AP0009");
		AP0009 ap = new AP0009();
		
		ap.setType(CodeType.INTERIOR_TYPE);
		ap.setCommentId("id1");
		ap.setCommentNo(2014083009220100001L);
		
		reqCode.getTranData().add(ap);
		System.out.println(JacksonUtils.objectToJson(reqCode));
		
		this.mockMvc
		.perform(
				post("/house/AP0009.app?token=sdfdsfs").contentType(
						MediaType.APPLICATION_JSON).content(
								JacksonUtils.<APICode<AP0009>>objectToJson(reqCode).getBytes()))
		.andDo(print());
	}
	
	public <T> APICode processCommonOne(String tranCd){
		APICode<T> reqCode = new APICode<T>();
		reqCode.setTranCd(tranCd);
		List<T> cms = new ArrayList<T>();
		reqCode.setTranData(cms);
		
		return reqCode;
	}
	
	public TransferMultipartFile getFile(){
		// new MockMultipartFile("test.html", "sdfasdsf".getBytes())
		TransferMultipartFile mf = null;
		try {
			mf = new TransferMultipartFile(new MockMultipartFile("test1.html",
					new byte[12000]));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mf;
	}
	
}
