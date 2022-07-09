package com.lkg.demo.leetcode;

/**
 * 14. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class longestCommonPrefix {

    public static void main(String[] args) {
        String[] str = new String[]{"aca","cba"};
        System.out.println("str:"+longestCommonPrefix2(str));
    }

    private static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }else if (strs.length == 1){
            return strs[0];
        }

        char[][] chars = new char[strs.length][];
        int i = 0;
        for (String str: strs){
            char[] c = str.toCharArray();
            chars[i++] = c;
        }

        StringBuilder commonPrefix1 = new StringBuilder();
        int a=0;
        boolean bool = false;
        for (;a<chars[0].length;a++){
            char tmp = chars[0][a];

            for (int b=1;b<strs.length;b++){
                if (a >= chars[b].length || tmp != chars[b][a]){
                    bool = true;
                    break;
                }
            }

            if (bool) break;
        }

        for (int z=0;z<a;z++){
            commonPrefix1.append(chars[0][z]);
        }
       return commonPrefix1.toString();
    }

    private static String longestCommonPrefix2(String[] strs){
        if (strs.length < 1)
            return "";
        else if (strs.length == 1)
            return strs[0];

        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<strs[0].length();i++){
            char cur = strs[0].charAt(i);
            boolean bool = false;
            for (int j=1;j<strs.length;j++){
                if (i >= strs[j].length() || strs[j].charAt(i) != cur){
                    bool = true;
                    break;
                }
            }
            if (bool)
                break;
            stringBuilder.append(cur);
        }
        return stringBuilder.toString();
    }
}
