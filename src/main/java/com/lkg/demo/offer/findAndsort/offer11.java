package com.lkg.demo.offer.findAndsort;

import org.junit.jupiter.api.Test;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 */
public class offer11 {

    @Test
    public void Solution(){
        int[] numbers = new int[]{3,4,5,1,2};
//        System.out.println(minArray(numbers));
//        numbers = new int[]{2,2,2,0,1};
//        System.out.println(minArray(numbers));
//        numbers = new int[]{1,2,3,4,5};
//        System.out.println(minArray(numbers));
        numbers = new int[]{1,3};
        System.out.println(minArray(numbers));
    }
    // 二分法查找
    public int minArray(int[] numbers) {
        int len = numbers.length;
        switch (len){
            case 0: return 0;
            case 1: return numbers[0];
        }
        int left = 0, right = len - 1;
//        while ()


//        int left = 0, right = len - 1;
//        while (left<=right-1) {
//            int index = (left + right + 1) / 2;
//            if(numbers[left] <= numbers[index]){
//                left = index;
//            }
//            if(numbers[index] <= numbers[right]){
//                right = index;
//            }
//        }
//        if (left == right){
//            return numbers[0];
//        }else {
//            return numbers[right];
//        }
        return 1;
    }


    // 遍历数据方法
    public int minArray1(int[] numbers) {
        for (int i=1;i<numbers.length;i++){
            if (numbers[i-1] > numbers[i]){
                return numbers[i];
            }
        }
        return numbers[0];
    }
}
