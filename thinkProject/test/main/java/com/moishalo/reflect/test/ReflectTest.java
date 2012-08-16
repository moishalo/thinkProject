package com.moishalo.reflect.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.esotericsoftware.reflectasm.MethodAccess;

/**
 * @Title: ReflectTest.java
 * @Package com.moishalo.reflect.test
 * @Description: 测试反射机制
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
	public void reflectAsmTest(){
		ClassForReflectAsm classForReflectAsm = new ClassForReflectAsm();
		MethodAccess access = MethodAccess.get(ClassForReflectAsm.class);
		access.invoke(classForReflectAsm, "setAsm", "Awesome McLovin");
		String name = (String)access.invoke(classForReflectAsm, "getAsm");
		assertEquals("Awesome McLovin", name);
		System.out.println(name);
		
		access.invoke(classForReflectAsm, "setAbc", "Awesome McLovin");
		String abc = (String)access.invoke(classForReflectAsm, "getAbc");
		assertEquals("Awesome McLovin", abc);
		System.out.println(abc);
	}

}
