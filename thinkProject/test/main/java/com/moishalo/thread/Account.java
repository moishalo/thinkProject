package com.moishalo.thread;

/**
 * @Title: Account.java
 * @Package com.moishalo.thread
 * @Description: 多线程并发操作的用户银行账户
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-6 下午4:02:41
 * @version V1.0
 */
public class Account {
	private String code;
	private int cash;

	public Account(String code, int cash) {
		this.code = code;
		this.cash = cash;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 业务方法
	 * 
	 * @param x
	 *            添加x万元
	 */
	public void oper(int x) {
		try {
			Thread.sleep(25);
			this.cash += x;
			System.out.println(Thread.currentThread().getName() + "运行结束，增加“"
					+ x + "”，当前用户账户余额为：" + cash);
			Thread.sleep(10L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "User{" + "code='" + code + '\'' + ", cash=" + cash + '}';
	}
}
