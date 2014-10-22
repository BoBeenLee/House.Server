package com.house.controller;

import com.house.model.APICode;
import com.house.model.TransferMultipartFile;
import com.house.model.reqcode.AP0001;
import com.house.model.reqcode.AP0003;
import com.house.model.reqcode.AP0004;
import com.house.model.reqcode.AP0005;
import com.house.model.reqcode.AP0006;
import com.house.model.reqcode.AP0007;
import com.house.model.reqcode.AP0008;
import com.house.model.reqcode.AP0009;
import com.house.model.reqcode.AP0010;
import com.house.model.reqcode.CM0001;
import com.house.model.reqcode.CM0003;
import com.house.model.reqcode.CM0004;
import com.house.model.reqcode.CM0005;
import com.house.model.reqcode.CM0006;
import com.house.model.reqcode.CM0006.CM0006Img;
import com.house.util.JacksonUtils;
import java.io.IOException;
import java.io.PrintStream;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
public class AppControllerTests extends AbstractContextControllerTests {
	private MockMvc mockMvc;
	@Autowired
	Environment environment;

	@Before
	public void setup() throws Exception {
		this.mockMvc = ((DefaultMockMvcBuilder) MockMvcBuilders
				.webAppContextSetup(this.wac).alwaysExpect(
						MockMvcResultMatchers.status().isOk())).build();
	}

