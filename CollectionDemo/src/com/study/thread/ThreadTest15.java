package com.study.thread;

/**
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