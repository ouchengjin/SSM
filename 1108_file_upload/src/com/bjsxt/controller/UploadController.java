package com.bjsxt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@RequestMapping("up.sxt")
	public String test(String name,MultipartFile img,HttpServletRequest req) throws IOException{
		System.out.println(name+":"+img);
		System.out.println(img.getName());//提交时候的name属性
		System.out.println(img.getOriginalFilename());//文件名称
		System.out.println(img.getContentType());//MIME
		System.out.println(img.getSize());//大小
		//上传文件的输入流
		InputStream input = img.getInputStream();
		//输出流,定义写到服务器的哪个位置,apache的IOUtils.copy
		/*String realPath = req.getServletContext().getRealPath("/images");//已配置静态资源
		OutputStream output = new FileOutputStream(new File(realPath, img.getOriginalFilename()));
		System.out.println(realPath+img.getOriginalFilename());
		IOUtils.copy(input, output);	
		output.close();*/
		
		//还有一种springmvc的方法transferTo完成 
		String realPath = req.getServletContext().getRealPath("/images");//已配置静态资源
		img.transferTo(new File(realPath, img.getOriginalFilename()));
		return "/index.jsp";
	}
}
