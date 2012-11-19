package com.moishalo.thread.java5;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @Title: User2.java
 * @Package com.moishalo.thread.java5
 * @Description: 支持区分读写操作的Lock示例，读写分开有利于性能控制
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date Oct 10, 2012 11:27:54 AM
 * @version V1.0
 */
public class User2 implements Callable<Integer> {

	private Bank bank;
	private int cash;
	private ReadWriteLock lock;
	private boolean isCheck;

	public User2(Bank bank, int cash, ReadWriteLock lock, boolean isCheck) {
		this.bank = bank;
		this.cash = cash;
		this.lock = lock;
		this.isCheck = isCheck;
	}

	@Override
	public Integer call() throws Exception {
		try {
			if (isCheck) {
				lock.readLock().lock();
				System.out.println("现金余额为:" + bank.getCash());
				lock.readLock().unlock();

			} else {
				lock.writeLock().lock();
				bank.operate(cash);
				System.out.println("银行现金变动:" + cash + "目前现金总额:"
						+ bank.getCash());
				lock.writeLock().unlock();
			}
			lock.readLock().lock();
			return bank.getCash();
		} finally {
			lock.readLock().unlock();
		}
	}
}
