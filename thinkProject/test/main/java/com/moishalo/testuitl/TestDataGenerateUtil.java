package com.moishalo.testuitl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	 * @Title: getRandomIntegerList
	 * @Description: 根据时间随机生成Integer类型的list
	 * @param size 返回的list的大小
	 * @return List    返回类型
	 * @throws
	 */
	public static List getRandomIntegerList(int size){
		List result = new ArrayList();
		Random random = new Random(System.nanoTime());
		while(0<size){
			result.add(random.nextInt());
			--size;
		}
		return 0 == result.size() ? null : result;
	}
}
