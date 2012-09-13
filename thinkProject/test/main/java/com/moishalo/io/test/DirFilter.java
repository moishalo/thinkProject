package com.moishalo.io.test;

import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @Title: DirFilter.java
 * @Package com.moishalo.io.test
 * @Description: 测试用的实现的文件Filter
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-9-2 下午11:13:43
 * @version V1.0
 */
public class DirFilter implements FilenameFilter {
	
	private Pattern pattern;
	
	public DirFilter(String regex){
		pattern =Pattern.compile(regex);
	}

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return pattern.matcher(name).matches();
	}

}
