package com.lkg.study.Cyc2018.Algorithm.Cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LRU<K, V> implements Iterable<K>{
	private Node head;
	private Node tail;//尾
	private HashMap<K, Node> map;
	private int maxSize;



	public LRU(int maxSize){
		this.maxSize = maxSize;
		this.map = new HashMap<>(maxSize * 4 / 3);

		head = new Node(null, null);
		tail = new Node(null, null);

		head.next = tail;
		tail.pre = head;
	}



	@Override
	public Iterator<K> iterator() {
		return null;
	}

	@Override
	public void forEach(Consumer<? super K> action) {

	}

	@Override
	public Spliterator<K> spliterator() {
		return null;
	}


	private class Node{
		Node pre;
		Node next;
		K k;
		V v;

		public Node(K k, V v){
			this.k = k;
			this.v = v;
		}
	}

}
