package com.lkg.demo.offer.algorithm;

import org.junit.jupiter.api.Test;

/**
 * 剑指 Offer 12. 矩阵中的路径
 */
public class Offer12 {


    @Test
    public void demo(){
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));

        board = new char[][]{{'a', 'b'}, {'c', 'd'}};
        word = "abcd";
        System.out.println(exist(board, word));
    }

    public boolean exist(char[][] board, String word) {

      return true;
    }
}
