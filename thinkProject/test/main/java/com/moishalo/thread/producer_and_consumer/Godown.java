package com.moishalo.thread.producer_and_consumer;

/**
 * @Title: Godown.java
 * @Package com.moishalo.thread.producer_and_consumer
 * @Description: 生产消费者模型场景的库存类，生产线程和消费线程轮流访问该类对象的生产和消费方法
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date Oct 9, 2012 11:06:54 PM
 * @version V1.0
 */
public class Godown {

	private int max = 100;
	private int count = 0;
	
	public Godown(int count){
		this.count = count;
	}

	public synchronized void getCount() {

	}

	public synchronized void produce(int need) {
		while (need + count > max) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count += need;
		System.out.println("production complete, produce " + need
				+ " products. godown is " + count + ".");
		notifyAll();
	}

	public synchronized void consume(int need) {
		while (need > count) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count -= need;
		System.out.println("consume complete, consume " + need
				+ " products. godown is " + count + ".");
		notifyAll();
	}
	
	public static void main(String[] args){
		Godown godown = new Godown(50);
		
		Thread p1 = new Thread(new Producer(godown,30));
		Thread p2 = new Thread(new Producer(godown,20));
		Thread p3 = new Thread(new Producer(godown,10));
		Thread p4 = new Thread(new Producer(godown,40));
		Thread p5 = new Thread(new Producer(godown,10));
		
		Thread c1 = new Thread(new Consumer(godown, 10));
		Thread c2 = new Thread(new Consumer(godown, 60));
		Thread c3 = new Thread(new Consumer(godown, 20));
		Thread c4 = new Thread(new Consumer(godown, 30));
		Thread c5 = new Thread(new Consumer(godown, 10));
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
	}
}
