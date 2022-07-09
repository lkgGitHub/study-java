package com.lkg.demo.dataStructureAlgorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class sortDemo {

	@Test
	public void sort1(){
		int[] nums = {5, 4, 3, 2, 1};
		for (int i=0;i<nums.length-1;i++){
			for (int j=1;j<nums.length-i;j++){
				if (nums[j-1]>nums[j]){
					int tmp = nums[j-1];
					nums[j-1] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(nums));

	}

	@Test
	public void quickSort123(){
		int[] nums = {5, 4, 3, 2, 1};
		nums = quickSort(nums, 0, nums.length-1);
		System.out.println(Arrays.toString(nums));
	}
	private int[] quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int partitionIndex = partition(arr, left, right);
			quickSort(arr, left, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, right);
		}
		return arr;
	}

	private int partition(int[] arr, int left, int right) {
		// 设定基准值（pivot）
		int pivot = left;
		int index = pivot + 1;
		for (int i = index; i <= right; i++) {
			if (arr[i] < arr[pivot]) {
				swap(arr, i, index);
				index++;
			}
		}
		swap(arr, pivot, index - 1);
		return index - 1;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
