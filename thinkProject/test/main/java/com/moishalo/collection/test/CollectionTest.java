package com.moishalo.collection.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Title: CollectionTest.java
 * @Package com.moishalo.collection.test
 * @Description: Collection使用时的一些测试
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-8-8 下午10:47:03
 * @version V1.0
 */
public class CollectionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * @Title: collectionInitializeTest
	 * @Description: 集合初始化方式比较
	 * @throws
	 */
	@Test
	public void collectionInitializeTest() {
		// 通过Arrays.asList方法初始化一个list，并将这个list作为ArrayList的构造参数，构造一个ArrayList
		long a = System.nanoTime();
		Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(
				1, 2, 3, 4, 5));
		System.out.println("执行耗时 : " + (System.nanoTime() - a) + " 纳秒 ");

		// 通过Collection.addAll方法初始化一个list
		a = System.nanoTime();
		Collection<Integer> c = new ArrayList<Integer>();
		c.addAll(Arrays.asList(6, 7, 8, 9, 10));
		System.out.println("执行耗时 : " + (System.nanoTime() - a) + " 纳秒 ");

		// 通过Collections.addAll方法初始化list
		a = System.nanoTime();
		Collection<Integer> c2 = new ArrayList<Integer>();
		Collections.addAll(c2, 11, 12, 13, 14, 15);
		System.out.println("执行耗时 : " + (System.nanoTime() - a) + " 纳秒 ");
	}

}
