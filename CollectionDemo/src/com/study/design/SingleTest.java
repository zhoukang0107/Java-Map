package com.study.design;

/**
 * 设计模式：解决某一类问题最行之有效的方法
 * Java中的23种设计模式：
 * 单例模式：解决一个类在内存中只存在一个对象
 * 
 * 要想确保对象唯一：
 * 1、为了避免其他程序过多建立该类对象，先禁止其他程序建立该类对象
 * 2、还为了让其他程序可以访问到该类对象只好在本类中定义一个对象。
 * 3、为了方便其他程序对自定义程序的访问，可以对外提供一下访问方式
 * 
 * 
 * 这三步怎么用代码体现呢？
 * 1、将构造函数私有化
 * 2、在类中创建一个本类对象
 * 3、提供一个方法可以获取到该对象
 */
//这个是先初始化对象
//饿汉式    Single类一进内存就已经创建好了对象   开发一般用
class Single{
	
	private static Single instance = new Single();  //instance在方法区，Single对象在堆区
	private Single(){}
	
	public static Single getInstance(){
		return instance;
	}
}

//对象时方法被调用时才初始化，也叫作对象的延时加载
//称为：懒汉式    Single类进内存对象还没有存在，只有调用了getInstance方法时才建立对象
class Single1{
	
	private static Single1 instance = null;
	private Single1(){}
	
	public static Single1 getInstance(){
		/*if (instance==null){
			instance = new Single1();
		}
		return instance;*/
		if (instance==null){
			synchronized(Single.class){  //减少了加锁次数
				if (instance==null){
					instance = new Single1();
				}
			}
		}
		return instance;
	}
}

//开发一般使用饿汉式，安全；懒汉式多线程时需要加锁，比较低效
//记住原则：定义单例时，建议使用饿汉式

public class SingleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Single single = Single.getInstance();  //single在栈区  指向堆区中的Single对象
	}
}
