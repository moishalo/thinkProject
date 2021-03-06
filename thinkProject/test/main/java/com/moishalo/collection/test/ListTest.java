package com.moishalo.collection.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.moishalo.testuitl.TestDataGenerateUtil;

/**
 * @Title: ListTest.java
 * @Package com.moishalo.collection.test
 * @Description: List类型的一些测试
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-8-8 下午10:41:47
 * @version V1.0
 */
public class ListTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @Title: testArrayList
	 * @Description: ArrayList的一些方法
	 * @throws
	 */
	@Test
	public void testArrayList() throws InstantiationException,
			IllegalAccessException {
		List list = TestDataGenerateUtil.getRandomIntegerList(10,
				ArrayList.class);
		System.out.println("0:" + list);
		// 增加元素
		list.add(1);
		System.out.println("1:" + list);
		// 判断是否有某个元素
		System.out.println("2:" + list.contains(1));
		// 删除元素，根据引用删除
		list.remove(Integer.valueOf(1));
		System.out.println("3:" + list);
		list.add(1);
		// 获取元素,get
		Integer i = (Integer) list.get(list.size() - 1);
		System.out.println("4:" + i);
		// 获取元素index,indexOf
		i = (Integer) list.indexOf(Integer.valueOf(1));
		System.out.println("5:" + i);
		// 插入到指定位置
		list.add(4, 2);
		System.out.println("6:" + list);
		// 根据index取子集
		List subList = list.subList(2, 6);
		System.out.println(subList);
		// 排序
		Collections.sort(subList);
		System.out.println(subList);
		// 打乱顺序
		Collections.shuffle(subList);
		System.out.println(subList);
		// 求交集
		List l1 = TestDataGenerateUtil.getRandomIntegerList(5, ArrayList.class);
		System.out.println(l1);
		List l2 = TestDataGenerateUtil.getRandomIntegerList(6, ArrayList.class);
		System.out.println(l2);
		l1.retainAll(l2);
		System.out.println(l1);
		// 将集合加到指定位置
		l1 = TestDataGenerateUtil.getRandomIntegerList(5, ArrayList.class);
		System.out.println(l1);
		l2 = TestDataGenerateUtil.getRandomIntegerList(6, ArrayList.class);
		System.out.println(l2);
		l1.addAll(3, l2);
		System.out.println(l1);
		// 删除所有元素
		l1.clear();
		System.out.println(l1);
	}

	/**
	 * @Title: linkedListTest
	 * @Description: 学习LinkedList的测试用例,LinkList可以作为Stack、Queue等数据结构
	 *	所以会有重复类型
	 * @param @throws InstantiationException
	 * @param @throws IllegalAccessException 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@Test
	public void linkedListTest() throws InstantiationException,
			IllegalAccessException {
		LinkedList list = (LinkedList) TestDataGenerateUtil
				.getRandomIntegerList(10, LinkedList.class);
		System.out.println("print linkedlist:" + list);
		// 返回第一个元素
		System.out.println("print getFirst:" + list.getFirst());
		// 返回第一个元素,不删除
		System.out.println("print element:" + list.element());
		// 返回第一个元素,不删除
		System.out.println("print peek:" + list.peek());
		System.out.println("print linkedlist:" + list);
		// 返回并删除第一个元素
		System.out.println("print remove:" + list.remove());
		System.out.println("print linkedlist:" + list);
		// 返回并删除第一个元素
		System.out.println("print removeFirst:" + list.removeFirst());
		System.out.println("print linkedlist:" + list);
		//返回并删除第一个元素
		System.out.println("print poll:"+list.poll());
		System.out.println("print linkedlist:" + list);
		
		//在头部增加一个元素
		list.addFirst(new Integer(1));
		System.out.println("print linkedlist:"+list);
		//在尾部增加一个元素
		list.offer(new Integer(0));
		System.out.println("print linked:"+list);
		
		//在尾部增加一个元素
		list.add(new Integer(1));
		System.out.println("print linked:"+list);
		
		//在尾部增加一个元素
		list.add(new Integer(2));
		System.out.println("print linked:"+list);
		
		//返回并删除尾部的一个元素
		System.out.println("print removeLast:"+list.removeLast());
	}
}
