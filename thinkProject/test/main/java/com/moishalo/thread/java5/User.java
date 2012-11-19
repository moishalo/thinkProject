package com.moishalo.thread.java5;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

/**
 * @Title: User.java
 * @Package com.moishalo.thread.java5
 * @Description: 使用callable实现的银行用户
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date Oct 10, 2012 12:34:11 AM
 * @version V1.0
 */
public class User implements Callable<Integer> {
	private int cash;
	private Bank bank;
	private Lock lock;

	public User(Bank bank, int cash, Lock lock) {
		this.bank = bank;
		this.cash = cash;
		this.lock = lock;
	}

	@Override
	public Integer call() throws Exception {
		try{
			lock.lock();
			bank.operate(cash);
			System.out.println("银行现金变动:"+cash+"目前现金总额:"+bank.getCash());
			return bank.getCash();
		}finally{
			lock.unlock();
		}
		
	}
}
