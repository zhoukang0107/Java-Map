package com.study.thread;

/**
 *           
 * 需求：简单的卖票程序
 * 多个窗口同时卖票
 * 
 * 创建线程的第二种方式：实现Runnable接口
 * 步骤：
 * 1、实现Runnable接口
 * 2、覆盖Runnable中的run方法
 *        将线程要运行的代码存放在run方法中
 * 3、通过Thread类建立线程对象
 * 4、将Runnable接口的子类对象作为实际参数传给Thread类的构造函数
 *        为什么将Runnable接口的子类对象传递给Thread的构造函数
 *        因为，自定义的run方法所属的对象时Runnable接口的子类对象
 *        所以要让线程去指定指定对象的run方法，就必须明确该run方法所属的对象
 * 5、调用Thread类的start方法开启线程并调用Runnable接口子类的run方法
 * 
 * 
 * 实现方式和继承方式有什么区别呢？
 * 实现方式好处：避免了单继承的局限性
 * 在定义线程时建议使用实现方式
 * 继承Thread：线程代码存放在Thread子类run方法中
 * 实现Runnable：线程代码存放在接口子类的run方法中
 * 
 */

class Ticket extends Thread{
	private static int tick = 100;
	
	public Ticket(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (true){
			if (tick>0){
				System.out.println(this.getName()+" sale:"+tick--);
			}
				
		}
	}
}

class Ticket1 implements Runnable{
	private static int tick = 100;
	
	public Ticket1() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true){
			if (tick>0){
				System.out.println(Thread.currentThread().getName()+" sale:"+tick--);
			}
				
		}
	}
}


public class ThreadTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	Ticket t1 = new Ticket("窗口1");
		Ticket t2 = new Ticket("窗口2");
		Ticket t3 = new Ticket("窗口3");
		Ticket t4 = new Ticket("窗口4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();*/
		
		Ticket1 ticket1 = new Ticket1();
		Thread thread1 = new Thread(ticket1);
		Thread thread2 = new Thread(ticket1);
		Thread thread3 = new Thread(ticket1);
		Thread thread4 = new Thread(ticket1);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}
