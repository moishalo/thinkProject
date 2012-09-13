package com.moishalo.charsetcode.test;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Title: EncodingTest.java
 * @Package com.moishalo.charsetcode.test
 * @Description: TODO(添加描述)
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-9-5 上午11:02:29
 * @version V1.0
 */
public class EncodingTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws UnsupportedEncodingException {
		String gbk = "我是张虎坡";
		
		String utf8 =new String(gbk.getBytes("GBK"),"UTF-8");
		System.out.println(utf8);
	}
	
	@Test
	public void test2() throws UnsupportedEncodingException{
		String str = new String("我是张虎坡");
		byte[] b = str.getBytes("GBK");
		print(b);
		String gbk = new String(b,"UTF-8");
		b = gbk.getBytes("GBK");
		print(b);
		System.out.println(new String(b,"UTF-8"));
		b= gbk.getBytes("UTF-8");
		print(b);
		String utf8 =new String(b,"UTF-8");
		System.out.println(utf8);
		
		String utf82 = new String(gbk.getBytes("UTF-8"));
		String prin = new String(gbk2utf8(utf82));
		System.out.println(prin);
	}
	
	private void print(byte[] b){
		for(int i =0;i<b.length;i++)
			System.out.print(b[i]+" ");
		System.out.println("");
	}
	
	public byte[] gbk2utf8(String chenese){  
	    char c[] = chenese.toCharArray();  
	            byte [] fullByte =new byte[3*c.length];  
	            for(int i=0; i<c.length; i++){  
	             int m = (int)c[i];  
	             String word = Integer.toBinaryString(m);  
	            // System.out.println(word);  
	               
	             StringBuffer sb = new StringBuffer();  
	             int len = 16 - word.length();  
	             //补零  
	             for(int j=0; j<len; j++){  
	              sb.append("0");  
	             }  
	             sb.append(word);  
	             sb.insert(0, "1110");  
	             sb.insert(8, "10");  
	             sb.insert(16, "10");  
	               
//	             System.out.println(sb.toString());  
	               
	             String s1 = sb.substring(0, 8);            
	             String s2 = sb.substring(8, 16);            
	             String s3 = sb.substring(16);  
	               
	             byte b0 = Integer.valueOf(s1, 2).byteValue();  
	             byte b1 = Integer.valueOf(s2, 2).byteValue();  
	             byte b2 = Integer.valueOf(s3, 2).byteValue();  
	             byte[] bf = new byte[3];  
	             bf[0] = b0;  
	             fullByte[i*3] = bf[0];  
	             bf[1] = b1;  
	             fullByte[i*3+1] = bf[1];  
	             bf[2] = b2;  
	             fullByte[i*3+2] = bf[2];  
	               
	            }  
	            return fullByte;  
	    }
	
	
}
