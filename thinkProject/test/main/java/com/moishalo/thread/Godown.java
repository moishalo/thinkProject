package com.moishalo.thread;

/**
 * @Title: Godown.java
 * @Package com.moishalo.thread
 * @Description: TODO(添加描述)
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-6 下午10:52:56
 * @version V1.0
 */
public class Godown {
	public static void main(String[] args){
		Godown godown = new Godown(30); 
        Consumer c1 = godown.new Consumer(50, godown); 
        Consumer c2 = godown.new Consumer(20, godown); 
        Consumer c3 = godown.new Consumer(30, godown); 
        Producer p1 = godown.new Producer(10, godown); 
        Producer p2 = godown.new Producer(10, godown); 
        Producer p3 = godown.new Producer(10, godown); 
        Producer p4 = godown.new Producer(10, godown); 
        Producer p5 = godown.new Producer(10, godown); 
        Producer p6 = godown.new Producer(10, godown); 
        Producer p7 = godown.new Producer(80, godown); 

        c1.start(); 
        c2.start(); 
        c3.start(); 
        p1.start(); 
        p2.start(); 
        p3.start(); 
        p4.start(); 
        p5.start(); 
        p6.start(); 
        p7.start(); 
	}
	
	public static final int max_size = 100; // 最大库存量
	public int curnum; // 当前库存量

	private Godown() {
	}

	public Godown(int curnum) {
		this.curnum = curnum;
	}

	public void produce(int neednum) {
		synchronized (this) {
			while (neednum + curnum > max_size) {
				try {
					System.out.println("目前库存量：" + curnum);
					System.out.println("生产需求：" + neednum);
					System.out.println("生产需求超过库存量，暂时不能执行生产任务");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			curnum += neednum;
			System.out.println("生产了" + neednum + "个产品，目前库存为" + curnum);
		}
		this.notifyAll();
	}

	public void consume(int neednum) {
		synchronized (this) {
			while(curnum<neednum){
				System.out.println("目前库存量：" + curnum);
				System.out.println("消费需求：" + neednum);
				System.out.println("消费需求超过库存量，暂时不能执行生产任务");
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			curnum -= neednum;
			System.out.println("已经消费了" + neednum + "个产品，现仓储量为" + curnum); 
		}
		notifyAll();
	}
	
	/** 
	* 生产者 
	*/ 
	class Producer extends Thread { 
	        private int neednum;                //生产产品的数量 
	        private Godown godown;            //仓库 

	        Producer(int neednum, Godown godown) { 
	                this.neednum = neednum; 
	                this.godown = godown; 
	        } 

	        public void run() { 
	                //生产指定数量的产品 
	                godown.produce(neednum); 
	        } 
	} 

	/** 
	* 消费者 
	*/ 
	class Consumer extends Thread { 
	        private int neednum;                //生产产品的数量 
	        private Godown godown;            //仓库 

	        Consumer(int neednum, Godown godown) { 
	                this.neednum = neednum; 
	                this.godown = godown; 
	        } 

	        public void run() { 
	                //消费指定数量的产品 
	                godown.consume(neednum); 
	        } 
	}
}
