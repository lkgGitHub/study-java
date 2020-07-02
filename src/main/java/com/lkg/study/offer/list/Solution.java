package com.lkg.study.offer.list;

import java.util.Stack;

public class Solution {

    /**
     * 面试题06-从尾到头打印链表
     * @param head ListNode
     * @return 数组
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> s = new Stack<>();
        while (head != null) {
            s.push(head.val);
            head = head.next;
        }
        int[] res = new int[s.size()];
        int i = 0;
        while (!s.isEmpty()) {
            res[i++] = s.pop();
        }
        return res;
    }
}
