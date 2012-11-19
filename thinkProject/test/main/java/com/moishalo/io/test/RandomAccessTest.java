package com.moishalo.io.test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Title: RandomAccessTest.java
 * @Package com.moishalo.io.test
 * @Description: TODO(添加描述)
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-26 下午3:31:27
 * @version V1.0
 */
public class RandomAccessTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		byte[] in;
		String test = "动力方面，雅力士混动版将搭载HSD混合动力系统，这套系统由最大功率75马力的1.5L发动机和电动机组成，综合最大功率101马力。这款车的最高车速176公里/小时，百公里加速约需12秒。传动系统为CVT变速器。";
		in = test.getBytes();
		byte[] out = new byte[in.length];
		InputStream is = new ByteArrayInputStream(in);
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		int partLen = (int) Math.ceil(in.length/5);
		ExecutorService pool = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			Processor processor = new Processor(is, os, i*partLen, partLen);
			pool.execute(new Thread(processor));
		}
		pool.execute(new Thread(new Monitor(os)));
		
		while(true);
	}
	@Test
	public void testOut() throws IOException{
		byte[] in;
		String test = "动力方面，雅力士混动版将搭载HSD混合动力系统，这套系统由最大功率75马力的1.5L发动机和电动机组成，综合最大功率101马力。这款车的最高车速176公里/小时，百公里加速约需12秒。传动系统为CVT变速器。";
		in = test.getBytes();
		byte[] out = new byte[in.length];
		InputStream is = new ByteArrayInputStream(in);
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		
		is.read(out, 0, 10);
		os.write(out, 0, 10);
		os.flush();
		byte[] a = os.toByteArray();
	}
	

	class Processor implements Runnable{
		private InputStream is;
		private OutputStream os;
		private int startPos;
		private int length;
		
		Processor(InputStream is, OutputStream os,int startPos,int length) {
			this.is = is;
			this.os = os;
			this.startPos = startPos;
			this.length = length;
		}

		@Override
		public void run() {
			int offset =0;
			int len = 10;
			int lenCount = 0;
			byte[] buf = new byte[1024];
			try {
				do{
					int t = length - lenCount;
					if(t==0)
						break;
					if(t<10)
						len =t;
					
					len = is.read(buf, 0, len);
					os.write(buf, 0, len);
					offset += len;
					lenCount += len;
				}while(len!=-1 && lenCount<length+len);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	class Monitor implements Runnable{
		private ByteArrayOutputStream os;
		Monitor(ByteArrayOutputStream os) {
			this.os =os;
		}
		@Override
		public void run() {
			while(true){
				try {
					byte[] out = os.toByteArray();
					InputStream is = new ByteArrayInputStream(out);
					InputStreamReader reader = new InputStreamReader(is);
					char[] c = new char[out.length];
					reader.read(c, 0, out.length);
					String s  = new String(c);
					System.out.println(s);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
