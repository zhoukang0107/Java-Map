package com.study.thread;

/**
 * 单例模式
 * 
 * 饿汉式
 * 
 * class Single{
 *     private static final Single s = new Single();
 *     private Single(){}
 *     public static Single getInstance(){
 *         return s;
 *     }
 * }
 * 
 * 懒汉式
 * 
 * class Single{
 *     private static final Single s = null;
 *     private Single(){}
 *     public static Single getInstance(){
 *     if (s==null){
 *         s = new Single();
 *     }
 *         return s;
 *     }
 * }
 * 
 */

import static java.lang.System.*;

class Single{
	private static Single instance = null;
	private Single(){}
	
	public static Single getInstance(){
		if (instance==null){
			synchronized (Single.class) {
				if (instance==null){
					instance = new Single();
				}
			}
		}
		return instance;
	}
}


public class ThreadTest6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

}