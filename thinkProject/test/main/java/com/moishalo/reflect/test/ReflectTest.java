package com.moishalo.reflect.test;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.esotericsoftware.reflectasm.FieldAccess;
import com.esotericsoftware.reflectasm.MethodAccess;

/**
 * @Title: ReflectTest.java
 * @Package com.moishalo.reflect.test
 * @Description: 测试反射机制,
 * 测试结果,reflect只能访问public的属性或方法
 * 没有太大的实用性.
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-8-16 上午12:01:22
 * @version V1.0
 */
public class ReflectTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(true, new TestSubClass() instanceof ITestInterface);
		assertEquals(true, new TestSubClass() instanceof TestSupperClass);
		System.out.println(TestSubClass.class.getGenericSuperclass());
	}
	
	@Test
	public void reflectAsmTest() throws NoSuchMethodException, NoSuchFieldException{
		ClassForReflectAsm classForReflectAsm = new ClassForReflectAsm();
		MethodAccess access = MethodAccess.get(ClassForReflectAsm.class);
		access.invoke(classForReflectAsm, "setAsm", "Awesome McLovin");
		
		String name = (String)access.invoke(classForReflectAsm, "getAsm");
		assertEquals("Awesome McLovin", name);
		System.out.println(name);
		
		FieldAccess fAccess = FieldAccess.get(ClassForReflectAsm.class);
		String[] fieldNames = fAccess.getFieldNames();
		for(String fieldName : fieldNames){
			String setMethodName = getSetMethodName(fieldName);
			System.out.println(setMethodName);
			
			ClassForReflectAsm classForReflectAsm2 = new ClassForReflectAsm();
			MethodAccess mAccess = MethodAccess.get(ClassForReflectAsm.class);
			mAccess.invoke(classForReflectAsm2, setMethodName, setMethodName);
			
			String name2 = (String)mAccess.invoke(classForReflectAsm2, "getAsm");
			assertEquals(setMethodName, name2);
			System.out.println(name2);
		}
		
		
		access.invoke(classForReflectAsm, "setAbc", "Awesome McLovin");
		String abc = (String)access.invoke(classForReflectAsm, "getAbc");
		assertEquals("Awesome McLovin", abc);
		System.out.println(abc);
	}
	
	/**
	 * 根据字段名得到set方法
	 * 
	 * @param clazz
	 * @param fieldName	字段名称
	 * @return
	 * 
	 * @throws NoSuchFieldException
	 * @throws NoSuchMethodException
	 */
	public String getSetMethodName(String fieldName) throws NoSuchMethodException,
			NoSuchFieldException {
		String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
		return methodName;
	}

}
