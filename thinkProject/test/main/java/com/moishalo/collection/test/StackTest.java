package com.moishalo.collection.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.moishalo.testuitl.TestDataGenerateUtil;

/**
 * @Title: StackTest.java
 * @Package com.moishalo.collection.test
 * @Description: 学习Stack的测试用例
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-8-18 下午6:15:16
 * @version V1.0
 */
public class StackTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * @Title: stackTest
	 * @Description: Stack学习测试用例
	 * @param @throws InstantiationException
	 * @param @throws IllegalAccessException 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@Test
	public void stackTest() throws InstantiationException,
			IllegalAccessException {
		Stack stack = new Stack();
		List list = new TestDataGenerateUtil().getRandomIntegerList(10,
				ArrayList.class);
		for (Object i : list) {
			stack.push(i);
			System.out.println("print stack.push:" + stack);
		}
		while (!stack.empty()) {
			Object i = stack.pop();
			System.out.println("print stack.pop:" + i);
		}
		Stack<Integer> stack2 = new Stack<Integer>();
		List list2 = new TestDataGenerateUtil().getRandomIntegerList(10,
				ArrayList.class);
		for (Object i : list2) {
			stack2.push((Integer) i);
			System.out.println("print stack2.push:" + stack2);
		}
		while (!stack2.empty()) {
			Integer i = stack2.pop();
			System.out.println("print stack2.pop:" + i);
		}
	}

}
