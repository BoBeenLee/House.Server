package com.house.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.model.APICode;
import com.house.model.Attach;
import com.house.model.CodeType;
import com.house.model.Data;
import com.house.model.Interior;
import com.house.model.Like;
import com.house.model.Sudatalk;
import com.house.model.TransferMultipartFile;
import com.house.model.User;
import com.house.model.code.*;
import com.house.model.code.AP0006.AP0006Img;
import com.house.service.APService;
import com.house.service.CMService;
import com.house.service.InteriorService;
import com.house.service.SudatalkService;
import com.house.service.TokenService;
import com.house.service.UserService;
import com.house.util.JacksonUtils;

@Controller
public class AppController {
	@Autowired
	APService apService;
	@Autowired
	CMService cmService;
	
	@RequestMapping(value = "/house/{code}")
	public @ResponseBody APICode mappingCenter(@PathVariable("code") String code, @RequestBody APICode reqCode){
		APICode resCode = new APICode();
		
		System.out.println("Controller --- ");
		if(code.equals("CM0001")){
			resCode = cmService.responseCM0001(reqCode);
		} else if(code.equals("CM0002")){
//			resCode = responseCM0002(reqCode);
		} else if(code.equals("CM0003")){
			resCode = cmService.responseCM0003(reqCode);
		} else if(code.equals("CM0004")){
			resCode = cmService.responseCM0004(reqCode);
		} else if(code.equals("CM0005")){
			resCode = cmService.responseCM0005(reqCode);
		} else if(code.equals("CM0006")){
			resCode = cmService.responseCM0006(reqCode);
		} else if(code.equals("CM0007")){
//			resCode = responseCM0007(reqCode);
		} else if(code.equals("AP0001")){
			resCode = apService.responseAP0001(reqCode);
		} else if(code.equals("AP0002")){
//			resCode = responseAP0002(reqCode);
		} else if(code.equals("AP0003")){
			resCode = apService.responseAP0003(reqCode);
		} else if(code.equals("AP0004")){
			resCode = apService.responseAP0004(reqCode);
		} else if(code.equals("AP0005")){
			resCode = apService.responseAP0005(reqCode);
		} else if(code.equals("AP0006")){
			resCode = apService.responseAP0006(reqCode);
		} else if(code.equals("AP0007")){
			resCode = apService.responseAP0007(reqCode);
		} else if(code.equals("AP0008")){
			resCode = apService.responseAP0008(reqCode);
		} else if(code.equals("AP0009")){
			resCode = apService.responseAP0009(reqCode);
		}
//		if Error Code
//		if(reqCode.getErrorAction()
		return resCode;
	}
	

	

	
	
	
	
	
	

	

	

	

	

}
