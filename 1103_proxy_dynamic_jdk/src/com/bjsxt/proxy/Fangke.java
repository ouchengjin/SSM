package com.bjsxt.proxy;

import java.lang.reflect.Proxy;

public class Fangke {

	public static void main(String[] args) {
		Mishu mishu = new Mishu();
//		System.out.println(Mishu.class.getClassLoader()==Laoban.class.getClassLoader());
		//这里一定不能转为老板对象，会报错，类型转换异常
		Gongneng proxy = (Gongneng) Proxy.newProxyInstance(Fangke.class.getClassLoader(),
                new Class[] { Gongneng.class },
                mishu);
		proxy.daMuBiao();
		proxy.xiaoMuBiao();
		proxy.chifan();

	}

}
