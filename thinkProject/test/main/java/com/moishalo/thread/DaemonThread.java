package com.moishalo.thread;

/**
 * @Title: DaemonThread.java
 * @Package com.moishalo.thread
 * @Description: TODO(添加描述)
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-6 下午3:36:06
 * @version V1.0
 */
public class DaemonThread implements Runnable {

	@Override
	public void run() {
		System.out.println("守护线程");
		for (long i = 0; i < 9999999L; i++) {
			System.out.println("后台线程第" + i + "次执行！");
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args){
		Thread t1 = new Thread(new RunnableImpl(0));
		Thread t2 = new Thread(new DaemonThread());
		t2.setDaemon(true);
		t1.start();
		t2.start();
	}
}
