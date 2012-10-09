package com.moishalo.thread;

/**
 * @Title: Synchronize.java
 * @Package com.moishalo.thread
 * @Description: TODO(添加描述)
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-6 下午2:39:44
 * @version V1.0
 */
public class Synchronize implements Runnable {
	private static int n = 100;

	private int count = 100;

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (this) {
				count = count - 1;
			}
			System.out.println(Thread.currentThread().getName()
					+ " : 当前count值= " + getX());
			Synchronize.syn();
		}
		
	}

	public int getX() {
		return count;
	}

	public static void main(String[] args) {
		Synchronize s = new Synchronize();
		Thread t1 = new Thread(s);
		Thread t2 = new Thread(s);
		t1.start();
		t2.start();
	}
	
	public static void syn(){
		synchronized (Synchronize.class) {
			n--;
		}
		
		System.out.println(Thread.currentThread().getName()
				+ " : 当前n值= " + n);
	}
}
