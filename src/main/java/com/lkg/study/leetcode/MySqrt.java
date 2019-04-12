package com.lkg.study.leetcode;


/**
 * 69. x 的平方根
 *
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        System.out.println(mySqrt2(2147483647));
        System.out.println(Math.sqrt(2147483647));
        System.out.println("spend time:" + (System.currentTimeMillis() - start) / 1000);
    }

    /**
     * 2、可通过暴力破解，从1(i)开始算平方值；
     * *    若等于，即返回i；
     * *    若大于，即返回 i - 1;
     */
    private static int mySqrt(int x) {
        int i = 1;
        while (true) {
            if (i * i < x) {
                i++;
            } else if (i * i == x) {
                return i;
            } else {
                return i - 1;
            }
        }
    }

    /**
     * 3、优化，通过二分法，减少搜索范围；
     * *    若中间数值的平方值，大于输入值，则后方的数值，肯定大于；
     * *    若中间数值的平方值，小于输入值，则前方的数值，肯定小于；
     */
    private static int mySqrt2(int x) {
        if (x == 0 || x == 1) return x;

        int min = x / 2;
        while (true){
            if (min * min > x) {
                min /= 2;
            } else if (min * min == x) {
                return min;
            } else {
                break;
            }
        }
        while (true){
            if (min * min > x){
                return min -1;
            }else if(min * min == x){
                return min;
            }else{
                min += 1;
            }
        }

    }
}
