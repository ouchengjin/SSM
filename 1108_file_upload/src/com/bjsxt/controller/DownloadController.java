package com.bjsxt.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownloadController {
	@RequestMapping("dld.sxt")
	public void dld(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		//设置响应头
		resp.setHeader("Content-Disposition", "attachment;filename=bjsxt.png");
		//resp.setContentType("image/png");//让浏览器能知道下载的是什么类型
		resp.setContentType("application/octet-stream");//任何类型都可以下载
		InputStream input= new FileInputStream(req.getServletContext().getRealPath("/images/22749724ad994507af03a321b011c863.jpg"));
		OutputStream output = resp.getOutputStream();
		IOUtils.copy(input, output);
		
		
	}
}
