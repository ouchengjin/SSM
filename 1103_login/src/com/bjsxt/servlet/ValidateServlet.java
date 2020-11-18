package com.bjsxt.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/vcode.jpg")
public class ValidateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//定义一个画布
		BufferedImage image = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
		//创建一个画笔
		Graphics2D g= image.createGraphics();
		//设置画笔颜色
		g.setColor(Color.WHITE);
		//填充矩形区域
		g.fillRect(0, 0, 200, 100);
		//描边,像素小1是为了将边画出来
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 199, 99);
		//随机生成四位验证码数字
		List<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			list.add(random.nextInt(10));
		}
		//设置字体样式
		g.setFont(new Font("Consolas", Font.BOLD|Font.ITALIC, 50));
		Color[] colors = new Color[]{Color.BLUE,Color.CYAN,Color.GREEN,Color.ORANGE,Color.PINK};
		for (int i = 0; i < list.size(); i++) {
			//将数字画到图片上
			g.setColor(colors[random.nextInt(colors.length)]);
			g.drawString(list.get(i).toString(), 10+i*50, 60);
		}
		//为了后续判断,将验证码存入session作用域中保存
		String vcode = "";
		for (int i = 0; i < list.size(); i++) {
			vcode += list.get(i);
		}
		req.getSession().setAttribute("vcode", vcode);
		ServletOutputStream out = resp.getOutputStream();
		ImageIO.write(image, "jpg", out);
		
	
	}
}
