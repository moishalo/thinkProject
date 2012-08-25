package com.moishalo.properties.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

import org.apache.velocity.texen.util.PropertiesUtil;

/**
 * @Title: PropertiesFileUtil.java
 * @Package com.moishalo.properties.test
 * @Description: 操作properties文件的工具类
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-8-24 下午1:04:12
 * @version V1.0
 */
public class PropertiesFileUtil {

	

	public static void writeProperties(String filePath, Properties properties) {
		try {
			OutputStream ops = new FileOutputStream(filePath);
			properties.store(ops, "set");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Properties readPropertiesAndSort(String filePath) {
		Properties properties = new SortedProperties();
		try {
			InputStream inputStream = new BufferedInputStream(
					new FileInputStream(filePath));
			properties.load(inputStream);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
