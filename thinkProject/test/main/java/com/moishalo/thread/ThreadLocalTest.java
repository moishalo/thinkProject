package com.moishalo.thread;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Title: ThreadLocalTest.java
 * @Package com.moishalo.thread
 * @Description: TODO(添加描述)
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-11-19 下午9:40:33
 * @version V1.0
 */
public class ThreadLocalTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testThreadLocal(){
		ClassUseThreadLocal c = new ClassUseThreadLocal();
		Thread t1 = new Thread(new RunableExt(c));
		Thread t2 = new Thread(new RunableExt(c));
		Thread t3 = new Thread(new RunableExt(c));
		Thread t4 = new Thread(new RunableExt(c));
		Thread t5 = new Thread(new RunableExt(c));
		Thread t6 = new Thread(new RunableExt(c));
		Thread t7 = new Thread(new RunableExt(c));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
			t7.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.exit(0);
	}
	
	static class ClassUseThreadLocal{
		private ThreadLocal<String> localVar = new ThreadLocal<String>(){
			@Override
			protected String initialValue() {
				return "Thread Name:" + Thread.currentThread().getName();
			};
		};
		
		public String getName(){
			return localVar.get();
		}
	}
	
	static class RunableExt implements Runnable{
		private ClassUseThreadLocal c;
		public RunableExt(ClassUseThreadLocal c){
			this.c = c;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(c.getName());
		}
		
	}
}
