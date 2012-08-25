package com.moishalo.annotation.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Title: AnnotationTest.java
 * @Package com.moishalo.annotation.test
 * @Description: 学习注解的测试用例
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-8-22 下午10:50:12
 * @version V1.0
 */
public class AnnotationTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		MyAnnotationParser paser = new MyAnnotationParser();
		paser.paserAnnotaiton(ClassUseAnnoation.class);
	}

}
