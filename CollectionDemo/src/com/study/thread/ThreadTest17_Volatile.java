package com.study.thread;

/**
 * Volatile
 * 作用
 * Volatile可以看做是一个轻量级的synchronized，它可以在多线程并发的情况下保证变量的“可见性”，
 * 什么是可见性？就是在一个线程的工作内存中修改了该变量的值，该变量的值立即能回显到主内存中，
 * 从而保证所有的线程看到这个变量的值是一致的。所以在处理同步问题上它大显作用，而且它的开销比synchronized小、使用成本更低。 
 * 举个栗子：在写单例模式中，除了用静态内部类外，还有一种写法也非常受欢迎，就是Volatile+DCL：
 * public class Singleton {
 *     private static volatile Singleton instance;
 * 
 *     private Singleton() {
 *     }
 * 
 *     public static Singleton getInstance() {
 *         if (instance == null) {
 *             synchronized (Singleton.class) {
 *                 if (instance == null) {
 *                     instance = new Singleton();
 *                 }
 *             }
 *         }
 *         return instance;
 *     }
 * }
 * 这样单例不管在哪个线程中创建的，所有线程都是共享这个单例的。
 * 
 * 虽说这个Volatile关键字可以解决多线程环境下的同步问题，不过这也是相对的，因为它不具有操作的原子性，也就是它不适合在对该变量的写操作依赖于变量本身自己。
 * 举个最简单的栗子：在进行计数操作时count++，实际是count=count+1;，count最终的值依赖于它本身的值。所以使用volatile修饰的变量在进行这么一系列的操作的时候，就有并发的问题 
 * 举个栗子：因为它不具有操作的原子性，有可能1号线程在即将进行写操作时count值为4；而2号线程就恰好获取了写操作之前的值4，所以1号线程在完成它的写操作后count值就为5了，
 * 而在2号线程中count的值还为4，即使2号线程已经完成了写操作count还是为5，而我们期望的是count最终为6，所以这样就有并发的问题。而如果count换成这样：count=num+1；假设num是同步的，
 * 那么这样count就没有并发的问题的，只要最终的值不依赖自己本身。
 * 
 * 用法
 * 
 * 因为volatile不具有操作的原子性，所以如果用volatile修饰的变量在进行依赖于它自身的操作时，就有并发问题，如：count，像下面这样写在并发环境中是达不到任何效果的：
 * public class Counter {
 *     private volatile int count;
 * 
 *     public int getCount(){
 *         return count;
 *     }
 *     public void increment(){
 *         count++;
 *     }
 * }
 * 
 * 而要想count能在并发环境中保持数据的一致性，则可以在increment()中加synchronized同步锁修饰，改进后的为：
 * 
 * public class Counter {
 *     private volatile int count;
 * 
 *     public int getCount(){
 *         return count;
 *     }
 *     public synchronized void increment(){
 *         count++;
 *     }
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

import static java.lang.System.*;

import java.util.concurrent.atomic.AtomicInteger;


public class ThreadTest17_Volatile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Res2 res = new Res2();
		new Thread(new Input2(res)).start();
		new Thread(new Output2(res)).start();
	}

}