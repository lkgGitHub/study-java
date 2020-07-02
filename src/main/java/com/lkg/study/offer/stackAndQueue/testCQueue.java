package com.lkg.study.offer.stackAndQueue;

import org.junit.jupiter.api.Test;

public class testCQueue {
    
    @Test
    public void demo() {
        int value = 5;
        CQueue obj = new CQueue();
        obj.appendTail(value);
        int param_2 = obj.deleteHead();
    }
}
