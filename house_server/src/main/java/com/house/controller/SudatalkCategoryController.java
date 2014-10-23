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
import com.house.model.InteriorCategory;
import com.house.model.Sudatalk;
import com.house.model.SudatalkCategory;
import com.house.model.TransferMultipartFile;
import com.house.service.SudatalkService;
import com.house.util.BeanUtils;
import com.house.util.JacksonUtils;

@Controller
public class SudatalkCategoryController {
	@Autowired
	SudatalkService sudatalkService;
	
	@RequestMapping(value = "/add/sudatalkcategory", method = RequestMethod.POST)
	public @ResponseBody
	Data addSudatalkCategory(@RequestBody Data data) {
		HashMap<String, Object> body = data.body;

		SudatalkCategory sudatalkCategory =  JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("sudatalkcategory")), SudatalkCategory.class);
		
		System.out.println("status : " + sudatalkService.addSudatalkCategory(sudatalkCategory));
		
		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
	
	@RequestMapping(value = "/modify/sudatalkcategory", method = RequestMethod.POST)
	public @ResponseBody
	Data modifySudatalkCategory(@RequestBody Data data) {
		HashMap<String, Object> body = data.body;

		SudatalkCategory sudatalkCategory =  JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("sudatalkcategory")), SudatalkCategory.class);
		
		System.out.println("status : " + sudatalkService.modifySudatalkCategory(sudatalkCategory));
		
		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
	
	@RequestMapping(value = "/remove/sudatalkcategory", method = RequestMethod.POST)
	public @ResponseBody
	Data removeSudatalkCategory(@RequestParam("scno") int cateNo) {
		System.out.println("status : " + sudatalkService.removeSudatalkCategory(cateNo));
		
		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
	
	@RequestMapping(value = "/get/sudatalkcategory", method = RequestMethod.POST)
	public @ResponseBody
	Data getSudatalkCategoryByNo(@RequestParam("scno") int cateNo) {
		SudatalkCategory sudatalkcategory = sudatalkService.getSudatalkCategoryByNo(cateNo);
//		try {
//			System.out.println(BeanUtils.getBeanGetValue(sudatalkcategory));
//		} catch(Exception e){
//			e.printStackTrace();
//		}
		Data responseData = new Data();
		responseData.body.put("sudatalkcategory", sudatalkcategory);
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
}
