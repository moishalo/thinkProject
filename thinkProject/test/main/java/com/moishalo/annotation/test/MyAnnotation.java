package com.moishalo.annotation.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Title: MyAnnotation.java
 * @Package com.moishalo.annotation.test
 * @Description: 学习annotation创建的注解类
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-8-22 下午10:25:14
 * @version V1.0
 */

//元注解,定义注解可以使用的位置,这里是Method
@Target(ElementType.METHOD)
//元注解,定义注解在哪一个级别可以使用--
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	public int id();
	//描述,有默认值
	public String description() default "no description";
}
