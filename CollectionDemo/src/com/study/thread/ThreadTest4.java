package com.study.thread;

/**
 * 需求：
 * 银行由一个金库，有两个储户，分别存300，每次存100，存3次
 * 
 * 目的：该程序是否存在安全问题，如果有，如何解决？
 * 
 * 如何找到问题
 * 1、明确哪些代码是多线程运行代码
 * 2、明确共享数据
 * 3、明确多线程运行代码中哪些语句是操作共享数据的
 * 
 * 
 * 同步函数格式事例：
 * public synchronized void function(){
 *     //同步函数
 * }
 * 
 * 同步函数用的是哪一个锁？  this
 * 函数需要被对象调用，那么函数都有一个所属对象引用，就是this
 * 所以同步函数使用的锁是this
 * 
 * 
 * 通过改程序进行验证
 * 使用两个线程来卖票，一个线程在同步代码块中，一个线程在同步函数中。
 * 都在执行卖票动作
 * 
 */

import static java.lang.System.*;

class Back {
	private int sum;

	public synchronized void add(int n) {
		// synchronized (this) {
		this.sum += n;
		//
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("sum=" + sum);
		// }

	}
}

class Ticket3 implements Runnable {
	private static int tick = 100;
	public boolean flag = true;

	Ticket3(boolean flag) {
		// TODO Auto-generated constructor stub
		this.flag = flag;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (flag) {
			while (true) {
				try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				synchronized (this) {
					
					if (tick > 0) {
						System.out.println(Thread.currentThread().getName() + " sale:" + tick--);
					}
				}
			}
		} else {
			while (true) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				show();
			}
		}

	}

	synchronized void show() {
		if (tick > 0) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (tick > 0) {
				System.out.println("show sale:" + tick--);
			}
		}
	}
}

class Cus implements Runnable {

	private Back back = new Back();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int x = 0; x < 3; x++) {
			back.add(100);
		}
	}

}

public class ThreadTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Cus cus = new Cus();
		Thread thread1 = new Thread(cus);
		Thread thread2 = new Thread(cus);
		thread1.start();
		thread2.start();*/
		
		Ticket3 ticket1 = new Ticket3(true);
		Thread thread1 = new Thread(ticket1);
		Thread thread2 = new Thread(ticket1);
		thread1.start();
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ticket1.flag = false;
		thread2.start();
	}

}