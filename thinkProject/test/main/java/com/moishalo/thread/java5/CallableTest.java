package com.moishalo.thread.java5;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Title: CallableTest.java
 * @Package com.moishalo.thread.java5
 * @Description: TODO(添加描述)
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-7 上午12:17:27
 * @version V1.0
 */
public class CallableTest {

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 *            参数及返回值
	 * @return void 返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		ExecutorService pool = Executors.newCachedThreadPool();
		CallableTest test = new CallableTest();
		Callable c1 = test.new CallableImpl();
		Callable c2 = test.new CallableImpl();
		// 执行任务并获取Future对象
		Future f1 = pool.submit(c1);
		Future f2 = pool.submit(c2);
		// 从Future对象上获取任务的返回值，并输出到控制台
		try {
			System.out.println(">>>" + f1.get().toString());
			System.out.println(">>>" + f2.get().toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 关闭线程池
		pool.shutdown();

	}

	class CallableImpl implements Callable<String> {

		@Override
		public String call() throws Exception {

			return "我是返回的值";
		}

	}

}
