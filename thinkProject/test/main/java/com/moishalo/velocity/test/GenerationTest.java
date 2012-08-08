package com.moishalo.velocity.test;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.moishalo.core.GlobalVaribles;

import antlr.collections.List;

/**
 * @Title: GenerationTest.java
 * @Package com.moishalo.velocity.test
 * @Description: TODO(添加描述)
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-7-31 下午11:11:25
 * @version V1.0
 */
public class GenerationTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void generatStringByTemplate() {
		try {
			//Velocity初始化
			VelocityEngine ve=new VelocityEngine(); 
			//可选值："class"--从classpath中读取，"file"--从文件系统中读取 
			ve.setProperty("resource.loader", "class"); 
			//如果从文件系统中读取模板，那么属性值为org.apache.velocity.runtime.resource.loader.FileResourceLoader 
			ve.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader"); 
			ve.init(); 
			Template template=ve.getTemplate("example.vm"); 
			//定义上下文变量，用来存储参数，对应vm文件中$声明的变量
			VelocityContext context = new VelocityContext();
			context.put("this", "moishalo.zhang");
			ArrayList list = new ArrayList();
			list.add("banana");
			list.add("apple");
			list.add("orange");
			context.put("list", list);
			
			//Template template = null;
			try {
				//template = Velocity.getTemplate("example.vm");
			} catch( ResourceNotFoundException rnfe )
	        {
	            System.out.println("Example : error : cannot find template example.vm");
	        }
	        catch( ParseErrorException pee )
	        {
	            System.out.println("Example : Syntax error in template example.vm:" + pee );
	        }
			
			BufferedWriter writer;
			writer = new BufferedWriter(
	                new OutputStreamWriter(System.out));
			if(null!=template){
				template.merge(context, writer);
			}
//			Velocity.mergeTemplate("example.vm", "ISO-8859-1", context, writer);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void generatWebXml(){
		try {
			VelocityEngine engine = new VelocityEngine();
			engine.setProperty("resource.loader", "class");
			engine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			engine.init();
			
			Template template = engine.getTemplate("web.xml.vm");
			//获取工程路径
			String userDir = System.getProperty("user.dir") ;

			File file = new File(userDir+File.separator+GlobalVaribles.PROJECT_WEBCONTENT+File.separator+"web.xml");
			BufferedWriter writer = null;
			if(!file.exists()){
				writer = new BufferedWriter(new FileWriter(file));
			}
			
			//组织上下文设置变量
			VelocityContext context = new VelocityContext();
			context.put("addStruts2", true);
			
			template.merge(context, writer);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
