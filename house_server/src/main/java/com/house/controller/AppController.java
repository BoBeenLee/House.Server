package com.house.controller;

import com.house.model.APICode;
import com.house.model.Attach;
import com.house.service.APService;
import com.house.service.CMService;
import com.house.service.FileService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
	@Autowired
	APService apService;
	@Autowired
	CMService cmService;
	@Autowired
	FileService fileService;

	@RequestMapping(value = { "/house/image/{name}" }, produces = {
			"image/jpg", "image/png" })
	@ResponseBody
	public byte[] showImage(@PathVariable("name") String name,
			HttpServletResponse response) {
		Attach attach = this.fileService.getAttachByExUrl("/house/image/"
				+ name + ".app");

		File file = new File(attach.getInUrl());
		try {
			return IOUtils.toByteArray(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping({ "/house/{code}" })
	@ResponseBody
	public APICode mappingCenter(@PathVariable("code") String code,
			@RequestBody APICode reqCode) {
		APICode resCode = new APICode();

		System.out.println("----------------------" + code
				+ "-------------------------------");
		if (code.equals("CM0001")) {
			resCode = this.cmService.responseCM0001(reqCode);
		} else if (!code.equals("CM0002")) {
			if (code.equals("CM0003")) {
				resCode = this.cmService.responseCM0003(reqCode);
			} else if (code.equals("CM0004")) {
				resCode = this.cmService.responseCM0004(reqCode);
			} else if (code.equals("CM0005")) {
				resCode = this.cmService.responseCM0005(reqCode);
			} else if (code.equals("CM0006")) {
				resCode = this.cmService.responseCM0006(reqCode);
			} else if (!code.equals("CM0007")) {
			} else if (code.equals("AP0001")) {
				resCode = this.apService.responseAP0001(reqCode);
			} else if (!code.equals("AP0002")) {
			} else if (code.equals("AP0003")) {
				resCode = this.apService.responseAP0003(reqCode);
			} else if (code.equals("AP0004")) {
				resCode = this.apService.responseAP0004(reqCode);
			} else if (code.equals("AP0005")) {
				resCode = this.apService.responseAP0005(reqCode);
			} else if (code.equals("AP0006")) {
				resCode = this.apService.responseAP0006(reqCode);
			} else if (code.equals("AP0007")) {
				resCode = this.apService.responseAP0007(reqCode);
			} else if (code.equals("AP0008")) {
				resCode = this.apService.responseAP0008(reqCode);
			} else if (code.equals("AP0009")) {
				resCode = this.apService.responseAP0009(reqCode);
			} else if (code.equals("AP0010")) {
				resCode = this.apService.responseAP0010(reqCode);
			}
		}
		return resCode;
	}
}
