package com.moishalo.algorithm.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName: BucketSort
 * @Description: 桶排序,有范围限制，限制被排序数组需要有一定范围比如0-99,且不能有重复值
 * @author moishalo moishalo.zhang@gmail.com
 * @date 2012-10-1 下午4:06:51
 *
 */
public class BucketSort {
	public int[] unsort = new int[] { 18, 30, 22, 69, 21, 3, 6, 90, 88, 44 };
	public int[] expect = new int[] { 3, 6, 18, 21, 22, 30, 44, 69, 88, 90 };

	@Test
	public void testBucketSort() {
		int[] result = bucketSort(unsort);
		print(result);
		Assert.assertArrayEquals(expect, result);
	}
	
	public int[] bucketSort(int[] unsort){
		//需要准备最大范围个空桶
		int[] bucket = new int[100];
		for(int i =0;i<unsort.length;i++){
			bucket[unsort[i]] = unsort[i];
		}
		return trimArray(bucket,unsort.length);
	}
	
	public int[] trimArray(int[] unTrim,int length){
		int[] result = new int[length];
		int index = 0;
		for(int i=0; i<unTrim.length;i++){
			if(unTrim[i]!=0){
				result[index] = unTrim[i];
				index++;
			}
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
