package com.lkg.demo.Cache;

import java.util.HashMap;
import java.util.Iterator;

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

	public V get(K key){
		if (!map.containsKey(key)){
			return null;
		}

		Node node = map.get(key);
		unlink(node);
		appendHead(node);

		return node.v;
	}

	public void put(K key, V value){
		if (map.containsKey(key)){
			Node node = map.get(key);
			unlink(node);
		}

		Node node = new Node(key, value);
		map.put(key, node);
		appendHead(node);

		if (map.size() > maxSize){
			Node toRemove = removeTail();
			map.remove(toRemove);
		}
	}

	private void unlink(Node node){
		Node pre = node.pre;
		node.pre = node.next;
		node.next = pre;

//		Node pre = node.pre;
//		Node next = node.next;
//		pre.next = next;
//		next.pre = pre;
	}
	private void appendHead(Node node){
		node.next = head.next;
		head.next = node;

//		Node second = head;
//		second.pre = head;
//
//		head = node;
//		head.pre = null;
//		head.next = second;
	}
	private Node removeTail(){
		Node node = tail.pre;
		node.pre = tail;

//		Node node = tail.pre;
//		tail = node.pre;
//		node.next = null;
		return node;
	}

	@Override
	public Iterator<K> iterator() {
		return new Iterator<K>() {
			private Node cur = head.next;

			@Override
			public boolean hasNext() {
				return cur != tail;
			}

			@Override
			public K next() {
				Node node = cur;
				cur = cur.next;
				return node.k;
			}
		};
	}

	private class Node{
		Node pre;
		Node next;
		K k;
		V v;

		Node(K k, V v){
			this.k = k;
			this.v = v;
		}
	}

}
