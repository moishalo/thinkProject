package com.moishalo.thread;

/**
 * @Title: RunnableImpl.java
 * @Package com.moishalo.thread
 * @Description: TODO(添加描述)
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-6 下午2:06:56
 * @version V1.0
 */
public class RunnableImpl implements Runnable {
	int i = 0;

	public RunnableImpl(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println("我是编号" + i + "的线程");
		System.out.println("我的名字是:" + Thread.currentThread().getName());
		for (int j = 0; j < 1000; j++) {
			System.out.println("编号:" + i + ",当前计算值:" + j);
			Thread.yield();
		}
	}

}
