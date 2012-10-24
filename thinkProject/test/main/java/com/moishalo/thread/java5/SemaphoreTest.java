package com.moishalo.thread.java5;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Title: SemaphoreTest.java
 * @Package com.moishalo.thread.java5
 * @Description: 信号量使用测试
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date Oct 10, 2012 2:54:35 PM
 * @version V1.0
 */
public class SemaphoreTest {

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 *            参数及返回值
	 * @return void 返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		Semaphore sp = new Semaphore(5);
		
		ExecutorService pool = Executors.newCachedThreadPool();
		
		Thread r1 = new Thread(new Run(sp));
		Thread r2 = new Thread(new Run(sp));
		Thread r3 = new Thread(new Run(sp));
		Thread r4 = new Thread(new Run(sp));
		Thread r5 = new Thread(new Run(sp));
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		
		pool.shutdown();
	}

	static class Run implements Runnable {
		
		private Semaphore sp;

		public Run(Semaphore sp){
			this.sp = sp;
		}

		@Override
		public void run() {
			try {
				sp.acquire(4);
				System.out.println("我正在运行, 我的线程名:"
						+ Thread.currentThread().getName());
				System.out.println((new Date()).toString());
				Thread.sleep(1000);
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				sp.release(4);
			}
		}

	}

}
