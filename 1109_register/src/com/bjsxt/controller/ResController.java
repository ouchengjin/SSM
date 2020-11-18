package com.bjsxt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.pojo.Res;
import com.bjsxt.service.ResService;

@Controller
public class ResController {
	@Autowired
	private ResService resServiceImpl;
	@RequestMapping("selRes")
	@ResponseBody
	public List<Res> selRes(){
		List<Res> list = resServiceImpl.selRes();
		return list;
	}
	
	@RequestMapping("download")
	public void download(int id,String rname,HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException, IOException{
		Logger logger = Logger.getLogger(ResController.class);
		System.out.println(id);
		System.out.println(rname);
		//若接收参数为汉字乱码时,用如下方法解决
		//System.out.println(new String(rname.getBytes("iso-8859-1"),"utf-8"));
		rname=new String(rname.getBytes("utf-8"),"utf-8");
		//设置响应头信息
		//new String(rname.getBytes("utf-8"), "ISO8859-1")或java.net.URLEncoder.encode(rname, "UTF-8")是为了解决下载文件中文名称乱码
		//resp.setHeader("Content-Disposition", "attachment;filename="+new String(rname.getBytes("utf-8"), "ISO8859-1"));
		resp.setHeader("Content-Disposition", "attachment;filename="+java.net.URLEncoder.encode(rname, "UTF-8"));
		
		resp.setContentType("application/octet-stream;charset=utf-8");
		//输入流
		InputStream input = new FileInputStream(new File(req.getServletContext().getRealPath("/images"), rname));
		//输出流
		OutputStream output = resp.getOutputStream();
		IOUtils.copy(input, output);
		//由于output是resp管理,故而不需要手动关,关input即可
		input.close();
		//更新下载次数
		int updCount = resServiceImpl.updCount(id);
		if(updCount>0){
			System.out.println("更新数据库成功");
		}
		logger.error(req.getSession().getAttribute("uname")+"下载了"+rname);
	}
}
