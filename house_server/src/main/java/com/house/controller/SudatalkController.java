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
import com.house.util.BeanUtils;
import com.house.util.JacksonUtils;

@Controller
public class SudatalkController {
	@Autowired
	SudatalkService sudatalkService;
	
	@RequestMapping(value = "/add/sudatalk", method = RequestMethod.POST)
	public @ResponseBody
	Data addSudatalk(@RequestBody Data data) {
		HashMap<String, Object> body = data.body;

		Sudatalk sudatalk =  JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("sudatalk")), Sudatalk.class);
		TransferMultipartFile[] multipartFiles = JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("imgs")),
				TransferMultipartFile[].class);
		Attach[] attachs = new Attach[multipartFiles.length];
		for(int i=0; i<attachs.length; i++){
			Attach attach = new Attach();
			attach.setTransferMultipartFile(multipartFiles[i]);
			attachs[i] = attach;
		}
//		try {
//			System.out.println(BeanUtils.getBeanGetValue(sudatalk));
//			
//			for(TransferMultipartFile multipartFile : multipartFiles){
//				System.out.println(BeanUtils.getBeanGetValue(multipartFile));
//			}
//			System.out.println("test");
//		} catch(Exception e){
//			e.printStackTrace();
//		}
		System.out.println("status : " + sudatalkService.addSudatalk(sudatalk, attachs));
		
		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
	
	@RequestMapping(value = "/modify/sudatalk", method = RequestMethod.POST)
	public @ResponseBody
	Data modifySudatalk(@RequestBody Data data) {
		HashMap<String, Object> body = data.body;

		Sudatalk sudatalk =  JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("sudatalk")), Sudatalk.class);
		TransferMultipartFile[] multipartFiles = JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("imgs")),
				TransferMultipartFile[].class);
		Attach[] attachs = new Attach[multipartFiles.length];
		for(int i=0; i<attachs.length; i++){
			Attach attach = new Attach();
			attach.setTransferMultipartFile(multipartFiles[i]);
			attachs[i] = attach;
		}
//		try {
//			System.out.println(BeanUtils.getBeanGetValue(sudatalk));
//			
//			for(TransferMultipartFile multipartFile : multipartFiles){
//				System.out.println(BeanUtils.getBeanGetValue(multipartFile));
//			}
//			System.out.println("test");
//		} catch(Exception e){
//			e.printStackTrace();
//		}
		System.out.println("status : " + sudatalkService.modifySudatalk(sudatalk, attachs));
		
		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
	
	@RequestMapping(value = "/remove/sudatalk", method = RequestMethod.POST)
	public @ResponseBody
	Data removeSudatalk(@RequestParam("sno") long talkNo) {
		boolean isSudatalk = false;
		
		isSudatalk = sudatalkService.removeSudatalk(talkNo);
		
		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
	
	@RequestMapping(value = "/get/sudatalk", method = RequestMethod.POST)
	public @ResponseBody
	Data getSudatalkByNo(@RequestParam("sno") long talkNo) {
		Sudatalk sudatalk = sudatalkService.getSudatalkByNo(talkNo);
//		try {
//			System.out.println(BeanUtils.getBeanGetValue(sudatalk));
//		} catch(Exception e){
//			e.printStackTrace();
//		}
		Data responseData = new Data();
		responseData.body.put("sudatalk", sudatalk);
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
}
