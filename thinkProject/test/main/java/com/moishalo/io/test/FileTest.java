package com.moishalo.io.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: FileTest.java
 * @Package com.moishalo.io.test
 * @Description: JavaIO学习，File类型的使用学习
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-8-27 下午10:30:40
 * @version V1.0
 */
public class FileTest {
	
	Logger logger;

	@Before
	public void setUp() throws Exception {
		logger = LoggerFactory.getLogger(this.getClass());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void fileListTest() {
		File path = new File(".");
		//返回目录下所有目录或文件的列表
		String[] list = path.list();
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for(String dirOrFile : list){
			System.out.println(dirOrFile);
		}
	}
	
	@Test
	public void nameFilterTest(){
		String regex = "\\.\\w*";
		File path = new File(".");
		//匹配所有以.开头的文件或文件夹(linux隐藏文件或文件夹)
		String[] list = path.list(new DirFilter(regex));
		
		//打印匹配结果
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for(String dirOrFile : list){
			System.out.println(dirOrFile);
		}
	}
	
	@Test
	public void fileDirTest(){
		File file = new File(".");
		fileInfo(file);
	}
	
	@Test
	public void fileCrudTest() throws IOException{
		File file = new File("./newFile.file");
		if(file.exists()){
			file.delete();
			logger.debug("文件删除");
		}else{
			file.createNewFile();
		}
	}
	
	@Test
	public void mkDirTest(){
		File file = new File("./filetest");
		file.mkdir();
		logger.debug(file.getAbsolutePath());
		if(file.exists()){
			logger.debug("创建文件夹成功");
			file.delete();
		}
	}
	
	private void fileInfo(File f){
		String type = f.isFile()?"文件":"目录";
		logger.debug(type+"绝对路径:"+f.getAbsolutePath());
		logger.debug(type+"是否只读:"+f.canRead());
		logger.debug(type+"是否可写:"+f.canWrite());
		logger.debug(type+"名:"+f.getName());
		logger.debug(type+"上级目录:"+f.getParent());
		logger.debug(type+"路径:"+f.getPath());
		logger.debug(type+"长度:"+f.length());
		logger.debug(type+"最后修改时间:"+f.lastModified());
	}

}
