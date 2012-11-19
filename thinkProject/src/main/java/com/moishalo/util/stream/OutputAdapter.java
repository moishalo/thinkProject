package com.moishalo.util.stream;

import java.io.Closeable;

/**
 * @Title: OutputStreamAdepter.java
 * @Package com.moishalo.util.stream
 * @Description: 输入出流的代理器
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-25 下午1:21:23
 * @version V1.0
 */
public interface OutputAdapter extends Closeable{
	public void seek(long pos);
	public void write(byte[] buf, int startPos, int endPos);
}
