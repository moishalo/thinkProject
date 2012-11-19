package com.moishalo.thread.producer_and_consumer;

/**
 * @Title: Consumer.java
 * @Package com.moishalo.thread.producer_and_consumer
 * @Description: TODO(添加描述)
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date Oct 9, 2012 11:42:20 PM
 * @version V1.0
 */
public class Consumer implements Runnable {
	private Godown godown;

	private int need;

	public Consumer(Godown godown, int need) {
		this.godown = godown;
		this.need = need;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		godown.consume(need);
	}

}
