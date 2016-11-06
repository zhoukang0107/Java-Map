package com.study.thread;

/**
 * 如果同步函数被静态修饰，使用的锁是什么？
 * 
 * 通过验证发现不在是this了，因为静态方法中不可以定义this
 * 
 * 静态进内存时内存中没有本类对象，但是一定有该类的字节码文件对象，
 * 类名.class   该对象的类型是Class
 * 
 * 
 * 静态的同步方法使用的锁是该方法所在类的字节码对象文件，也就是:类名.class
 */

import static java.lang.System.*;


class Ticket4 implements Runnable {
	private static int tick = 100;
	public boolean flag = true;

	Ticket4(boolean flag) {
		// TODO Auto-generated constructor stub
		this.flag = flag;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (flag) {
			while (true) {
				try {
						Thread.sleep(20);
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
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				show();
			}
		}

	}

	static synchronized void show() {
		if (tick > 0) {
			/*try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			if (tick > 0) {
				System.out.println("show sale:" + tick--);
			}
		}
	}
}


public class ThreadTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Ticket4 ticket1 = new Ticket4(true);
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