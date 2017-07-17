package com.study.thread;

/**
 * 通过分析：发现打印出了重复和负数
 * 
 * 多线程的运行出现了安全问题
 * 问题的原因：当多条语句在操作同一个线程共享数据时，一个线程对多条语句只执行了一部分，还没有执行完，另一个线程参与进来，导致共享数据错误。
 * 
 * 解决办法：对多条操作共享数据的语句，只能让一个线程都执行完，在执行过程中其他线程不可以参与运行。
 * 
 * 
 * java对于多线程的安全问题提供了专业的解决方式：
 * 就是同步代码块
 * synchrcnized(对象){
 *     需要被同步的代码
 * }
 * 对象如同锁，持有锁的线程可以在同步中执行
 * 没有持有锁的线程即使获取cpu执行权，也进不去，因为没有获取锁
 * 
 * 
 * 
 * 哪些代码需要被同步哪些代码被共享操作
 * 
 * 同步的前提：
 * 1、必须要有两个或者两个以上的线程
 * 2、必须是多个线程使用同一个锁
 * 
 * 必须保证同步中只能有一个线程在执行
 * 
 * 
 * 好处：解决了多线程的安全问题
 * 弊端：多个线程都需要判断锁，较为消耗资源
 * 
 * Thinking java
 * 对于访问某个关键共享资源的所有方法，都必须把他们设为synchronized,否则就不能正常地工作。
 * 
 * 同步的效率：
 * 获取一把锁并非一种"廉价"方案，为一次方法的调用付出的代价(进入和退出方法，不执行方法主体)至少累加
 * 到四倍，而且根据具体实现方案，这一代价还有了能变得更高。所以假如已知一个方法不会造成冲突，最明智
 * 的做法便是撤销其中的synchronized关键字。
 * 
 */



class Ticket2 implements Runnable{
	private static int tick = 100;
	
	public Ticket2() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true){
			try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			synchronized(this){
				if (tick>0){
				
				System.out.println(Thread.currentThread().getName()+" sale:"+tick--);
			  }
			}	
		}
	}
}


public class ThreadTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Ticket2 Ticket2 = new Ticket2();
		Thread thread1 = new Thread(Ticket2);
		Thread thread2 = new Thread(Ticket2);
		Thread thread3 = new Thread(Ticket2);
		Thread thread4 = new Thread(Ticket2);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}
