package com.moishalo.security.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: MessageDigestTest.java
 * @Package com.moishalo.security.test
 * @Description: 信息摘要算法测试
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-24 下午1:41:40
 * @version V1.0
 */
public class MessageDigestTest {

	@Test
	public void md5Test() throws NoSuchAlgorithmException {
		// 待hash的字符串
		String test = "hello security";
		// 加入BouncyCastle的Provider
		Security.addProvider(new BouncyCastleProvider());
		// 获取加密算法的实例
		java.security.MessageDigest alga = java.security.MessageDigest
				.getInstance("MD5");
		// 更新摘要
		alga.update(test.getBytes());
		// 进行摘要算法，返回进行摘要后的字节
		byte[] digest = alga.digest();
		// 打印结果
		String md5 = String.valueOf(digest);
		String test2 = "hello security";
		alga.reset();
		alga.update(test2.getBytes());
		byte[] digest2 = alga.digest();
		Assert.assertTrue(MessageDigest.isEqual(digest, digest2));
		System.out.println(md5);
		System.out.println(byte2hex(digest));
	}
	
	@Test
	public void shaTest() throws NoSuchAlgorithmException {
		// 待hash的字符串
		String test = "hello security";
		// 加入BouncyCastle的Provider
		Security.addProvider(new BouncyCastleProvider());
		// 获取加密算法的实例
		java.security.MessageDigest alga = java.security.MessageDigest
				.getInstance("SHA-1");
		// 更新摘要
		alga.update(test.getBytes());
		// 进行摘要算法，返回进行摘要后的字节
		byte[] digest = alga.digest();
		// 打印结果
		String sha = String.valueOf(digest);
		String test2 = "hello security";
		alga.reset();
		alga.update(test2.getBytes());
		byte[] digest2 = alga.digest();
		Assert.assertTrue(MessageDigest.isEqual(digest, digest2));
		System.out.println(sha);
		System.out.println(byte2hex(digest));
	}

	public String byte2hex(byte[] b) // 二行制转字符串
	{
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
			if (n < b.length - 1)
				hs = hs + ":";
		}
		return hs.toUpperCase();
	}

}
