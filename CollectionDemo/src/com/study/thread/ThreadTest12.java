package com.study.thread;

/**
 * setDaemon()将该线程标记为守护线程或者用户线程，
 * 1、当正在运行的线程都是守护线程时，Java虚拟机退出
 * 2、该方法必须在启动线程前调用
 * 
 */

import static java.lang.System.*;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class StopThread1 implements Runnable{

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		while(true){
			out.println(Thread.currentThread().getName()+" running....");
		}
	}
	
}

public class ThreadTest12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StopThread1 stopThread = new StopThread1();
		Thread t1 = new Thread(stopThread);
		t1.setDaemon(true);
		Thread t2 = new Thread(stopThread);
		t2.setDaemon(true);
		
		t1.start();
		t2.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int num = 0;
		while(true){
			if (num++==60){
				break;
			}
			out.println(Thread.currentThread().getName()+" running...."+num);
		}
	}

}