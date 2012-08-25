package com.moishalo.properties.test;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * @Title: SortedProperties.java
 * @Package com.moishalo.properties.test
 * @Description: 可排序的Properties
 * @author bruce bruce_cage@yahoo.cn
 * @date 2012-8-24 下午1:12:10
 * @version V1.0
 */
public class SortedProperties extends Properties {
	@SuppressWarnings("unchecked")
    public synchronized Enumeration keys() {
        Enumeration keysEnum = super.keys();
        Vector keyList = new Vector();
        while (keysEnum.hasMoreElements()) {
            keyList.add(keysEnum.nextElement());
        }
        Collections.sort(keyList);
        return keyList.elements();
    }
}
