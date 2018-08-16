package com.lkg.study.design_patterns;

/**
 * Created by lkg on 2018/8/14
 */
public class SingletonDefault {
	private static SingletonDefault ourInstance = new SingletonDefault();

	public static SingletonDefault getInstance() {
		return ourInstance;
	}

	private SingletonDefault() {
	}
}
