package com.bjsxt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController2 {
	@RequestMapping("up2.sxt")
	public String test(String name,MultipartFile img,HttpServletRequest req) throws IOException{
		//限制文件类型
		String fileName = img.getOriginalFilename();
		String tag = fileName.substring(fileName.lastIndexOf("."));
		System.out.println(tag);
//		if (tag.endsWith(".jpg")||tag.endsWith(".png")) {
		/*if (tag.equalsIgnoreCase(".jpg")||tag.equalsIgnoreCase(".png")) {
			String realPath = req.getServletContext().getRealPath("/images");
			img.transferTo(new File(realPath, img.getOriginalFilename()));
			return "index.jsp";
		}else{
			System.out.println("类型不对");
			return "filetypeerror.jsp";
		}*/
		
		//MIME
		/*String type = img.getContentType();
		if(type.equalsIgnoreCase(anotherString)){
			
		}*/
		
		String uuid = UUID.randomUUID().toString();
		String newName = uuid.replace("-", "")+tag;
		String realPath = req.getServletContext().getRealPath("/images");
		img.transferTo(new File(realPath, newName));
		return "index.jsp";
	}
}
