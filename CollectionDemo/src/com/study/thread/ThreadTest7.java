package com.study.thread;

/**
 * 死锁：
 * 同步中嵌套同步
 * 
 * 产生死锁的四个必要条件：
 * （1） 互斥条件：一个资源每次只能被一个进程使用。
 * （2） 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
 * （3） 不剥夺条件:进程已获得的资源，在末使用完之前，不能强行剥夺。
 * （4） 循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。
 */

import static java.lang.System.*;

class Ticket7 implements Runnable {
	private static int tick = 100;
	public boolean flag = true;
	Object obj = new Object();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (flag) {
			while (true) {
				synchronized (obj) {
					System.out.println("if:"+obj.getClass().getName());
					synchronized (this) {
						System.out.println("if:"+this.getClass().getName());
					}
				}
			}
		} else {
			synchronized (this) {
				System.out.println("else:"+this.getClass().getName());
				synchronized (obj) {
					System.out.println("else:"+obj.getClass().getName());
					
				}
			}
		}

	}
}

public class ThreadTest7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ticket7 t = new Ticket7();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		t1.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.flag = false;
		t2.start();
		
	}

}