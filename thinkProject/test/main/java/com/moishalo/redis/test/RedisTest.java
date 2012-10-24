package com.moishalo.redis.test;

import static org.junit.Assert.assertEquals;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.BinaryTransaction;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

/**
 * @Title: RedisTest.java
 * @Package com.moishalo.redis.test
 * @Description: 使用redis的测试用例
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date Oct 17, 2012 11:37:08 AM
 * @version V1.0
 */
public class RedisTest {
	@Before
	public void setUp() throws Exception {
		Jedis jedis = new Jedis("localhost");
		jedis.set("hello", "hello redis");
	}

	@After
	public void tearDown() throws Exception {
		Jedis jedis = new Jedis("localhost");
		jedis.del("hello");
	}

	/**
	 * @Title: test
	 * @Description: Redis的HelloWorld示例
	 * @return void 返回类型
	 * @throws
	 */
	@Test
	public void test() {
		Jedis jedis = new Jedis("localhost");
		String value = jedis.get("hello");
		assertEquals("hello redis", value);
		System.out.println(value);
	}

	/**
	 * @Title: poolTest
	 * @Description: 连接池方式获取Redis链接
	 * @return void 返回类型
	 * @throws
	 */
	@Test
	public void poolTest() {

		JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
		Jedis jedis = pool.getResource();
		try {
			String value = jedis.get("hello");
			assertEquals("hello redis", value);
			System.out.println(value);
		} finally {
			// 进行完操作后，需要讲jedis释放
			pool.returnResource(jedis);
		}
		// 关闭应用程序时，将jedis池关闭
		pool.destroy();

	}

	/**
	 * @Title: transactionTest
	 * @Description: Redis的事物示例
	 * @return void 返回类型
	 * @throws
	 */
	@Test
	public void transactionTest() {
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
		Jedis jedis = pool.getResource();
		jedis.watch("trans");
		BinaryTransaction t = null;
		try {
			t = jedis.multi();
			// 此时将命令加入命令队列，实际并未执行
			t.set("trans".getBytes(), "trans".getBytes());
			int a = 1 / 0;
			// 调用exec时，按照顺序执行能够命令队列中的命令(此示例执行不到此处，由于前一句的除零异常)
			t.exec();
		} catch (RuntimeException e) {
			// 取消事物
			t.discard();
			// 由于事物并未执行，获取key时，返回值为null
			byte[] value = jedis.get("trans".getBytes());
			Assert.assertNull(value);
		} finally {
			// 进行完操作后，需要讲jedis释放
			pool.returnResource(jedis);
		}
		pool.destroy();
	}

	/**
	 * @Title: returnsInTransactionTest
	 * @Description: 测试在事物中获取返回值
	 * @return void 返回类型
	 * @throws
	 */
	@Test
	public void returnsInTransactionTest() {
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
		Jedis jedis = pool.getResource();
		jedis.del("transaction");
		jedis.del("transaction1");
		Transaction t = jedis.multi();
		try {
			t.set("transaction", "transaction");
			Response<String> r1 = t.get("transaction");
			t.set("transaction1", "transaction1");
			Response<String> r2 = t.get("transaction1");

			// 没有进行exec时，没有执行命令，无法获取数据
			// 此时执行下列语句会抛出一个redis.clients.jedis.exceptions.JedisDataException异常
			// r1.get();
			t.exec();

			// 验证执行exec后，可以获取导数据
			String value1 = r1.get();
			String value2 = r2.get();
			Assert.assertEquals("transaction", value1);
			Assert.assertEquals("transaction1", value2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 清理测试用的数据
			jedis.del("transaction");
			jedis.del("transaction1");
			// 释放链接
			pool.returnResource(jedis);
		}
		// 关闭链接池
		pool.destroy();
	}

	/**
	 * @Title: pipelineTest
	 * @Description: 使用管道pipeline可以批量执行Redis命令(在同一个事务中)
	 *               ps:Transaction底层实现就是pipeline
	 * @return void 返回类型
	 * @throws
	 */
	@Test
	public void pipelineTest() {
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
		Jedis jedis = pool.getResource();
		jedis.del("transaction");
		jedis.del("transaction1");
		try {
			Pipeline pipeline = jedis.pipelined();
			pipeline.set("transaction", "transaction");
			Response<String> r1 = pipeline.get("transaction");
			pipeline.set("transaction1", "transaction1");
			Response<String> r2 = pipeline.get("transaction1");

			pipeline.sync();
			// 验证结果
			String value1 = r1.get();
			String value2 = r2.get();
			Assert.assertEquals("transaction", value1);
			Assert.assertEquals("transaction1", value2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jedis.del("transaction");
			jedis.del("transaction1");
			pool.returnResource(jedis);
		}
		pool.destroy();
	}
}
