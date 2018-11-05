package com.lkg.study.leetcode;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class InversionInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-1234));
    }
    //Math.pow(double   m,   double  n)  ，m的n次幂
    public static int reverse(int x) {
        if (x == 0 || x == -2){
            return 0;
        }else if (x > 0){

        }else{

        }
        int lenght = (int)Math.log10(x) + 1;
        for (int i = 1; i<lenght; i++){
            int y = (int)Math.pow(10, i);
        }
        int a = x / 100 % 10;
        int b = x / 10 % 10;
        int c = x % 10;
        int d = x / 1000;
        return c*1000 + b*100 + a*10 + d;
    }
}