	public void CM0001() throws Exception {
		APICode<CM0001> reqCode = processCommonOne("CM0001");

		CM0001 cm = new CM0001();
		cm.setUsrId("id1");
		cm.setUsrPw("pw1");

		reqCode.getTranData().add(cm);
		System.out.println(JacksonUtils.objectToJson(reqCode));

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/house/CM0001.app?token=sdfdsfs",
										new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(reqCode)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public void CM0003() throws Exception {
		APICode<CM0003> reqCode = processCommonOne("CM0003");
		CM0003 cm = new CM0003();

		cm.setUsrId("cultist_tp@naver1.com");
		cm.setUsrPw("123456");
		cm.setCustName("bobinlee");
		cm.setTermsYN("Y");
		cm.setPsPlatform("and");
		cm.setPsId("psId");
		cm.setPsRevokeYN("N");
		cm.setPsAppVer("1.0");
		cm.setDeviceNM("kitkat");
		cm.setUsrSts(0);

		reqCode.getTranData().add(cm);
		System.out.println(JacksonUtils.objectToJson(reqCode));

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/house/CM0003.app?token=sdfdsfs",
										new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(reqCode)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public void CM0004() throws Exception {
		APICode<CM0004> reqCode = processCommonOne("CM0004");
		CM0004 cm = new CM0004();

		cm.setUsrId("id1");
		cm.setUsrPw("pw1");

		reqCode.getTranData().add(cm);
		System.out.println(JacksonUtils.objectToJson(reqCode));

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/house/CM0004.app?token=sdfdsfs",
										new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(reqCode)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public void CM0005() throws Exception {
		APICode<CM0005> reqCode = processCommonOne("CM0005");
		CM0005 cm = new CM0005();

		cm.setUsrId("id1");

		reqCode.getTranData().add(cm);
		System.out.println(JacksonUtils.objectToJson(reqCode));

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/house/CM0005.app?token=sdfdsfs",
										new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(reqCode)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public void CM0006() throws Exception {
		APICode<CM0006> reqCode = processCommonOne("CM0006");
		CM0006 cm = new CM0006();

		cm.setUsrId("id1");
		cm.setUsrPw("pw1");
		cm.setCustName("Su");
		cm.setUsrSts(2);

		CM0006.CM0006Img img = new CM0006.CM0006Img();
		TransferMultipartFile mf = getFile();
		img.imgNm = (img.imgOriginNm = "test" + mf.getName());
		img.imgSize = mf.getSize();
		img.imgType = mf.getContentType();
		img.imgContent = mf.getContent();
		cm.setUsrImg(img);

		reqCode.getTranData().add(cm);
		System.out.println(JacksonUtils.objectToJson(reqCode));

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/house/CM0006.app?token=sdfdsfs",
										new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(reqCode)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public void AP0001() throws Exception {
		APICode<AP0001> reqCode = processCommonOne("AP0001");
		AP0001 ap = new AP0001();

		ap.setType(1);
		ap.setOrderType("new");
		ap.setReqPo(0);
		ap.setReqPoCnt(3);
		ap.setReqPoNo(0L);
		ap.setReqPoType(2);
		ap.setUsrId("kakao1639451");

		reqCode.getTranData().add(ap);
		System.out.println(JacksonUtils.objectToJson(reqCode));
		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/house/AP0001.app?token=sdfdsfs",
										new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(reqCode)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	@Test
	public void AP0003() throws Exception {
		APICode<AP0003> reqCode = processCommonOne("AP0003");
		AP0003 ap = new AP0003();

		ap.setType(1);
		ap.setReqPoNo(2014091217035900001L);
		ap.setUsrId("cultist_tp@gmail.com");
		ap.setReqCommentCnt(100);
		ap.setReqCommentNo(0L);

		reqCode.getTranData().add(ap);
		System.out.println(JacksonUtils.objectToJson(reqCode));
		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/house/AP0003.app?token=sdfdsfs",
										new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(reqCode)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public void AP0005() throws Exception {
		APICode<AP0005> reqCode = processCommonOne("AP0005");
		AP0005 ap = new AP0005();

		ap.setType(1);
		ap.setUsrId("id1");
		ap.setBrdNo(2014083015244700001L);

		reqCode.getTranData().add(ap);
		System.out.println(JacksonUtils.objectToJson(reqCode));

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/house/AP0005.app?token=sdfdsfs",
										new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(reqCode)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public void AP0004() throws Exception {
		APICode<AP0004> reqCode = processCommonOne("AP0004");
		AP0004 ap = new AP0004();

		ap.setType(1);
		ap.setUsrId("id1");
		ap.setCateNo(1);
		ap.setBrdNo(2014090713460900001L);

		reqCode.getTranData().add(ap);
		System.out.println(JacksonUtils.objectToJson(reqCode));

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/house/AP0004.app?token=sdfdsfs",
										new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(reqCode)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public void AP0007() throws Exception {
		APICode<AP0007> reqCode = processCommonOne("AP0007");
		AP0007 ap = new AP0007();

		ap.setType(1);
		ap.setBrdNo(2014083010521700001L);
		ap.setBrdId("id1");

		reqCode.getTranData().add(ap);
		System.out.println(JacksonUtils.objectToJson(reqCode));

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/house/AP0007.app?token=sdfdsfs",
										new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(reqCode)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public void AP0006() throws Exception {
		APICode<AP0006> reqCode = processCommonOne("AP0006");
		AP0006 ap = new AP0006();

		ap.setType(2);
		ap.setBrdId("id1");
		ap.setBrdSubject("TitleModify");
		ap.setBrdContents("Hello".getBytes());
		ap.setBrdCateNo(1);
		ap.setBrdTag("");

		reqCode.getTranData().add(ap);

		System.out.println(JacksonUtils.objectToJson(reqCode));

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/house/AP0006.app?token=sdfdsfs",
										new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(reqCode)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public void AP0010() throws Exception {
		APICode<AP0010> reqCode = processCommonOne("AP0010");
		AP0010 ap = new AP0010();

		ap.setType(1);
		ap.setBrdId("id1");
		TransferMultipartFile mf = getFile();
		ap.setImgOriginNm(mf.getOriginalFilename());
		ap.setImgNm(mf.getName());
		ap.setImgSize(mf.getSize());
		ap.setImgType(mf.getContentType());
		ap.setImgContent(mf.getContent());

		reqCode.getTranData().add(ap);
		System.out.println(JacksonUtils.objectToJson(reqCode));
		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/house/AP0010.app?token=sdfdsfs",
										new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(reqCode)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public void AP0008() throws Exception {
		APICode<AP0008> reqCode = processCommonOne("AP0008");
		AP0008 ap = new AP0008();

		ap.setType(1);

		ap.setReqPoNo(2014083107354500001L);
		ap.setCommentId("id1");
		ap.setCommentContents("dddddsfdsHelloWorl11d!".getBytes());

		reqCode.getTranData().add(ap);
		System.out.println(JacksonUtils.objectToJson(reqCode));

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/house/AP0008.app?token=sdfdsfs",
										new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(reqCode)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public void AP0009() throws Exception {
		APICode<AP0009> reqCode = processCommonOne("AP0009");
		AP0009 ap = new AP0009();

		ap.setType(1);
		ap.setCommentId("id1");
		ap.setCommentNo(2014083009220100001L);

		reqCode.getTranData().add(ap);
		System.out.println(JacksonUtils.objectToJson(reqCode));

		this.mockMvc
				.perform(
						MockMvcRequestBuilders
								.post("/house/AP0009.app?token=sdfdsfs",
										new Object[0])
								.contentType(MediaType.APPLICATION_JSON)
								.content(
										JacksonUtils.objectToJson(reqCode)
												.getBytes())).andDo(
						MockMvcResultHandlers.print());
	}

	public <T> APICode processCommonOne(String tranCd) {
		APICode<T> reqCode = new APICode();
		reqCode.setTranCd(tranCd);
		List<T> cms = new ArrayList();
		reqCode.setTranData(cms);

		return reqCode;
	}

	public TransferMultipartFile getFile() {
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
