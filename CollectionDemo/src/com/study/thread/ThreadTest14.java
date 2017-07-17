package com.study.thread;

/**
 * void setPriority(int newPriority): 1~10级
 * MAX_PRIORITY,MIN_PRIORITY,NORM_PRIORITY
 * 
 * 线程优先级高只说明他被执行的机会大一些，优先级低也只能说明执行他的机会小一些
 * 
 * 
 * 
 * 
 * 
 * yield():
 * 暂停当前正在执行的线程对象，并执行其他线程
 * 
 * 
 * 线程组：
 * 线程组表示一个线程的集合。此外，线程组也可以包含其他线程组。线程组构成一棵树，在树中，除了初始线程组外，每个线程组都有一个父线程组。
 * 允许线程访问有关自己的线程组的信息，但是不允许它访问有关其线程组的父线程组或其他任何线程组的信息。
 * 
 * ThreadGroup.setMaxPriority(int pri)
 * 设置线程组的最高优先级。线程组中已有较高优先级的线程不受影响。
 * 如果 pri 参数小于 Thread.MIN_PRIORITY 或大于 Thread.MAX_PRIORITY，则线程组的最高优先级保持不变。
 * 否则，此 ThreadGroup 对象的优先级被设置为比指定的 pri 参数更小，所允许的最高优先级是此线程组的父线程组的优先级。（如果此线程组是系统线程组，没有父线程组，那么只需将最高优先级设置为 pri 即可。）然后使用 pri 作为此方法的参数，以递归的方式对属于此线程组的每个线程组调用此方法。
 * 
 * 
 * 
 * 
 * 
 * 
 */

import static java.lang.System.*;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class YieldRunnable implements Runnable{

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		for (int i=0;i<70;i++){
			out.println(Thread.currentThread().toString()+" running...."+i);
			Thread.yield();
		}
	}
	
}

public class ThreadTest14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YieldRunnable runnable = new YieldRunnable();
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		
		t1.start();
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.start();
		
		/*int num = 0;
		while(true){
			if (++num==70){
				break;
			}
			out.println(Thread.currentThread().toString()+" running...."+num);
		}*/
		out.println(Thread.currentThread().getName()+" over");
	}
}