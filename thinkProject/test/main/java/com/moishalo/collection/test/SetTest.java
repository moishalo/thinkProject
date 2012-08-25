package com.moishalo.collection.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.moishalo.testuitl.TestDataGenerateUtil;

/**
 * @Title: SetTest.java
 * @Package com.moishalo.collection.test
 * @Description: 学习Set的测试用例
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-8-19 上午10:41:06
 * @version V1.0
 */
public class SetTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		Set set = new HashSet();
		List list = TestDataGenerateUtil.getRandomIntegerList(10, ArrayList.class);
		Iterator it =list.iterator();
		while(it.hasNext()){
			set.add(it.next());
			System.out.println("pring set:"+set);
		}
	}

}
