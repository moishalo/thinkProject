package com.moishalo.util.stream;
/**
 * @Title: InputStreamAdepter.java
 * @Package com.moishalo.util.stream
 * @Description: 输入流的适配器，可以使用不同的输入流进行数据获取
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-25 下午1:21:08
 * @version V1.0
 */
public interface InputAdapter extends Cloneable{
	public int read(byte[] buf,int startPos,int endPos);
}
