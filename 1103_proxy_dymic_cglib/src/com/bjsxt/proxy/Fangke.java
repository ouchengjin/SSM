package com.bjsxt.proxy;

import net.sf.cglib.proxy.Enhancer;

public class Fangke {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Laoban.class);
		enhancer.setCallback(new Mishu());
		//生成代理对象，强转为父类
		Laoban laoban = (Laoban) enhancer.create();
		laoban.chifan();
	}

}
