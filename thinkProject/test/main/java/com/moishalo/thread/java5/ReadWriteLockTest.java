package com.moishalo.thread.java5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Title: ReadWriteLockTest.java
 * @Package com.moishalo.thread.java5
 * @Description: TODO(添加描述)
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date Oct 10, 2012 12:23:10 PM
 * @version V1.0
 */
public class ReadWriteLockTest {

	public static void main(String[] args) {
		ReadWriteLock lock = new ReentrantReadWriteLock();
		ExecutorService pool = Executors.newCachedThreadPool();
		Bank bank = new Bank(1000000);
		User2 u1 = new User2(bank, 3000, lock, false);
		User2 u2 = new User2(bank, 5000, lock, false);
		User2 u3 = new User2(bank, 10000, lock, false);
		User2 u4 = new User2(bank, -6000, lock, false);
		User2 u5 = new User2(bank, -13000, lock, false);
		User2 u6 = new User2(bank, -7000, lock, false);
		User2 u7 = new User2(bank, 0, lock, true);
		User2 u8 = new User2(bank, 0, lock, true);

		Future<Integer> f1 = pool.submit(u1);
		Future<Integer> f2 = pool.submit(u2);
		Future<Integer> f3 = pool.submit(u3);
		Future<Integer> f4 = pool.submit(u4);
		Future<Integer> f5 = pool.submit(u5);
		Future<Integer> f6 = pool.submit(u6);
		Future<Integer> f7 = pool.submit(u7);
		Future<Integer> f8 = pool.submit(u8);
		try {
			System.out.println("运行结束：" + f1.get() + "、" + f2.get() + "、"
					+ f3.get() + "、" + f4.get() + "、" + f5.get() + "、"
					+ f6.get()+"、"+f7.get()+"、"+f8.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		pool.shutdown();
	}

}
