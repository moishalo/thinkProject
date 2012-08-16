package com.moishalo.sql.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Title: SqlMainTest.java
 * @Package com.moishalo.sql.test
 * @Description: 测试Sql
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-8-16 下午6:14:50
 * @version V1.0
 */
public class SqlMainTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getTableName() {
		String sql = "insert into RO_AUDIT (ACT_ID,ACTOR, USERID,PERSONUUID, ORGNAME,ORGUUID,ENROLLED_ORG, ENROLLED_ORGUUID, ACCOUNTTYPE,ACT_RESULT,ACT_ACTION,ACT_CODE,ACT_ITEM_NUM,ACT_ITEM_CODE,ACT_OBJ, ACT_TIME, ACT_MESSAGE, ISCLOB,ACT_IP,SIGNATURE ) values (#P,'$ACTOR$','$USERID$','$PERSONUUID$','$ORGNAME$','$ORGUUID$', '$ENROLLED_ORG$','$ENROLLED_ORGUUID$',$ACCOUNTTYPE$,$RESULT$,'$ACTION$','$ACTCODE$', $ITEMNUM$,'$ITEMCODE$','$OBJECT$', %d{LONGDATE}, '#$MESSAGE$#',?,'$IP$',?)";
		sql = sql.toUpperCase();
		int index1 = sql.indexOf("INSERT INTO ");
		int index2 = sql.indexOf(" ", index1+12);
		String tablename = sql.substring(index1 +12, index2);
		System.out.println(tablename);
	}

}
