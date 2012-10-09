package com.moishalo.thread.java5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title: ExecutorTest.java
 * @Package com.moishalo.thread.java5
 * @Description: TODO(添加描述)
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-6 下午11:48:52
 * @version V1.0
 */
public class ExecutorTest {
	

	public static void main(String[] args){
		ExecutorService pool = Executors.newFixedThreadPool(2);
		ExecutorTest test = new ExecutorTest();
		Thread t1 = test.new MyThread(); 
        Thread t2 = test.new MyThread(); 
        Thread t3 = test.new MyThread(); 
        Thread t4 = test.new MyThread(); 
        Thread t5 = test.new MyThread(); 
        //将线程放入池中进行执行 
        pool.execute(t1); 
        pool.execute(t2); 
        pool.execute(t3); 
        pool.execute(t4); 
        pool.execute(t5); 
        //关闭线程池 
        pool.shutdown(); 
        
        pool = Executors.newCachedThreadPool();
        
        t1 = test.new MyThread(); 
        t2 = test.new MyThread(); 
        t3 = test.new MyThread(); 
        t4 = test.new MyThread(); 
        t5 = test.new MyThread(); 
        //将线程放入池中进行执行 
        pool.execute(t1); 
        pool.execute(t2); 
        pool.execute(t3); 
        pool.execute(t4); 
        pool.execute(t5); 
        //关闭线程池 
        pool.shutdown(); 
	}
	class MyThread extends Thread {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + "正在执行。。。");
		}
	}
}
