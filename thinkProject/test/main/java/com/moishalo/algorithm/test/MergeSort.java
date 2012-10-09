package com.moishalo.algorithm.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: MergeSort.java
 * @Package com.moishalo.algorithm.test
 * @Description: 归并排序，将大的需要排序的数组进行分组，分成小些的进行排序，然后合并
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-1 下午8:20:04
 * @version V1.0
 */
public class MergeSort {

	public int[] unsort = new int[] { 18, 30, 22, 69, 22, 21, 3, 6, 90, 88, 44 };
	public int[] expect = new int[] { 3, 6, 18, 21, 22, 22, 30, 44, 69, 88, 90 };

	@Test
	public void testMergeSort() {
		int[] result = mergeSort(unsort);
		print(result);
		Assert.assertArrayEquals(expect, result);
	}

	/**
	 * @Title: mergeSort
	 * @Description: 归并排序
	 * @param unsort
	 * @return 参数及返回值
	 * @return int[] 返回类型
	 * @throws
	 */
	public int[] mergeSort(int[] unsort) {
		int groupCount = 3;

		int[][] matrix = split(unsort, groupCount);
		for (int i = 0; i < matrix.length; i++) {
			innerSort(matrix[i]);
		}
		int[] result = new int[0];
		for (int i = 0; i < matrix.length; i++) {
			result = merge(result, matrix[i]);
		}
		return result;
	}

	/**
	 * @Title: split
	 * @Description: 分割方法，将数组按照顺序分割成一个矩阵(二维数组)
	 * @param unsort
	 * @param groupCount
	 * @return 参数及返回值
	 * @return int[][] 返回类型
	 * @throws
	 */
	public int[][] split(int[] unsort, int groupCount) {
		int groups = (int) Math.ceil(unsort.length / (double) groupCount);
		int[][] result = new int[groups][groupCount];

		for (int i = 0; i < groups; i++) {
			result[i] = i == groups - 1 ? new int[unsort.length % groupCount]
					: new int[groupCount];
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = unsort[groupCount * i + j];
			}
		}

		return result;
	}

	/**
	 * @Title: innerSort
	 * @Description: 内部用的排序方法，这里用冒泡排序
	 * @param unsort
	 * @return 参数及返回值
	 * @return int[] 返回类型
	 * @throws
	 */
	public void innerSort(int[] unsort) {
		int endIndex = unsort.length - 1;
		for (int i = 0; i < unsort.length; i++) {
			for (int j = 0; j < endIndex; j++) {
				if (unsort[j] > unsort[j + 1]) {
					int temp = unsort[j];
					unsort[j] = unsort[j + 1];
					unsort[j + 1] = temp;
				}
			}
			endIndex--;
		}

	}

	/**
	 * @Title: merge
	 * @Description: 合并两个已排序的数组的算法
	 * @param frist
	 * @param second
	 * @return 参数及返回值
	 * @return int[] 返回类型
	 * @throws
	 */
	public int[] merge(int[] first, int[] second) {
		if (0 == first.length) {
			return second;
		}
		if (0 == second.length) {
			return first;
		}

		int[] result = new int[first.length + second.length];
		int fIndex = 0;
		int sIndex = 0;
		int rIndex = 0;
		while (fIndex != first.length || sIndex != second.length) {
			if (rIndex == result.length - 1) {
				if (fIndex < first.length) {
					result[rIndex] = first[fIndex];
					fIndex++;
				}else{
					result[rIndex] = second[sIndex];
					sIndex++;
				}
			} else {
				if (first[fIndex] >= second[sIndex]) {
					result[rIndex] = second[sIndex];
					sIndex++;
				} else {
					result[rIndex] = first[fIndex];
					fIndex++;
				}
			}
			rIndex++;
		}
		return result;
	}

	private void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");

		}
		System.out.println();
	}

}
