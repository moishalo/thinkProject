package com.moishalo.io.test;

import static org.junit.Assert.*;

import hidden.org.codehaus.plexus.util.StringOutputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberInputStream;
import java.io.OutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Title: StreamTest.java
 * @Package com.moishalo.io.test
 * @Description: 学习java流
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-9-10 下午11:55:43
 * @version V1.0
 */
public class StreamTest {

	//InputStream
	//OutputStream
	//FileInputStream
	//FileOutputStream
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * @Title: fileInputStreamTest
	 * @Description: 测试从文件中读取流，然后写到Stirng流中，最后打印
	 * @throws IOException 参数及返回值
	 * @return void 返回类型
	 * @throws
	 */
	@Test
	public void fileInputStreamTest() throws IOException {
		//基本inputstream包括:
		//ByteArrayInputStream
		//StringBufferInputStream
		//FileInputStream
		//PipedInputStream
		//SequenceInputStream
		//FilterInputStream
		
		//基本outputstream包括:
		//ByteArrayOutputStream
		//FileOutputStream
		//PipedOutputStream
		//FilterOutputStream
		
		//创建FileInputStream
		InputStream in = new FileInputStream("./test/main/resources/log4j.properties");
		int i = 0;
		//创建OutPutStream
		StringOutputStream out = new StringOutputStream();
		while(-1!=i){
			//一次读取一个字节
			i = in.read();
			Integer oi = new Integer(i);
			byte b= oi.byteValue();
			System.out.println(i);
			System.out.println(b);
			if(-1!=i)
				out.write(i);
		}
		out.flush();
		in.close();
		out.close();
		String s = out.toString();
		System.out.println(s);
		
		//通过缓存来增加读取效率
		
		in = new FileInputStream("./test/main/resources/log4j.properties");
		byte[] buffer = new byte[64];
		
		out = new StringOutputStream();
		int length =0;
		while(-1!=length){
			length = in.read(buffer);
			if(-1 == length)
				break;
			printByte(buffer);
			System.out.println();
			out.write(buffer,0,length);
			out.flush();
		}
		s = out.toString();
		out.close();
		in.close();
		System.out.println(s);
		
	}
	
	@Test
	public void decoratorTest() throws IOException{
		//通过装饰器模式提供高级功能的InputStream
		//DataInputStream
		//BufferedInputStream
		//LineNumberInputStream
		//PushbackInputStream
		
		//通过装饰器模式提供高级功能的InputStream
		//DataOutputStream
		//PrintStream
		//BufferedOutputStream
		
		//测试BufferedInputStream和BufferedOutputStream
		//验证如果不调用flush不将缓冲区内的内容读到Stream中
		InputStream in = new BufferedInputStream(new FileInputStream("./test/main/resources/log4j.properties"));
		OutputStream out1 = new StringOutputStream();
		BufferedOutputStream out = new BufferedOutputStream(out1);
		byte[] b=new byte[64];
		
		readAndWrite(in, out, out1);
		in.close();
		out.close();
		
		System.out.println("---------------------------------------------------");
		
		in = new LineNumberInputStream(new FileInputStream("./test/main/resources/log4j.properties"));
		out1 = new StringOutputStream();
		DataOutputStream out2 = new DataOutputStream(out1);
		readAndWrite(in, out2,out1);
	}
	
	private void readAndWrite(InputStream in, OutputStream out,OutputStream orgrin) throws IOException{
		byte[] b=new byte[64];
		
		int length = 0;
		
		while(length!=-1){
			length = in.read(b);
			printByte(b);
			if(length!=-1){
				out.write(b, 0, length);
			}
			out.flush();
			System.out.println(orgrin.toString());
		}
		in.close();
		out.close();
	}
	
	private void printByte(byte[] bytes){
		for(byte b:bytes){
			System.out.print(b);
		}
		System.out.println();
	}

	
}
