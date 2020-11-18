package com.bjsxt.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userServiceImpl;
	@RequestMapping("register")
	public String insUser(User user,HttpServletRequest req,MultipartFile file) throws IllegalStateException, IOException{
		//获取上传文件的原始名称
		String fname = file.getOriginalFilename();
		//生成随机的文件名
		String photo = UUID.randomUUID().toString().replaceAll("-", "")+fname.substring(fname.lastIndexOf("."));
		//赋值到user对象中
		user.setPhoto(photo);
		//文件上传
		File loc = new File(req.getServletContext().getRealPath("/images"), photo);
		//如果文件夹不存在，创建之
		if(!loc.getParentFile().exists()){
			loc.getParentFile().mkdirs();
		}
		file.transferTo(loc);
		userServiceImpl.insUser(user); 
		//将用户名记录到session作用域
		req.getSession().setAttribute("uname", user.getUname());
		return "main.jsp";
	}
}
