package com.moishalo.thread;


/**
 * @Title: ThreadTest.java
 * @Package com.moishalo.thread
 * @Description: 测试线程创建方式
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-6 下午12:53:25
 * @version V1.0
 */
public class ThreadTest {

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args 参数及返回值
	 * @return void 返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		Thread thread1 = new Thread(new RunnableImpl(0));
		Thread thread2 = new Thread(new RunnableImpl(1));
		thread1.start();
		thread2.start();
		
		Thread t1 = new ThreadExtend(2);
		Thread t2 = new ThreadExtend(3);
		
		t1.start();
		t2.start();
	}

}
