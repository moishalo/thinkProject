package com.moishalo.algorithm.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: InsertionSort.java
 * @Package com.moishalo.algorithm.test
 * @Description: 插入排序，将第一个元素作为已排序元素，第二个元素开始遍历，插入应该插入的位置，如果是链表结构，比较容易写，如果是顺序表结构，算法比较耗时复杂
 * @author moishalo.zhang moishalo.zhang@gmail.com
 * @date 2012-10-1 下午4:32:52
 * @version V1.0
 */
public class InsertionSort {
	public int[] unsort = new int[] { 18, 30, 22, 69, 22, 21, 3, 6, 90, 88, 44 };
	public int[] expect = new int[] { 3, 6, 18, 21, 22, 22, 30, 44, 69, 88, 90 };

	@Test
	public void testInsertionSort() {
		insertionSort(unsort);
		print(unsort);
		Assert.assertArrayEquals(expect, unsort);
	}

	public void insertionSort(int[] unsort) {
		//标志目前已排序的部分的尾部索引
		int sortEndIndex = 0;
		
		//排序如果没进行到队列尾部一直进行
		while(sortEndIndex+1!=unsort.length){
			//目前进行排序的元素
			int current = unsort[sortEndIndex+1];
			//将进行排序的值与已排序的部分的每个对象进行比较，找到对应位置插入
			for(int i=0;i<=sortEndIndex;i++){
				//如果排序到了尾部直接比较
				if(i==sortEndIndex){
					if(current<unsort[sortEndIndex]){
						int temp = unsort[sortEndIndex];
						unsort[sortEndIndex] = current;
						unsort[sortEndIndex + 1] = temp;
					}
					sortEndIndex++;
					break;
				}
				//如果目前的值大于目前指向的值小于指向的值的后面的值，从已排序的最后一个值向后移动一个位置，
				//然后将目前的值插入到指向值的后方
				if(current >= unsort[i] && current < unsort[i + 1]){
					for(int j = sortEndIndex;j>i;j--){
						unsort[j+1] = unsort[j];
					}
					unsort[i + 1] = current;
					sortEndIndex++;
					break;
				}
				//如果值小于已排序的第一个值，直接将所有已排序元素后移，然后插入到第一个位置
				else if(current < unsort[i]){
					for(int j = sortEndIndex;j>=i;j--){
						unsort[j+1] = unsort[j];
					}
					unsort[i] = current;
					sortEndIndex++;
					break;
				}
			}
		}
			
	}
	
	private void print(int[] array){
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+",");
			
		}
		System.out.println();
	}

}
