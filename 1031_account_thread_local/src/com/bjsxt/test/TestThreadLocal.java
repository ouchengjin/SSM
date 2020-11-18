package com.bjsxt.test;

public class TestThreadLocal {

	public static <T> void main(String[] args) {
		ThreadLocal<String> threadLocal = new ThreadLocal<String>();
		threadLocal.set("hello");
		System.out.println(Thread.currentThread().getId());
		System.out.println(threadLocal.get());
		
		new Thread(){
			public void run() {
				System.out.println(Thread.currentThread().getId());
				System.out.println(threadLocal.get());
				
			};
		}.start();
		
	}

}
