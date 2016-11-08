package com.study.thread;

/**
 * stop方法已经过时
 * 如何停止线程？
 * 只有一种方法，run方法结束
 * 开启多线程运行，运行代码通常是循环结构
 * 
 * 只要控制住循环，就可以让run方法结束，也就是线程结束
 * 
 * 特殊情况：
 * 当线程处于冻结（wait,sleep，join）状态就不会读取标记，那么线程就不会结束
 * 
 * 当没有指定的方式让冻结的线程恢复到运行状态时，这时需要对冻结进行清除
 * 强制让线程恢复到运行状态中来，就要就可以操作标记让线程结束
 * 
 * 那么Thread类中提供了该方法叫做interrupt()方法
 */

import static java.lang.System.*;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class StopThread implements Runnable{

	private boolean flag = true;
	
	public void changeFlag(){
		flag = false;
	}
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		while(flag){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				out.println(Thread.currentThread().getName()+" "+e.getMessage());
				flag = false;
			}
			out.println(Thread.currentThread().getName()+" running....");
		}
		out.println(Thread.currentThread().getName()+" over");
	}
	
}

public class ThreadTest11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StopThread stopThread = new StopThread();
		Thread t1 = new Thread(stopThread);
		Thread t2 = new Thread(stopThread);
		
		t1.start();
		t2.start();
		
		int num = 0;
		while(true){
			if (num++==60){
				t1.interrupt();
				t2.interrupt(); 
				break;
			}
			out.println(Thread.currentThread().getName()+" running...."+num);
		}
	}

}