package com.study.base;
/**
 * 子父类中构造函数
 * 在对子类对象进行初始化时，父类的构造函数也会运行，
 * 那是因为子类的构造函数默认第一行有一条隐式的super();
 * super()会访问父类中空参数的构造函数，而且子类所有的构造函数默认第一行都是super()
 * 
 * 
 * 
 * 为什么子类一定要访问父类的构造函数，
 * 因为父类父类中的数据子类可以直接获取，所以子类对象在建立时需要查看父类是如何对这些数据进行初始化的，所以子类
 * 在对象初始化时，需要先访问以下父类的构造函数
 * 如果要访问父类中指定的构造函数，可以通过手动定义super语句的方式来指定
 * 
 * 注意：super必须写在构造函数的第一行，先初始化父类，后初始化子类
 * 
 * 
 *
 * 子类的实例化过程
 * 结论：
 * 子类的所有构造函数，默认都会访问父类中空参的构造函数，因为子类每一个构造函数的第一行都有一句隐式super
 * 
 * 当父类中没有空参的构造函数时，子类必须手动通过super语句形式来指定要访问的父类中的构造函数
 * 当然子类构造函数的第一行也可以手动指定this语句来访问本类中的构造函数，子类中至少会有一个构造函数会访问父类中的构造函数
 */

import static java.lang.System.*;

class Fu{
	Fu(){
		out.println("Fu run");
	}
}

class Zi extends Fu{
	Zi(){
		//super();  构造函数前有一条super();
		out.println("Zi run");
	}
	
	Zi(int i)//不在调用super,因为this中调用过super语句了
	{
	   this();   //this和super不能同时出现在构造函数，他们必须都写在第一行 	，因为初始化工作需要先做
	}
}

class Fu1{
	/*Fu1(){
		out.println("Fu run");
	}*/
	Fu1(int i){
		out.println("Fu run"+1);
	}
}

class Zi1 extends Fu1{

	/*public Zi1() {
		// TODO Auto-generated constructor stub
	}*/
	Zi1(int i) {
		super(i); //父类没有无参构造函数时，子类必须显式调用父类的构造函数
		// TODO Auto-generated constructor stub
	}
	
}

public class InheritedTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Zi z = new Zi();
	}

}

/*class Person2{
	private String name;

	public Person2(String name) {
		this.name = name;
	}
	
}

class Student2 extends Person2{
	public Student2(String name){
		super(name);  //必须写在构造函数的第一行，先初始化父类，后初始化子类
	}
}*/


