package com.moishalo.thread.producer_and_consumer;
/**
 * @Title: Producer.java
 * @Package com.moishalo.thread.producer_and_consumer
 * @Description: 消费者生产者模型中的生产者类
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date Oct 9, 2012 11:26:13 PM
 * @version V1.0
 */
public class Producer implements Runnable {
	private Godown godown;
	
	private int need;
	
	public Producer(Godown godown,int need){
		this.godown = godown;
		this.need = need;
	}

	@Override
	public void run() {
		godown.produce(need);
	}

}
