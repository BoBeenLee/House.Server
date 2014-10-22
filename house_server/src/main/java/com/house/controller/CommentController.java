package com.house.controller;

import com.house.model.Comment;
import com.house.model.Data;
import com.house.model.Data.Status;
import com.house.service.InteriorService;
import com.house.service.SudatalkService;
import com.house.util.JacksonUtils;

import java.io.PrintStream;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {
	@Autowired
	InteriorService interiorService;
	@Autowired
	SudatalkService sudatalkService;

	@RequestMapping(value = { "/add/{srcType}/comment" }, method = { RequestMethod.POST })
	@ResponseBody
	public Data addComment(@PathVariable String srcType, @RequestBody Data data) {
		HashMap<String, Object> body = data.body;

		Comment comment = (Comment) JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("comment")), Comment.class);
		if (srcType.equals("interior")) {
			System.out.println("status : "
					+ this.interiorService.addComment(comment));
		} else if (srcType.equals("sudatalk")) {
			System.out.println("status : "
					+ this.sudatalkService.addComment(comment));
		}
		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}

	@RequestMapping(value = { "/modify/{srcType}/comment" }, method = { RequestMethod.POST })
	@ResponseBody
	public Data modifyComment(@PathVariable String srcType,
			@RequestBody Data data) {
		HashMap<String, Object> body = data.body;

		Comment comment = (Comment) JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("comment")), Comment.class);
		if (srcType.equals("interior")) {
			System.out.println("status : "
					+ this.interiorService.modifyComment(comment));
		} else if (srcType.equals("sudatalk")) {
			System.out.println("status : "
					+ this.sudatalkService.modifyComment(comment));
		}
		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}

	@RequestMapping(value = { "/remove/{srcType}/comment" }, method = { RequestMethod.POST })
	@ResponseBody
	public Data removeComment(@PathVariable String srcType,
			@RequestParam("cno") long commentNo) {
		if (srcType.equals("interior")) {
			System.out.println("status : "
					+ this.interiorService.removeComment(commentNo));
		} else if (srcType.equals("sudatalk")) {
			System.out.println("status : "
					+ this.sudatalkService.removeComment(commentNo));
		}
		Data responseData = new Data();
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}

	@RequestMapping({ "/get/{srcType}/comment" })
	@ResponseBody
	public Data getCommentByNo(@PathVariable String srcType,
			@RequestParam("cno") long commentNo) {
		Comment comment = null;
		if (srcType.equals("interior")) {
			comment = this.interiorService.getCommentByNo(commentNo, 1);
		} else if (srcType.equals("sudatalk")) {
			comment = this.sudatalkService.getCommentByNo(commentNo, 1);
		}
		Data responseData = new Data();
		responseData.body.put("comment", comment);
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}
}
