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
import com.house.model.Sudatalk;
import com.house.model.TransferMultipartFile;
import com.house.service.SudatalkService;
import com.house.util.JacksonUtils;

@Controller
public class SudatalkController {
	@Autowired
	SudatalkService sudatalkService;

	@RequestMapping(value = { "/add/sudatalk" }, method = { RequestMethod.POST })
	@ResponseBody
	public Data addSudatalk(@RequestBody Data data) {
		HashMap<String, Object> body = data.body;

		Sudatalk sudatalk = (Sudatalk) JacksonUtils
				.jsonToObject(JacksonUtils.objectToJson(body.get("sudatalk")),
						Sudatalk.class);
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
				+ this.sudatalkService.addSudatalk(sudatalk, attachs));

		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}

	@RequestMapping(value = { "/modify/sudatalk" }, method = { RequestMethod.POST })
	@ResponseBody
	public Data modifySudatalk(@RequestBody Data data) {
		HashMap<String, Object> body = data.body;

		Sudatalk sudatalk = (Sudatalk) JacksonUtils
				.jsonToObject(JacksonUtils.objectToJson(body.get("sudatalk")),
						Sudatalk.class);
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
				+ this.sudatalkService.modifySudatalk(sudatalk, attachs));

		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}

	@RequestMapping(value = { "/remove/sudatalk" }, method = { RequestMethod.POST })
	@ResponseBody
	public Data removeSudatalk(@RequestParam("sno") long talkNo) {
		boolean isSudatalk = false;

		isSudatalk = this.sudatalkService.removeSudatalk(talkNo);

		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}

	@RequestMapping(value = { "/get/sudatalk" }, method = { RequestMethod.POST })
	@ResponseBody
	public Data getSudatalkByNo(@RequestParam("sno") long talkNo) {
		Sudatalk sudatalk = this.sudatalkService.getSudatalkByNo(talkNo);

		Data responseData = new Data();
		responseData.body.put("sudatalk", sudatalk);
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
}
