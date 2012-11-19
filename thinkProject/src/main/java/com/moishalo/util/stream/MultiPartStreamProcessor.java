package com.moishalo.util.stream;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 * @Title: MultiPartStreamProcessor.java
 * @Package
 * @Description: 分块的Stream处理器，为多线程分块下载、上传使用
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-25 下午1:18:49
 * @version V1.0
 */
public class MultiPartStreamProcessor {
	protected InputAdapter inputAdapter;
	protected OutputAdapter outputAdapter;
	protected int length;
	protected int maxThread;

	public MultiPartStreamProcessor(InputAdapter inputAdapter,
			OutputAdapter outputAdapter, final int maxThread, final int length) {
		this.inputAdapter = inputAdapter;
		this.outputAdapter = outputAdapter;
		this.maxThread = maxThread;
	}

	public void process() throws IOException {
		int partLen = (int) Math.ceil(length/maxThread);
		ExecutorService pool = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			Processor processor = new Processor(inputAdapter, outputAdapter, i*partLen, partLen);
			pool.submit(processor);
		}
	}

	private class Processor implements Callable<Integer> {
		int offset;
		int length;
		InputAdapter inputAdapter;
		OutputAdapter outputAdapter;

		Processor(InputAdapter inputAdapter, OutputAdapter outputAdapter,
				int offset, int length) {
			this.inputAdapter = inputAdapter;
			this.outputAdapter = outputAdapter;
			this.offset = offset;
			this.length = length;
		}

		@Override
		public Integer call() throws Exception {
			try{
				byte[] buf = new byte[1024];
				int off = 0;
				int len = 1024;
				int lenCount = 0;
				do {
					if(length - lenCount == 0)
						break;
					if(length - lenCount<1024)
						len = 1024;
	               length = inputAdapter.read(buf, 0, length);
	               outputAdapter.write(buf, 0, length);
	               lenCount+=length;
	            }while(lenCount < length);
			}catch(RuntimeException e){
				e.printStackTrace();
				return -1;
			}
			
			return 1;
		}
	}
}
