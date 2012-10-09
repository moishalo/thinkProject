package com.moishalo.thread;

/**
 * @Title: AccountOper.java
 * @Package com.moishalo.thread
 * @Description: TODO(添加描述)
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-6 下午4:04:36
 * @version V1.0
 */
public class AccountOper extends Thread {
	private Account a;
	private int y = 0;

	public AccountOper(String name, Account a, int y) {
		super(name);
		this.a = a;
		this.y = y;
	}

	public void run() {
		a.oper(y);
	}

	public static void main(String[] args) {
		Account u = new Account("张三", 100);
		AccountOper t1 = new AccountOper("线程A", u, 20);
		AccountOper t2 = new AccountOper("线程B", u, -60);
		AccountOper t3 = new AccountOper("线程C", u, -80);
		AccountOper t4 = new AccountOper("线程D", u, -30);
		AccountOper t5 = new AccountOper("线程E", u, 32);
		AccountOper t6 = new AccountOper("线程F", u, 21);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}
