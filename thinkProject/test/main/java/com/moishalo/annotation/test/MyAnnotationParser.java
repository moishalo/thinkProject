package com.moishalo.annotation.test;

import java.lang.reflect.Method;

/**
 * @Title: MyAnnotationParser.java
 * @Package com.moishalo.annotation.test
 * @Description: 注解的解释器,通过反射机制
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-8-22 下午10:38:55
 * @version V1.0
 */
public class MyAnnotationParser {
	public void paserAnnotaiton(Class clazz){
		for(Method method : clazz.getDeclaredMethods()){
			MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
			if(null != annotation){
				System.out.println("annotation id:"+annotation.id());
				System.out.println("annotation description:"+annotation.description());
			}
		}
	}
	
	public int getId(Class clazz,String method) throws SecurityException, NoSuchMethodException{
		Method m = clazz.getMethod(method,void.class);
		MyAnnotation annotation = m.getAnnotation(MyAnnotation.class);
		if(null != annotation){
			return annotation.id();
		}
		return -1;
	}
	
	public String getDescription(Class clazz,String method) throws SecurityException, NoSuchMethodException{
		Method m = clazz.getMethod(method,void.class);
		MyAnnotation annotation = m.getAnnotation(MyAnnotation.class);
		if(null != annotation){
			return annotation.description();
		}
		return null;
	}
}
