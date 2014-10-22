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
import com.house.model.TransferMultipartFile;
import com.house.model.User;
import com.house.service.FileService;
import com.house.service.TokenService;
import com.house.service.UserService;
import com.house.util.JacksonUtils;

@Controller
public class UserController {
	@Autowired
	TokenService tokenService;
	@Autowired
	UserService userService;
	@Autowired
	FileService fileService;

	@RequestMapping(value = { "/add/user" }, method = { RequestMethod.POST })
	@ResponseBody
	public Data addUser(@RequestBody Data data) {
		boolean isUser = false;
		HashMap<String, Object> body = data.body;

		User user = (User) JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("user")), User.class);
		Attach attach = null;

		TransferMultipartFile multipartFile = (TransferMultipartFile) JacksonUtils
				.jsonToObject(JacksonUtils.objectToJson(body.get("img")),
						TransferMultipartFile.class);
		if (multipartFile != null) {
			attach = new Attach();
			attach.setTransferMultipartFile(multipartFile);
		}
		isUser = this.userService.addUser(user, attach);

		Data responseData = new Data();
		if (isUser) {
			responseData.setStatus(Data.Status.OK);
		} else {
			responseData.setStatus(Data.Status.FAIL);
		}
		return responseData;
	}

	@RequestMapping(value = { "/remove/user" }, method = { RequestMethod.POST })
	@ResponseBody
	public Data removeUser(@RequestParam("uno") long userNo) {
		boolean isUser = this.userService.removeUser(userNo);

		Data responseData = new Data();
		if (isUser) {
			responseData.setStatus(Data.Status.OK);
		} else {
			responseData.setStatus(Data.Status.FAIL);
		}
		return responseData;
	}

	@RequestMapping(value = { "/modify/user" }, method = { RequestMethod.POST })
	@ResponseBody
	public Data modifyUser(@RequestBody Data data) {
		boolean isUser = false;
		HashMap<String, Object> body = data.body;

		User user = (User) JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("user")), User.class);
		TransferMultipartFile multipartFile = (TransferMultipartFile) JacksonUtils
				.jsonToObject(JacksonUtils.objectToJson(body.get("img")),
						TransferMultipartFile.class);
		Attach attach = new Attach();
		attach.setTransferMultipartFile(multipartFile);

		Data responseData = new Data();
		isUser = this.userService.modifyUser(user, attach);
		if (isUser) {
			responseData.setStatus(Data.Status.OK);
		} else {
			responseData.setStatus(Data.Status.FAIL);
		}
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}

	@RequestMapping(value = { "/get/user" }, method = { RequestMethod.POST })
	@ResponseBody
	public Data getUserByName(@RequestBody User user1) {
		User user = this.userService.getUserById(user1.getUsrId());
		Attach[] attachs = this.fileService.getAttachByNoType(user.getUsrNo(),
				1);

		Data responseData = new Data();
		responseData.body.put("user", user);
		responseData.body.put("img", attachs[0]);
		if (user != null) {
			responseData.setStatus(Data.Status.OK);
		} else {
			responseData.setStatus(Data.Status.FAIL);
		}
		return responseData;
	}

	@RequestMapping(method = { RequestMethod.POST }, value = { "/auth/user" })
	@ResponseBody
	public Data login(@RequestBody User user) {
		User lUser = this.userService.getUserById(user.getUsrId());
		String token = null;
		if ((lUser.getUsrId().equals(user.getUsrId()))
				&& (lUser.getUsrPw().equals(user.getUsrPw()))) {
			token = this.tokenService.getToken(user);
			lUser.setToken(token);
		} else {
			lUser = null;
		}
		Data responseData = new Data();
		responseData.body.put("user", lUser);
		if (lUser != null) {
			responseData.setStatus(Data.Status.OK);
		} else {
			responseData.setStatus(Data.Status.FAIL);
		}
		return responseData;
	}
}
