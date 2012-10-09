package com.moishalo.algorithm.test;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @Title: SelectionSort.java
 * @Package com.moishalo.algorithm.test
 * @Description: 选择排序，从原有数组中选择出最大或最小的
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-2 上午10:59:12
 * @version V1.0
 */
public class SelectionSort {

	@Test
	public void testSelectionSort() {
		fail("Not yet implemented");
	}
	
	public int[] selectionSort(int[] unsort){
		int[] sorted = new int[unsort.length];
		int current = unsort[0];
		for(int i = 0; i<unsort.length;i++){
			for(int j=0;j<unsort.length;j++){
				if(unsort[j]<=current)
					current = unsort[j];
			}
			sorted[i] = current;
		}
		
		
		return sorted;
	}
	
	

}
