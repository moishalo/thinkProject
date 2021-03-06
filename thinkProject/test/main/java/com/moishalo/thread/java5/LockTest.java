package com.moishalo.thread.java5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title: LockTest.java
 * @Package com.moishalo.thread.java5
 * @Description: TODO(添加描述)
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-7 上午12:31:05
 * @version V1.0
 */
public class LockTest {

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args 参数及返回值
	 * @return void 返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		ExecutorService pool = Executors.newCachedThreadPool();
		Bank bank = new Bank(1000000);
		User u1 = new User(bank,3000,lock);
		User u2 = new User(bank,5000,lock);
		User u3 = new User(bank,10000,lock);
		User u4 = new User(bank,-6000,lock);
		User u5 = new User(bank,-13000,lock);
		User u6 = new User(bank,-7000,lock);
		
		Future<Integer> f1 = pool.submit(u1);
		Future<Integer> f2 = pool.submit(u2);
		Future<Integer> f3 = pool.submit(u3);
		Future<Integer> f4 = pool.submit(u4);
		Future<Integer> f5 = pool.submit(u5);
		Future<Integer> f6 = pool.submit(u6);
		try {
			System.out.println("运行结束："+f1.get()+"、"+f2.get()+"、"+f3.get()+"、"+f4.get()+"、"+f5.get()+"、"+f6.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		pool.shutdown();
	}

}
