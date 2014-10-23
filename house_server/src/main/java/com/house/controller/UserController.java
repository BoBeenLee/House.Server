package com.house.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.model.Attach;
import com.house.model.Data;
import com.house.model.SrcType;
import com.house.model.TransferMultipartFile;
import com.house.model.User;
import com.house.service.FileService;
import com.house.service.TokenService;
import com.house.service.UserService;
import com.house.util.BeanUtils;
import com.house.util.JacksonUtils;

@Controller
public class UserController {
    @Resource(name = "appTokenService")
    TokenService tokenService;
	@Autowired
	UserService userService;
	@Autowired
	FileService fileService;
	
//	User
	@RequestMapping(value = "/add/user", method = RequestMethod.POST)
	public @ResponseBody
	Data addUser(@RequestBody Data data) {
		boolean isUser = false;
		HashMap<String, Object> body = data.body;

		User user = JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("user")), User.class);
		Attach attach = null;
		
		TransferMultipartFile multipartFile = JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("img")),
				TransferMultipartFile.class);
		
		if(multipartFile != null){
			attach = new Attach();
			attach.setTransferMultipartFile(multipartFile);
		}
//		try {
//			System.out.println(BeanUtils.getBeanGetValue(user));
//			System.out.println(BeanUtils.getBeanGetValue(multipartFile));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		isUser = userService.addUser(user, attach);

		// Response
		Data responseData = new Data();
		if(isUser)
			responseData.setStatus(Data.Status.OK);
		else
			responseData.setStatus(Data.Status.FAIL);
		return responseData;
	}

	@RequestMapping(value = "/remove/user", method = RequestMethod.POST)
	public @ResponseBody Data removeUser(@RequestParam("uno") long userNo) {
		boolean isUser = userService.removeUser(userNo);
		
		// Response
		Data responseData = new Data();
		if(isUser)
			responseData.setStatus(Data.Status.OK);
		else
			responseData.setStatus(Data.Status.FAIL);
		return responseData;
	}

	@RequestMapping(value = "/modify/user", method = RequestMethod.POST)
	public @ResponseBody Data modifyUser(@RequestBody Data data) {
		boolean isUser = false;
		HashMap<String, Object> body = data.body;
		
		User user = JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("user")), User.class);
		TransferMultipartFile multipartFile = JacksonUtils.jsonToObject(
				JacksonUtils.objectToJson(body.get("img")),
				TransferMultipartFile.class);
		Attach attach = new Attach();
		attach.setTransferMultipartFile(multipartFile);

//		try {
//			System.out.println(BeanUtils.getBeanGetValue(user));
//			System.out.println(BeanUtils.getBeanGetValue(attach));
//		} catch (Exception e) {
//		}
		// Response
		Data responseData = new Data();
		isUser = userService.modifyUser(user, attach);
		if(isUser)
			responseData.setStatus(Data.Status.OK);
		else
			responseData.setStatus(Data.Status.FAIL);
		responseData.setStatus(Data.Status.OK);
		return responseData;
	}

	@RequestMapping(value = "/get/user", method = RequestMethod.POST)
	public @ResponseBody
	Data getUserByName(@RequestBody User user1) {
		User user = userService.getUserById(user1.getUsrId());
		Attach[] attachs = fileService.getAttachByNoType(user.getUsrNo(),
				SrcType.PROFILE_TYPE);
		
		// Response
		Data responseData = new Data();
		responseData.body.put("user", user);
		responseData.body.put("img", attachs[0]);
		if(user != null)
			responseData.setStatus(Data.Status.OK);
		else 
			responseData.setStatus(Data.Status.FAIL);
		return responseData;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/auth/user")
	@ResponseBody
	public Data login(@RequestBody User user) {
		User lUser = userService.getUserById(user.getUsrId());
		String token = null;
		
		if(lUser.getUsrId().equals(user.getUsrId()) && lUser.getUsrPw().equals(user.getUsrPw())){
			 token = tokenService.getToken(user);
			 lUser.setToken(token);
		} else 
			 lUser = null;
		
		// Response
		Data responseData = new Data();
		responseData.body.put("user", lUser);
		if(lUser != null)
			responseData.setStatus(Data.Status.OK);
		else 
			responseData.setStatus(Data.Status.FAIL);
		return responseData;
	}
}
