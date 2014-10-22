package com.house.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.model.Attach;
import com.house.model.Data;
import com.house.model.Interior;
import com.house.model.TransferMultipartFile;
import com.house.service.InteriorService;
import com.house.util.JacksonUtils;

@Controller
public class InteriorController {
	@Autowired
	InteriorService interiorService;

	@RequestMapping(value = { "/add/interior" }, method = { RequestMethod.POST })
	@ResponseBody
	public Data addInterior(@RequestBody Data data) {
		HashMap<String, Object> body = data.body;

		Interior interior = (Interior) JacksonUtils
				.jsonToObject(JacksonUtils.objectToJson(body.get("interior")),
						Interior.class);
		TransferMultipartFile[] multipartFiles = (TransferMultipartFile[]) JacksonUtils
				.jsonToObject(JacksonUtils.objectToJson(body.get("imgs")),
						TransferMultipartFile[].class);
		Attach[] attachs = new Attach[multipartFiles.length];
		for (int i = 0; i < attachs.length; i++) {
			Attach attach = new Attach();
			attach.setTransferMultipartFile(multipartFiles[i]);
			attachs[i] = attach;
		}
		System.out.println("status : "
				+ this.interiorService.addInterior(interior, attachs));

		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}

	@RequestMapping(value = { "/modify/interior" }, method = { RequestMethod.POST })
	@ResponseBody
	public Data modifyInterior(@RequestBody Data data) {
		HashMap<String, Object> body = data.body;

		Interior interior = (Interior) JacksonUtils
				.jsonToObject(JacksonUtils.objectToJson(body.get("interior")),
						Interior.class);
		TransferMultipartFile[] multipartFiles = (TransferMultipartFile[]) JacksonUtils
				.jsonToObject(JacksonUtils.objectToJson(body.get("imgs")),
						TransferMultipartFile[].class);
		Attach[] attachs = new Attach[multipartFiles.length];
		for (int i = 0; i < attachs.length; i++) {
			Attach attach = new Attach();
			attach.setTransferMultipartFile(multipartFiles[i]);
			attachs[i] = attach;
		}
		System.out.println("status : "
				+ this.interiorService.modifyInterior(interior, attachs));

		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}

	@RequestMapping(value = { "/remove/interior" }, method = { RequestMethod.POST })
	@ResponseBody
	public Data removeInterior(@RequestParam("ino") long interiorNo) {
		System.out.println("status : "
				+ this.interiorService.removeInterior(interiorNo));

		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}

	@RequestMapping(value = { "/get/interior" }, method = { RequestMethod.POST })
	@ResponseBody
	public Data getInteriorByNo(@RequestParam("ino") long interiorNo) {
		Interior interior = this.interiorService.getInteriorByNo(interiorNo);

		Data responseData = new Data();
		responseData.body.put("interior", interior);
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
}
