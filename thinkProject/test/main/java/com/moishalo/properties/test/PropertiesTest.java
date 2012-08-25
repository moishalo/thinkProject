package com.moishalo.properties.test;

import static org.junit.Assert.*;

import java.util.Properties;

import org.apache.velocity.texen.util.PropertiesUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Title: PropertiesTest.java
 * @Package com.moishalo.properties.test
 * @Description: 用来测试properties类型
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-8-24 下午1:13:24
 * @version V1.0
 */
public class PropertiesTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String propertiesInputFilePath = "E:\\temp\\starflowIn\\messages.properties";
		String propertiesOutputFilePath = "E:\\temp\\starflowOut\\messages.properties";
		Properties properties = PropertiesFileUtil.readPropertiesAndSort(propertiesInputFilePath);
		PropertiesFileUtil.writeProperties(propertiesOutputFilePath, properties);
	}

}
