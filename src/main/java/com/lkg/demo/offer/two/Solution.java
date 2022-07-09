package com.lkg.demo.offer.two;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    public void mainTest(){

    }

    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * 说明：
     * 用返回一个整数列表来代替打印
     * n 为正整数
     *
     * 示例 1:
     * @param n 输入: n = 1
     * @return 输出: [1,2,3,4,5,6,7,8,9]
     */
    public int[] printNumbers(int n) {
        return new int[]{1};
    }

    public double myPow(double x, int n) {
        // 问0的0次幂没有意义，问面试官如何处理；
        // 0的负数次幂，不能处理，异常处理还是返回？
        // 右移运算代替除以2；位与运算代替求余运算（%）判断一个数是奇数还是偶数
        if (x==0 && n<=0){
            return 0;
        }

        double result = 1;
        if (n>0){
            for (int i=0;i<n;i++){
                result *= x;
            }
        }else if (n<0){
            int absN = Math.abs(n);
            for (int i=0;i<absN;i++){
                result *= x;
            }
            result = 1 / result;
        }
        return result;
    }

//    private double PowWithUnsignedExponent(double x, int n){
//        if (n == 0){
//            return 1;
//        }
//        if (n == 1){
//            return x;
//        }
//        double result = PowWithUnsignedExponent(x, n>> 1);
//        result *= result;
//        if (n & (n&1 == 1)){
//            result *= x;
//        }
//
//        return result;
//    }

}
