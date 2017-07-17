package com.study.thread;

/**
 * 进程：是一个正在执行的程序。
 *           每一个进程执行都有一个执行的顺序，该顺序就是一个执行路径，或者叫一个控制单元。
 *           
 * 线程：就是进程中的一个独立的控制单元，线程在控制着进程的执行
 * 
 * 一个进程中至少由一个线程。
 * 
 * java虚拟机启动的时候会有一个进程java.exe
 * 该进程中至少有一个线程在负责java程序的执行（其实不止，还有负责垃圾回收等线程）。
 * 而且这个线程运行的代码存在于main方法中，
 * 该线程称之为主线程
 * 
 * 扩展：其实更细节说明jvm，jvm启动不止一个线程，还有负责垃圾回收机制的线程
 * 
 * 如何在自定义代码中定义一个线程：
 * Thread类
 * 创建线程的第一种方式：继承Thread类，并覆盖run方法
 * 步骤：
 * 1、继承Thread类
 * 2、复写Thread类中的run方法
 *    目的：将自定义的代码存储在run方法中，让线程运行
 * 3、调用线程的start方法，该方法有两个作用：1、启动线程；2、调用run方法
 * 
 * 
 * 发现运行结果每次都不同，因为多个线程都在获取CPU的执行权，CPU执行到谁谁就运行（随机性），明确一点，在某一个时刻，只能有一个程序在运行（多核除外）
 * CPU在做着快速的切换，以达到看上去同时运行的效果。
 * 
 * 
 * 为什么要覆盖run方法呢？
 * Thread用于描述线程。
 * 该类定义了一个用于存储线程要运行的代码，该存储功能就是run方法
 * 
 * 也就是说Thread类中的run方法，用于存储线程中要运行的代码
 * 
 * 
 * 线程的四种状态
 * 被创建：线程对象已经创建，但尚未启动，所以不可运行
 * 可运行：一旦时间分片机制有空闲的CPU周期提供给一个线程，那个线程便可以立即开始运行
 * 		因此，线程可能在、也可能不在运行当中，但一旦条件许可，没有什么能阻止他的运行
 * 		它既没有"死"掉,也未被"堵塞"。
 * 死：从自己的run()方法中返回后，一个线程便已经"死"掉
 * 堵塞(Blocked)：线程可以运行，但有某种东西阻碍了他。若线程处于堵塞状态，调度机制
 * 		可以简单地跳过它，不给他分配任何CPU时间，除非线程再次进入"可运行"状态，
 * 		否则，不会采取任何操作。
 * 
 * 堵塞原因：
 * 1、调用sleep，是线程进入"睡眠"状态。在规定时间内。这个线程是不会运行的。
 * 2、suspend暂停了线程的执行。除非线程收到resume消息，否则不会返回"可运行"状态。
 * 3、用wait暂停了线程的执行。除非线程收到nofify或者notifyAll消息，否则不会变成"可运行"。
 * 4、线程正在等待一个IO操作完成。
 * 5、线程试图调用另一个对象的"同步"方法，但那个对象处于锁定状态，暂时无法使用。
 * 
 * 被创建
 * 运行(sleep时间到，notify)
 * 冻结（sleep，wait）
 * 消亡
 * 
 * static Thread currentThread()：获取当前线程对象
 * getName():获取线程名称
 * 
 * 
 * 
 * 
 * 
 */

class Demo extends Thread{
	public Demo(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i =0;i<60;i++){
			System.out.println(this.getName()+" thread demo run:"+ i);
		}
	}
}

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo threadDemo1 = new Demo("子线程1");   //定义一个线程
		threadDemo1.start();             //执行线程
		Demo threadDemo2 = new Demo("子线程2");   //定义一个线程
		threadDemo2.start();  
		for(int i =0;i<60;i++){
			System.out.println(Thread.currentThread().getName() +" main demo run:"+ i);
		}
	}

}
