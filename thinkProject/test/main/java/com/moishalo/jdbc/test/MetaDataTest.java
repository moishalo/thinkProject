package com.moishalo.jdbc.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Title: MetaDataTest.java
 * @Package com.moishalo.jdbc.test
 * @Description: TODO(添加描述)
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-9-13 上午11:30:58
 * @version V1.0
 */
public class MetaDataTest {
	
	private String url= "jdbc:oracle:thin:@172.31.5.94:1521:orcl";
	private Properties properties=new Properties(); 
	String driver = "oracle.jdbc.driver.OracleDriver"; 

	

	

	@Before
	public void setUp() throws Exception {
		Class.forName(driver);
		properties.put ("user", "bizuser"); 
		properties.put ("password","bizuser"); 
		properties.put ("ResultSetMetaDataOptions",1); 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws SQLException {
		Connection conn = DriverManager.getConnection(url,properties); 

		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM orgs");
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rmd = rs.getMetaData(); 
		
	}

}
