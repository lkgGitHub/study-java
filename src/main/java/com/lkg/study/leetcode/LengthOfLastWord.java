package com.lkg.study.leetcode;

public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a "));
    }

    private static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;

        String[] words = s.split(" ");
        if (words.length == 0)
            return 0;

        return words[words.length-1].length();
    }
}
