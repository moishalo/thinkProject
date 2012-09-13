package com.moishalo.collection.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

	/**
	 * @Title: setTest
	 * @Description: 测试set，hashset使用散列函数确定对象存储位置
	 * @param @throws InstantiationException
	 * @param @throws IllegalAccessException 
	 * @return void    返回类型
	 * @throws
	 */
	@Test
	public void setTest() throws InstantiationException, IllegalAccessException {
		Set set = new HashSet();
		List list = TestDataGenerateUtil.getRandomIntegerList(10, ArrayList.class);
		Iterator it =list.iterator();
		while(it.hasNext()){
			set.add(it.next());
			System.out.println("pring set:"+set);
		}
	}
	
	/**
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @Title: treeSetTest
	 * @Description: 学习使用treeset，treeset可以对结果排序，元素存储在红-黑树中
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@Test
	public void treeSetTest() throws InstantiationException, IllegalAccessException{
		Set set = new TreeSet();
		List list = TestDataGenerateUtil.getRandomIntegerList(10, ArrayList.class);
		Iterator it =list.iterator();
		while(it.hasNext()){
			set.add(it.next());
			System.out.println("pring set:"+set);
		}
	}
	
	@Test
	public void setOperateTest() throws InstantiationException, IllegalAccessException{
		//准备set数据
		Set set = new HashSet();
		List list = TestDataGenerateUtil.getRandomIntegerList(10, ArrayList.class);
		Iterator it =list.iterator();
		while(it.hasNext()){
			set.add(it.next());
			System.out.println("pring set:"+set);
		}
		
		//开始测试set的操作
		
		//增加一个对象
		Integer obj = new Integer(0);
		set.add(obj);
		
		System.out.println(set.contains(obj));
		System.out.println(set.contains(new Integer(0)));
		
	}
	
}
