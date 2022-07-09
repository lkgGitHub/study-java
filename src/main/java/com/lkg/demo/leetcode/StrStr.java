package com.lkg.demo.leetcode;

public class StrStr {

    public static void main(String[] args) {
//        String haystack = "aaaaa", needle = "bba";
//        String haystack = "a", needle = "a";
        String haystack = "mississippi", needle = "sippia";
        System.out.println(strStr2(haystack, needle));
    }
    private static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        if (haystack.length() < needle.length())
            return -1;

        for (int i=0; i<haystack.length(); i++){
            if (haystack.charAt(i) == needle.charAt(0)){
                boolean bool = true;
                int index = i;
                i++;

                if (i >=haystack.length()){
                    if (needle.length()>1){
                        return -1;
                    }
                }

                for (int j=1; j<needle.length()&&i<haystack.length(); j++,i++){
                    if (haystack.charAt(i) != needle.charAt(j)){
                        bool = false;
                        i--;
                        break;
                    }
                }

                if (bool){
                    return index;
                }else {
                    i = index;
                }

            }
        }
        return -1;
    }

    private static int strStr2(String haystack, String needle){
        return haystack.indexOf(needle);
    }
}
