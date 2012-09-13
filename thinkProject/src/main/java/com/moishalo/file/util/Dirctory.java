package com.moishalo.file.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import sun.print.PSPrinterJob.PluginPrinter;

/**
 * @Title: Dirctory.java
 * @Package com.moishalo.file.util
 * @Description: 文件工具类
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-9-3 下午9:49:53
 * @version V1.0
 */
public final class Dirctory {
	
	/**
	 * @Title: local
	 * @Description: 根据输入的目录返回符合输入的正则表达式的文件对象数组
	 * @param dir 进行匹配的目录
	 * @param regex 进行匹配的正则表达式
	 * @return 返回符合条件的File数组
	 * @return File[] 返回类型
	 * @throws
	 */
	public static File[] local(File dir, final String regex){
		//通过匿名的FilenameFilter实现类返回符合条件的File数组
		return dir.listFiles(new FilenameFilter(){
			private Pattern pattern = Pattern.compile(regex);
			public boolean accept(File dir,String name){
				return pattern.matcher(new File(name).getName()).matches();
			}
		});
	}
	
	/**
	 * @Title: local
	 * @Description: 接受字符串文件路径的重载
	 * @param path 路径
	 * @param regex 匹配用的正则表达式
	 * @return 返回
	 * @return File[] 返回类型
	 * @throws
	 */
	public static File[] local(String path,final String regex){
		return local(new File(path),regex);
	}
	
	public static class TreeInfo implements Iterable<File>{
		public List<File> files = new ArrayList<File>();
		public List<File> dirs = new ArrayList<File>();
		@Override
		public Iterator<File> iterator() {
			return files.iterator();
		}
		
		void addAll(TreeInfo other){
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}
		
	}
}
