package com.bjsxt.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bjsxt.pojo.Path;
import com.bjsxt.pojo.Users;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		String requestURI = req.getRequestURI();
		StringBuffer requestURL = req.getRequestURL();
		System.out.println(requestURI+":"+requestURL.toString());
		Object obj = req.getSession().getAttribute("user");
		if (obj!=null) {
			Users users= (Users) obj;
			//判断用户是否具有访问该路径的权限
			List<Path> plist = users.getPlist();
			for (Path path : plist) {
				System.out.println("对比"+requestURI+"=?"+path.getUrl());
				if (requestURI.equals(path.getUrl())) {
					return true;
				}
			}
			//没权限
			System.out.println(req.getContextPath());
			resp.sendRedirect(req.getContextPath()+"/urlLimit.jsp");
			return false;
		}
		req.getSession().setAttribute("msg", "请先登录");
		resp.sendRedirect(req.getContextPath()+"/login.jsp");
		return false;
	}

}
