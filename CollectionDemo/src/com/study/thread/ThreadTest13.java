package com.study.thread;

/**
 * join()
 * 当A线程执行到了B线程的join()方法时，A就会等待，等B线程都执行完，A才会执行
 * 
 * 
 * join可以用来临时加入线程执行
 */

import static java.lang.System.*;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class JoinRunnable implements Runnable{

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		for (int i=0;i<7000;i++){
			out.println(Thread.currentThread().getName()+" running...."+i);
		}
	}
	
}

public class ThreadTest13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JoinRunnable joinRunnable = new JoinRunnable();
		Thread t1 = new Thread(joinRunnable);
		Thread t2 = new Thread(joinRunnable);
		
		t1.start();
		/*try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int num = 0;
		while(true){
			if (++num==70){
				break;
			}
			out.println(Thread.currentThread().getName()+" running...."+num);
		}
		out.println(Thread.currentThread().getName()+" over");
	}
}