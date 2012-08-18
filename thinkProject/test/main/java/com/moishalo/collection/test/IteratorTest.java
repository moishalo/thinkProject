package com.moishalo.collection.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.moishalo.testuitl.TestDataGenerateUtil;

/**
 * @Title: IteratorTest.java
 * @Package com.moishalo.collection.test
 * @Description: Iterator测试用例,学习使用
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-8-18 下午12:29:05
 * @version V1.0
 */
public class IteratorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void iteratorTest() throws InstantiationException, IllegalAccessException {
		List arrayList = TestDataGenerateUtil.getRandomIntegerList(10,ArrayList.class);
		Iterator it = arrayList.iterator();
		while(it.hasNext()){
			Integer i =(Integer)it.next();
			System.out.println(i);
			it.remove();
		}
		System.out.println(arrayList);
	}
	
	@Test
	public void listIteratorTest() throws InstantiationException, IllegalAccessException{
		List arrayList = TestDataGenerateUtil.getRandomIntegerList(10,ArrayList.class);
		ListIterator iterator = arrayList.listIterator();
		while (iterator.hasNext()) {
			Integer i =(Integer)iterator.next();
			System.out.println(i);
		}
		while(iterator.hasPrevious()){
			Integer i =(Integer)iterator.previous();
			System.out.println(i);
		}
	}

}
