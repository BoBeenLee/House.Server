package com.house.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class FileUtils {
	public static HttpServletRequest getCurrentRequest() {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletRequest hsr = sra.getRequest();
		return hsr;
	}

	public static String innerUrl() {
		HttpServletRequest request = getCurrentRequest();

		String rootUrl = request.getSession().getServletContext()
				.getRealPath("/")
				+ "/image";
		return rootUrl;
	}

	public static boolean transferTo(String originName, byte[] content)
			throws IOException, IllegalStateException {
		boolean isTransfer = false;
		HttpServletRequest request = getCurrentRequest();

		String rootUrl = request.getSession().getServletContext()
				.getRealPath("/")
				+ "/image/";
		File dest = new File(rootUrl + originName);
		try {
			new FileOutputStream(dest).write(content);
			isTransfer = true;
		} catch (Exception e) {
		}
		return isTransfer;
	}
}
