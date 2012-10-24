package com.moishalo.thread.java5;


/**
 * @Title: Bank.java
 * @Package com.moishalo.thread.java5
 * @Description: 多线程操作的银行对象，进行现金存取，方法中没有同步，多线程对象通过lock进行同步操作
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date Oct 10, 2012 12:14:05 AM
 * @version V1.0
 */
public class Bank {
	private int cash;
	
	public Bank(int cash){
		this.cash = cash;
	}
	
	public void operate(int cash){
		this.cash += cash;
	}
	
	public int getCash(){
		return cash;
	}

}
