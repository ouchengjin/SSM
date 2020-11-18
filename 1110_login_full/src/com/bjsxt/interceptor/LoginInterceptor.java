package com.bjsxt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bjsxt.pojo.Users;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		//从session中获取用户信息
		Users u = (Users) req.getSession().getAttribute("u");
		if (u!=null) {
			return true;
		} else {
			req.getSession().setAttribute("msg", "请您先登录后访问");
			//强制用户进行登陆
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
			return false;
		}
	}

}
