package com.moishalo.testuitl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hamcrest.core.IsInstanceOf;

/**
 * @Title: TestDataGenerateUtil.java
 * @Package com.moishalo.testuitl
 * @Description: 测试数据产生工具
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-8-8 下午11:27:39
 * @version V1.0
 */
public class TestDataGenerateUtil {
	/**
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @Title: getRandomIntegerList
	 * @Description: 根据时间随机生成Integer类型的list
	 * @param size
	 *            返回的list的大小
	 * @return List 返回类型
	 * @throws
	 */
	public static List getRandomIntegerList(int size, Class clazz) throws InstantiationException, IllegalAccessException {
		Object result = clazz.newInstance();
		if (result instanceof List) {
			List list = (List) result;
			Random random = new Random(System.nanoTime());
			while (0 < size) {
				list.add(random.nextInt());
				--size;
			}
			return 0 == list.size() ? null : list;
		}else {
			return null;
		}

	}
}
