package com.study.base;

/**
 * 接口：
 * interface用于定义接口
 * 
 * 
 * 接口定义时，格式特点
 * 1、接口中常见定义：常量，抽象方法
 * 2、接口中的成员都有固定修饰符
 *    常量：public static final   缺少关键字系统会自动补齐
 *    方法：public abstract
 * 
 * 
 * 
 * 记住：接口中的成员都是public的
 * 
 * 
 * 接口：是不可以创建对象的，因为有抽象方法，
 * 需要被子类实现，子类对接口中的抽象方法全部覆盖后，子类才可以实例化
 * 否则子类是一个抽象类
 * 
 * 接口可以被类多实现，也是对多继承不支持的转换形式，java支持多实现
 * 
 * 
 * 类与类之间继承关系，类与接口之间实现关系，接口与接口之间继承关系
 * 接口之间可以继承，且存在多继承
 */


interface Inter{
	public static final int NUM = 0;
	public static int NUM1 = 1;
	public final int NUM2 = 2;
	int NUM3 = 3;
	
	public abstract void show();
}

class SubInter implements Inter{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		//NUM = 1;  //接口中的成员变量都是常量，不可修改
	}
}


interface Inter1{
	public abstract void show();
	public abstract void method();
}

class Test{
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("class show");
	}
}

abstract class Test1{
	public abstract void show();
}

class SubMultInter implements Inter,Inter1{

	@Override
	public void method() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
}

class SubMultInter1 extends Test implements Inter,Inter1{

	@Override
	public void method() {
		// TODO Auto-generated method stub
		
	}
	
}

class SubMultInter2 extends Test1 implements Inter,Inter1{

	@Override
	public void method() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
}

interface IA{
	public abstract void methodA();
}

interface IB extends IA{
	public abstract void methodB();
}

interface IC extends IB{
	public abstract void methodC();
}

class CD implements IC{

	@Override
	public void methodB() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void methodA() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void methodC() {
		// TODO Auto-generated method stub
	}
}

interface IE{
	public abstract void methodE();
}

interface IF extends IE,IC{  //接口之间可以多继承
	public abstract void methodE();
}

class CG implements IF{

	@Override
	public void methodC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void methodB() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void methodA() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void methodE() {
		// TODO Auto-generated method stub
		
	}
	
}


public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Inter.NUM);
		System.out.println(Inter.NUM1);
		System.out.println(Inter.NUM2);
		System.out.println(Inter.NUM3);
		
	}

}
