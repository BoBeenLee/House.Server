package com.house.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.model.Data;
import com.house.model.Like;
import com.house.model.Scrap;
import com.house.service.UserService;
import com.house.util.BeanUtils;
import com.house.util.JacksonUtils;

//@Secured("ROLE_USER")
@Controller
public class ScrapController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/add/scrap", method = RequestMethod.POST)
	public @ResponseBody
	Data addScrap(@RequestBody Data data) {
		HashMap<String, Object> body = data.body;

		Scrap scrap =  JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("scrap")), Scrap.class);
		System.out.println("status : " + userService.addScrap(scrap));
		
		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
	
	@RequestMapping(value = "/remove/scrap", method = RequestMethod.POST)
	public @ResponseBody
	Data removeScrap(@RequestParam("sno") long scrapNo) {
		System.out.println("status : " + userService.removeScrap(scrapNo));
		
		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
	
	@RequestMapping(value = "/get/scrap", method = RequestMethod.POST)
	public @ResponseBody
	Data getScrapByNo(@RequestParam("sno") long scrapNo) {
		Scrap scrap = userService.getScrapByNo(scrapNo);
//		try {
//			System.out.println(BeanUtils.getBeanGetValue(scrap));
//		} catch(Exception e){
//			e.printStackTrace();
//		}
		Data responseData = new Data();
		responseData.body.put("scrap", scrap);
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
}
