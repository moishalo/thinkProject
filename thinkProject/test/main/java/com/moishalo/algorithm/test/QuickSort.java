package com.moishalo.algorithm.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: QuickSort.java
 * @Package com.moishalo.algorithm.test
 * @Description: 快速排序实现
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-1 下午3:07:02
 * @version V1.0
 */
public class QuickSort {

	public int[] unsort = new int[] { 18, 30, 22, 69,22, 21, 3, 6, 90, 88, 44 };
	public int[] expect = new int[] { 3, 6, 18, 21, 22, 22, 30, 44, 69, 88, 90 };

	@Test
	public void testQuickShort() {
		int[] result = quickSort(unsort);
		print(result);
		Assert.assertArrayEquals(expect, result);
	}

	public int[] quickSort(int[] unsort) {
		//如果传入的数组长度为0,直接返回该数组
		if(0==unsort.length)
			return unsort;
		//取第一个数字作为比较基准
		int middle = unsort[0];
		//比小于等于基数的数据放在左侧(虚拟)数组中，大于的放在右侧数组中
		int[] left = new int[unsort.length];
		int[] right = new int[unsort.length];
		int lIndex = 0;
		int rIndex = 0;
		for (int i = 1; i < unsort.length; i++) {
			if (middle < unsort[i]) {
				right[rIndex] = unsort[i];
				rIndex++;
			} else {
				left[lIndex] = unsort[i];
				lIndex++;
			}
		}
		//整理数组，将未填的值去掉
		left = trimArray(left, lIndex);
		right = trimArray(right, rIndex);
		//如果左右两个数组只有1个或0个数字时，合并左右两个数组和基数，基数放在中央
		if (lIndex < 2 && rIndex < 2) {
			return merger(left, middle, right);
		} 
		//如果两个数组内容多，认定数组中数据没有排序完毕，递归对左侧数组和右侧数组进行快排，将返回的结果进行合并
		else {
			int[] lResult = quickSort(left);
			int[] rResult = quickSort(right);
			return merger(lResult, middle, rResult);
		}

	}

	private int[] trimArray(int[] untrim, int length) {
		if (length == untrim.length)
			return untrim;
		int[] result = new int[length];
		while (length > 0) {
			result[length - 1] = untrim[length - 1];
			length--;
		}
		return result;
	}

	private int[] merger(int[] l, int middle, int[] r) {
		int[] result = new int[l.length + r.length + 1];
		for (int i = 0; i < l.length; i++) {
			result[i] = l[i];
		}
		result[l.length] = middle;
		for (int i = l.length + 1; i < l.length + r.length + 1; i++) {
			result[i] = r[i - l.length - 1];
		}
		return result;
	}
	
	private void print(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+",");
			
		}
		System.out.println();
	}

}
