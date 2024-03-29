package com.lkg.demo.leetcode;

/**
 * 53. 最大子序和
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    public static void main(String[] args) {
//        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = new int[]{1,2};
        System.out.println(maxSubArray(nums));
    }
    private static int maxSubArray(int[] nums) {
        if (nums==null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int max = Integer.MIN_VALUE;
        for(int i=1;i<=nums.length;i++){
            for (int j=0; j<nums.length;j++){
                int total = 0;
                int tmp = j;
                for (;j<tmp+i&& j<nums.length;j++){
                    total += nums[j];
                }
                if (total > max){
                    max = total;
                }
                j = tmp;
            }
        }
        return max;
    }

}
