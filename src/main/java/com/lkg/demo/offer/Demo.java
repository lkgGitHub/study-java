package com.lkg.demo.offer;

import org.junit.jupiter.api.Test;

public class Demo {

    @Test
    public void main() {
        long start = System.currentTimeMillis();
        int n = 45;
        System.out.println(fib(n));
        System.out.println("spend time: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(fib1(n));
        System.out.println("spend time: " + (System.currentTimeMillis() - start));
        System.out.println(fib(n) == fib1(n));
    }


    public int fib(int n) {
        switch (n){
            case 0: return 0;
            case 1: return 1;
        }

        int fi = 0;
        int fi_1 = 1;
        int fi_2 = 0;
        for (int i=2; i<=n;i++){
            fi = fi_1 + fi_2;
            fi_2 = fi_1;
            fi_1 = fi;
        }
        return fi;
    }

    /**
     * 裴波那契数列 递归实现（效率低，大量重复计算）
     * @param n 整数
     * @return 整数
     */
    public int fib1(int n) {
        if (n<=0){
            return 0;
        }else if (n==1){
            return 1;
        }else {
            return fib1(n-1) + fib1(n-2);
        }
    }

}
