package com.bjsxt.proxy;

public class Mishu implements Goneneng{
	private Laoban laoban = new Laoban();

	@Override
	public void xiaoMuBiao() {
		System.out.println("秘书预约时间");
		laoban.xiaoMuBiao();
		System.out.println("秘书记录访客信息");
	}

	@Override
	public void daMuBiao() {
		System.out.println("秘书预约时间");
		laoban.daMuBiao();
		System.out.println("秘书记录访客信息");
	}
	
}
