package com.study.thread;

/**
 * http://tool.oschina.net/apidocs/apidoc?api=jdk-zh
 * java.util.concurrent.atomic
 * 类的小工具包，支持在单个变量上解除锁的线程安全编程
 * 支持在单个变量上解除锁的线程安全编程。事实上，此包中的类可将 volatile 值、字段和数组元素的概念扩展到那些也提供原子条件更新操作的类
 * 这些方法的规范使实现能够使用当代处理器上提供的高效机器级别原子指令。但是在某些平台上，该支持可能需要某种形式的内部锁。因而，该方法不能严格保证不被阻塞 - 执行操作之前可能暂时阻塞线程。
 * 
 * 
 * Atomic作用
 * 对于原子操作类，Java的concurrent并发包中主要为我们提供了这么几个常用的：AtomicInteger、AtomicLong、AtomicBoolean、AtomicReference<T>。 
 * 对于原子操作类，最大的特点是在多线程并发操作同一个资源的情况下，使用Lock-Free算法来替代锁，这样开销小、速度快，对于原子操作类是采用原子操作指令实现的，
 * 从而可以保证操作的原子性。什么是原子性？比如一个操作i++；实际上这是三个原子操作，先把i的值读取、然后修改(+1)、最后写入给i。所以使用Atomic原子类操作数，
 * 比如：i++；那么它会在这步操作都完成情况下才允许其它线程再对它进行操作，而这个实现则是通过Lock-Free+原子操作指令来确定的
 * 如： 
 * AtomicInteger类中：
 *
 *  public final int incrementAndGet() {
 *     for (;;) {
 *        int current = get();
 *        int next = current + 1;
 *        if (compareAndSet(current, next))
 *           return next;
 *     }
 * }
 * 而关于Lock-Free算法，则是一种新的策略替代锁来保证资源在并发时的完整性的，Lock-Free的实现有三步：
 *
 * 1、循环（for(;;)、while） 
 * 2、CAS（CompareAndSet） 
 * 3、回退（return、break）
 * 
 * 
 * AtomicInteger
 * 可以用原子方式更新的 int 值。有关原子变量属性的描述。AtomicInteger 可用在应用程序中（如以原子方式增加的计数器），并且不能用于替换 Integer。但是，此类确实扩展了 Number，允许那些处理基于数字类的工具和实用工具进行统一访问。
 * AtomicInteger() 创建具有初始值 0 的新 AtomicInteger
 * AtomicInteger(int initialValue) 创建具有给定初始值的新 AtomicInteger
 * int addAndGet(int delta) 以原子方式将给定值与当前值相加
 * boolean compareAndSet(int expect, int update) 如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值
 * int decrementAndGet() 以原子方式将当前值减 1
 * int get() 获取当前值
 * int getAndAdd(int delta) 以原子方式将给定值与当前值相加
 * int getAndDecrement() 以原子方式将当前值减 1
 * int getAndIncrement() 以原子方式将当前值加 1
 * int getAndSet(int newValue) 以原子方式设置为给定值，并返回旧值
 * int incrementAndGet() 以原子方式将当前值加 1
 * int intValue() 以 int 形式返回指定的数值
 * void	lazySet(int newValue) 最后设置为给定值
 * long	longValue() 以 long 形式返回指定的数值
 * void	set(int newValue) 设置为给定值
 * boolean weakCompareAndSet(int expect, int update) 如果当前值 == 预期值，则以原子方式将该设置为给定的更新值
 */

import static java.lang.System.*;

import java.util.concurrent.atomic.AtomicInteger;

class Res2 {
	private String name;
	private String sex;
	private boolean flag = false;
	AtomicInteger atomic;
	public synchronized void set(String name,String sex){
		while (flag){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.name = name;
		this.sex = sex;
		flag = true;
		notifyAll();
	}

	public synchronized void out() {
		while (!flag){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		out.println(name + "  " + sex);
		notifyAll();
		flag = false;
	}
	
	
}

class Input2 implements Runnable {

	private Res2 res = null;

	public Input2(Res2 res) {
		// TODO Auto-generated constructor stub
		this.res = res;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean flag = true;
		while (true) {	
				if (flag) {
					flag = false;
					res.set("mike", "man");
				} else {
					flag = true;
					res.set("lili", "woman");
				}
	
		}
	}
}

class Output2 implements Runnable {
	private Res2 res = null;

	public Output2(Res2 res) {
		// TODO Auto-generated constructor stub
		this.res = res;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			res.out();
		}
	}
}

public class ThreadTest16_atomic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Res2 res = new Res2();
		new Thread(new Input2(res)).start();
		new Thread(new Output2(res)).start();
	}

}