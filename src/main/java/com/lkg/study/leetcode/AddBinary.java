package com.lkg.study.leetcode;

public class AddBinary {

    public static void main(String[] args) {
        String a = "1111";
        String b = "1111";
        System.out.println(addBinary(a, b));
    }

    private static String addBinary(String a, String b) {
        String[] aArr = a.split("");
        String[] bArr = b.split("");
        int aLen = a.length();
        int bLen = b.length();

        int len = Math.max(a.length(),b.length());
        int[] resultSum = new int[len];
        boolean bool = false; // 是否进位，各位默认不进位
        for (int i=1; i<=len; i++){

            int aNum = 0, bNum = 0;
            if (aLen - i >= 0)
                aNum = Integer.valueOf(aArr[aLen - i]);
            if (bLen - i >= 0)
                bNum = Integer.valueOf(bArr[bLen - i]);

            if (bool){
                int sum = aNum + bNum + 1;
                if (sum >= 2) {
                    resultSum[len-i] = sum - 2;
                    bool = true;
                } else {
                    resultSum[len-i] = sum;
                    bool = false;
                }
            }else {
                int sum = aNum + bNum;
                if (sum >= 2) {
                    resultSum[len-i] = 0;
                    bool = true;
                } else {
                    resultSum[len-i] = (char) sum;
                    bool = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (bool)
            sb.append(1);
        for (int i : resultSum) {
            sb.append(i);
        }
        return sb.toString();
    }
}
