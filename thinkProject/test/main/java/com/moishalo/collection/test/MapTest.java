package com.moishalo.collection.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.moishalo.testuitl.TestDataGenerateUtil;

/**
 * @Title: MapTest.java
 * @Package com.moishalo.collection.test
 * @Description: Map学习TestCase
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-9-2 下午10:18:53
 * @version V1.0
 */
public class MapTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * @Title: test
	 * @Description: 统计随机生成的测试数据中重复的结果
	 * @param @throws InstantiationException
	 * @param @throws IllegalAccessException    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		List testData = TestDataGenerateUtil.getRandomIntegerList(100, ArrayList.class);
		Iterator it = testData.iterator();
		Map map = new HashMap();
		
		while(it.hasNext()){
			Integer key = (Integer)it.next();
			Integer value = (Integer)map.get(key);
			//将结果放在map中，如果没有添加过统计结果的，添加1
			//如果添加过的，则统计结果加1
			map.put(key, value == null?new Integer(1):++value);
		}
		
		//打印结果
		Set keys = map.keySet();
		it = keys.iterator();
		while(it.hasNext()){
			Integer key = (Integer)it.next();
			Integer value = (Integer)map.get(key);
			if(value>=2)
				System.out.println(key+":"+value);
		}
	}

}
