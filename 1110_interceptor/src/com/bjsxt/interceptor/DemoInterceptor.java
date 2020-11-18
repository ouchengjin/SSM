package com.bjsxt.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor {
	/*
	 * 在进入控制器方法前执行
	 * 返回true表示可以进入控制器方法执行,反之则不然
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		System.out.println("DemoInterceptor.preHandle(我在方法执行前执行)");
		//handler就表示被拦截的控制器方法
		System.out.println(handler);
		return true;
	}

	/*
	 * 在控制器方法执行后,进入jsp之前执行
	 * 敏感词过滤
	 */
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler, ModelAndView modelAndView)
			throws Exception {
		//System.out.println(modelAndView.getViewName());
		//Map<String,Object> map = modelAndView.getModelMap();
		//System.out.println(map);
		modelAndView.getModel().put("msg", "我爱****");
		System.out.println("DemoInterceptor.postHandle(在控制器方法执行后,进入jsp之前执行)");
		

	}

	/*
	 * 等jsp执行后执行
	 * 记录异常信息
	 */
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception e)
			throws Exception {
		System.out.println(e.getMessage());
		System.out.println("DemoInterceptor.afterCompletion(jsp执行后执行)");
	}
}
