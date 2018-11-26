package com.lkg.study.leetcode;

/**
 * 13. 罗马数字转整数
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 *
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 *
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 *
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 *
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class romanToInt {

    public static void main(String[] args) {
        System.out.println(romanToInt1(null));
    }
    
    private static int romanToInt1(String s) {
        if (s == null) return 0;
        char[] str = s.toCharArray();//char数组
        int total = 0;
        if (str.length == 1){
            switch (str[0]){
                case 'I': total += 1; break;
                case 'V': total += 5; break;
                case 'X': total += 10; break;
                case 'L': total += 50; break;
                case 'C': total += 100; break;
                case 'D': total += 500; break;
                case 'M': total += 1000; break;
            }
            return total;
        }

        int i=0;
        for (;i<str.length - 1;i++){
            switch (str[i]){
                case 'I':
                    if (str[i+1] == 'V') {
                        total += 4; i++;
                    }else if (str[i+1] == 'X'){
                        total += 9; i++;
                    }else {
                        total += 1;
                    }
                    break;
                case 'V':
                    total += 5;break;
                case 'X':
                    if (str[i+1] == 'L') {
                        total += 40; i++;
                    }else if (str[i+1] == 'C'){
                        total += 90; i++;
                    }else {
                        total += 10;
                    }
                    break;
                case 'L':
                    total += 50;break;
                case 'C':
                    if (str[i+1] == 'D') {
                        total += 400; i++;
                    }else if (str[i+1] == 'M'){
                        total += 900; i++;
                    }else {
                        total += 100;
                    }
                    break;
                case 'D':
                    total += 500;break;
                case 'M':
                    total += 1000;break;
            }
        }
        if (i != str.length){
            switch (str[str.length-1]){
                case 'I': total += 1; break;
                case 'V': total += 5; break;
                case 'X': total += 10; break;
                case 'L': total += 50; break;
                case 'C': total += 100; break;
                case 'D': total += 500; break;
                case 'M': total += 1000; break;
            }
        }
        return total;
    }
}