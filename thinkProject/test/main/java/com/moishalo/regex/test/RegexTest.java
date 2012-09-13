package com.moishalo.regex.test;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Title: RegexTest.java
 * @Package com.moishalo.regex.test
 * @Description: 正则表达式联系
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-9-7 下午4:19:59
 * @version V1.0
 */
public class RegexTest {
	Logger logger;
	@Before
	public void setUp() throws Exception {
		logger = LoggerFactory.getLogger(this.getClass());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String uri = "/test/testChain/index";
		String[] strs = uri.split("/");
		for (String s : strs)
			System.out.println("s:" + s);
	}

	@Test
	public void regTest() {
		String context0 = "/test";
		String context1 = "test";
		String context2 = "/test_test";
		String context3 = "test_test";
		
		String uri0 = "/test/testChain/index";
		String uri1 = "test/testChain/index";
		String uri2 = "/testChain/index";
		String uri3 = "testChain/index";
		String uri4 = "/test_test/test_testChain/index";
		String uri5 = "test_test/test_testChain/index";
		String uri6 = "/test_testChain/index";
		String uri7 = "test_testChain/index";
		
		String result = "/testChain/index";
		
		assertEquals(result, resolveUri(uri0, context0));
		assertEquals(result, resolveUri(uri1, context0));
		assertEquals(result, resolveUri(uri2, context0));
		assertEquals(result, resolveUri(uri3, context0));
		
		assertEquals(result, resolveUri(uri4, context2));
		assertEquals(result, resolveUri(uri5, context2));
		assertEquals(result, resolveUri(uri6, context2));
		assertEquals(result, resolveUri(uri7, context2));
		
		assertEquals(result, resolveUri(uri4, context3));
		assertEquals(result, resolveUri(uri5, context3));
		assertEquals(result, resolveUri(uri6, context3));
		assertEquals(result, resolveUri(uri7, context3));
	}

	private String resolveUri(String uri, String context) {
		if(logger.isDebugEnabled()){
			logger.debug("Router开始解析uri");
			logger.debug("请求的uri:"+uri);
			logger.debug("应用的context:"+context);
		}
		
		String perfix ="/";
		//处理传入的上下文根,如果没有以"/"开头，将"/"拼接到前面
		if(!context.startsWith(perfix)){
			context = perfix + context;
		}
		
		//处理传入的uri,如果没有以"/"开头，将"/"拼接到前面
		if(!uri.startsWith(perfix)){
			uri = perfix + uri;
		}
		
		String result = uri;
		// 定义正则表达式
		Pattern pattern = Pattern.compile("/?.+", Pattern.CASE_INSENSITIVE);

		Matcher matcher = pattern.matcher(uri);

		if (matcher.find()) {
			if(logger.isDebugEnabled()){
				logger.debug("matcher group:" + matcher.group());
			}
			
			// 判断第一分组是否与上下文根一致，一致的话，去掉上下文根
			if (context.equals(matcher.group(0))) {
				result = matcher.replaceFirst("");
			}
		} else {
			if(logger.isDebugEnabled()){
				logger.debug("matcher not find");
			}
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("解析后的uri为:" + result);
		}
		
		return result;
	}
}
