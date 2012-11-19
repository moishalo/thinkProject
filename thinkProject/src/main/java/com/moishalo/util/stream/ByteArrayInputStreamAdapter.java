package com.moishalo.util.stream;

import java.io.ByteArrayInputStream;

/**
 * @Title: StringInputStreamAdapter.java
 * @Package com.moishalo.util.stream
 * @Description: TODO(添加描述)
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-27 上午12:27:16
 * @version V1.0
 */
public class ByteArrayInputStreamAdapter implements InputAdapter {
	
	ByteArrayInputStream in;
	
	public ByteArrayInputStreamAdapter(ByteArrayInputStream in) {
		this.in = in;
	}

	@Override
	public int read(byte[] buf, int startPos, int endPos) {
		return in.read(buf, startPos, endPos);
	}

}
