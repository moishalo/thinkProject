package com.moishalo.thread;
/**
 * @Title: ThreadExtend.java
 * @Package com.moishalo.thread
 * @Description: TODO(添加描述)
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-6 下午2:25:36
 * @version V1.0
 */
public class ThreadExtend extends Thread {
	int i = 0;

	public ThreadExtend(int i) {
		this.i = i;
	}
	
	@Override
	public void run() {
		System.out.println("我是编号" + i + "的线程");
		System.out.println("我的名字是:" + Thread.currentThread().getName());
		for (int j = 0; j < 1000; j++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("编号:" + i + ",当前计算值:" + j);
		}
	}
}
