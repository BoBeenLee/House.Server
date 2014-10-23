package com.house.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.model.Comment;
import com.house.model.Data;
import com.house.model.SrcType;
import com.house.service.InteriorService;
import com.house.service.SudatalkService;
import com.house.util.BeanUtils;
import com.house.util.JacksonUtils;


@Controller
public class CommentController {
	@Autowired
	InteriorService interiorService;
	
	@Autowired
	SudatalkService sudatalkService;
	
	@RequestMapping(value = "/add/{srcType}/comment", method = RequestMethod.POST)
	public @ResponseBody
	Data addComment(@PathVariable String srcType, @RequestBody Data data) {
		HashMap<String, Object> body = data.body;

		Comment comment =  JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("comment")), Comment.class);
		
		if(srcType.equals("interior"))
			System.out.println("status : " + interiorService.addComment(comment));
		else if(srcType.equals("sudatalk"))
			System.out.println("status : " + sudatalkService.addComment(comment));
		
		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
	
	@RequestMapping(value = "/modify/{srcType}/comment", method = RequestMethod.POST)
	public @ResponseBody
	Data modifyComment(@PathVariable String srcType, @RequestBody Data data) {
		HashMap<String, Object> body = data.body;

		Comment comment =  JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("comment")), Comment.class);
		
		if(srcType.equals("interior"))
			System.out.println("status : " + interiorService.modifyComment(comment));
		else if(srcType.equals("sudatalk"))
			System.out.println("status : " + sudatalkService.modifyComment(comment));
		
		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
	
	@RequestMapping(value = "/remove/{srcType}/comment", method = RequestMethod.POST)
	public @ResponseBody
	Data removeComment(@PathVariable String srcType, @RequestParam("cno") long commentNo) {
		if(srcType.equals("interior"))
			System.out.println("status : " + interiorService.removeComment(commentNo));
		else if(srcType.equals("sudatalk"))
			System.out.println("status : " + sudatalkService.removeComment(commentNo));
		
		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
	
	@RequestMapping(value = "/get/{srcType}/comment")
	public @ResponseBody
	Data getCommentByNo(@PathVariable String srcType, @RequestParam(value = "cno") long commentNo) {
		Comment comment = null;
		
		if(srcType.equals("interior"))
			comment =  interiorService.getCommentByNo(commentNo, SrcType.PROFILE_TYPE);
		else if(srcType.equals("sudatalk"))
			comment =  sudatalkService.getCommentByNo(commentNo, SrcType.PROFILE_TYPE);
//		try {
//			System.out.println(BeanUtils.getBeanGetValue(comment));
//		} catch(Exception e){
//			e.printStackTrace();
//		}
		Data responseData = new Data();
		responseData.body.put("comment", comment);
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
}
