package com.moishalo.annotation.test;
/**
 * @Title: ClassUseAnnoation.java
 * @Package com.moishalo.annotation.test
 * @Description: 使用自定义注解的类
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-8-22 下午10:33:32
 * @version V1.0
 */
public class ClassUseAnnoation {
	@MyAnnotation(id=1,description="这个是method1")
	public void myMethod1(){
		
	}
	@MyAnnotation(id=2,description="2,2,2")
	public void myMethod2() {
		
	}
	@MyAnnotation(id=3)
	public void defaultMethod(){
		
	}
}
