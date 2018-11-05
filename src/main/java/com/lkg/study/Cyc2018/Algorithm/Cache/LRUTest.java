package com.lkg.study.Cyc2018.Algorithm.Cache;



import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by lkg on 2018/8/16
 */
public class LRUTest {
	@Test
	public void test() {

		LRU<String, String> lru = new LRU<>(3);

		lru.put("K1", "V1");
		lru.put("K2", "V2");
		lru.put("K3", "V3");


		lru.get("K1");
		lru.get("K2");

		lru.put("K4", "V4");


		Iterator iterator = lru.iterator();

		assertEquals(iterator.next(), "K4");
		assertEquals(iterator.next(), "K2");
		assertEquals(iterator.next(), "K1");
	}
}
