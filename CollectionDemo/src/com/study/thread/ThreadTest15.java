package com.study.thread;

/**
 * 死锁：
 * 为减少出现死锁的可能、java1.2提出反对使用stop、suspend、resume、destroy方法
 * 之所以反对stop、是因为不安全、他会解除由线程获取的所有锁，而且如果对象处于一种不连贯状态，
 * 那么，其他线程可能在那种状态下检查和修改他们，结果造成一种微妙的局面，我们很难检查出真正的
 * 问题所在。所以应该尽量避免使用stop、用一个标志告诉线程什么时候通过推出自己的run方法来终止自己的执行
 * 如果一个线程被阻塞、比如他在等候输入的时候，那么一般都不能轮询一个标志，但在这种情况下，我们任然不
 * 应该使用stop，而应该换由thread提供的interrupt方法，一遍终止并推出堵塞代码。
 * Thread的destroy方法根本没有实现
 * 
 * 
 * 
 * 
 */

import static java.lang.System.*;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class ThreadTest15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YieldRunnable runnable = new YieldRunnable();
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		
		t1.start();
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.start();
		
		for (int i=0;i<100;i++){
			out.println(Thread.currentThread().getName()+" over");
		}
		out.println(Thread.currentThread().getName()+" over");
	}
}