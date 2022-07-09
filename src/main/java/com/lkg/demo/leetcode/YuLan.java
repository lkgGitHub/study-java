package com.lkg.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class YuLan {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        combNoRep(arr,0,2);
        int[] a = {1, -2, 2, 0};

    }


    /*存放输出的数组集合*/
    private static List<Integer> outArr = new ArrayList<>();
    /*outArr内存放的数量*/
    private static int index=0;
    /**
     *
     * @param inArr 待组合的数组
     * @param n 表示inArr位置，如n=0则从inArr[0]-inArr[length-1]选取数字；n=1，则从inArr[1]-inArr[length-1]选取数字，length为数组长度
     * @param num 要选出数字的数量
     */
    public static void combNoRep(int[] inArr,int n,int num) {
        if(num<=0) { //num=0 递归出口
            for(int i:outArr) {System.out.print(i +" ");}System.out.println();//打印数组
        }else {
            for(int i=n;i<=inArr.length-num;i++) {
                if(outArr.size()<index+1) {
                    outArr.add(index++,inArr[i]);
                } /*此处两行为防止集合越界空指针异常，如果使用数组存放也可，即此处实现了选取一个元素放进输出数组里，对应上述文字说明2的每一步的a操作*/
                else
                    outArr.set(index++, inArr[i]);
                combNoRep(inArr,i+1,num-1); /*在选取的元素后面的元素中选取num-1个元素，对应文字说明2中每一步的b操作*/
                index--; //重新给输出数组定位，选取一下个序号的元素
            }
        }
    }



//    private static void f1(){
//        int count = 0;
//        int c = 0;
//        int[] a = {1, -2, 2, 0};
//        int n = a.length;
//        for(int i=0;i<n-1;i++){
//            for (int j=i+1;j<n;j++){
//                c++;
//                int x = a[i];
//                int y = a[j];
//                int ming_min = Math.min(Math.abs(x), Math.abs(y));
//                int ming_max = Math.max(Math.abs(x), Math.abs(y));
//                int hong_min = Math.min(Math.abs(x + y), Math.abs(x - y));
//                int hong_max = Math.max(Math.abs(x + y), Math.abs(x - y));
//                if ( hong_min<= ming_min && hong_max>= ming_max) {
//                    System.out.println("小明的区间：["+ming_min+ "," +ming_max+"]");
//                    System.out.println("小红的区间：["+hong_min+ "," +hong_max+"]");
//                    System.out.println("==========================================");
//                    count++;
//                }
//            }
//        }
//        System.out.println("小明总共有"+c+" ；count:"+count);
//    }
}
