package com.lkg.study.aikeba;

import java.util.Arrays;

public class Day01 {

	public static int[] TwoSum(int[] nums, int target) {

		for (int i=0;i<nums.length-1;i++){
			for (int j=i+1;j<nums.length;j++){
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}

		return null;
	}

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		System.out.println(Arrays.toString(TwoSum(nums,9)));
	}
}
