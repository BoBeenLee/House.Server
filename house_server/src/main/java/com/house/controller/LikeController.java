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
import com.house.model.Like;
import com.house.model.Sudatalk;
import com.house.model.TransferMultipartFile;
import com.house.service.UserService;
import com.house.util.BeanUtils;
import com.house.util.JacksonUtils;

@Controller
public class LikeController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/add/like", method = RequestMethod.POST)
	public @ResponseBody
	Data addLike(@RequestBody Data data) {
		HashMap<String, Object> body = data.body;

		Like like =  JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("like")), Like.class);
		System.out.println("status : " + userService.addLike(like));
		
		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
	
	@RequestMapping(value = "/remove/like", method = RequestMethod.POST)
	public @ResponseBody
	Data removeLike(@RequestParam("lno") long likeNo) {
		System.out.println("status : " + userService.removeLike(likeNo));
		
		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
	
	@RequestMapping(value = "/get/like", method = RequestMethod.POST)
	public @ResponseBody
	Data getLikeByNo(@RequestParam("lno") long likeNo) {
		Like like = userService.getLikeByNo(likeNo);
//		try {
//			System.out.println(BeanUtils.getBeanGetValue(like));
//		} catch(Exception e){
//			e.printStackTrace();
//		}
		Data responseData = new Data();
		responseData.body.put("like", like);
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
}
