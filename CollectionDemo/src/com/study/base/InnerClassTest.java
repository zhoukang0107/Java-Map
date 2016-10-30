package com.study.base;

import com.study.base.Outer.Inter;

/**
 * 内部类：将一个类定义在另一个类的里面，对里面那个类就称为内部类
 * 访问特点：
 * 1、内部类可以直接访问外部类的成员，包括私有成员
 *    之所以可以直接访问外部类中的成员，是因为内部类持有一个外部类的引用，格式：外部类名.this
 * 2、而外部类要访问内部类的私有成员必须有建立内部类的对象
 *
 *
 * 
 * 
 * 访问格式：
 * 1、当内部类定义在外部类的成员位置上，而且非私有，可以在外部其他类中可以直接建立内部类对象
 *    格式：外部类名.内部类名  变量名 = 外部类对象.内部类对象
 *    Outer.Inter inter = new Outer().new Inter();
 * 2、当内部类在成员位置上，就可以被成员修饰符所修饰
 *    比如，private 将内部类在外部类中进行封装
 *    static：static修饰时，内部类就具备了static特性
 *    当内部类被static修饰时，只能直接访问外部类中的static成员,出现了访问局限
 *    
 *    在外部其他类中，如何直接访问static内部类的非静态成员？
 *    Outer.Inter2 inter2 = new Outer.Inter2();
 *    
 *    在外部其他类中，如何直接访问static内部类的静态成员？
 *    Outer.Inter2.function1();
 * 
 * 
 * 注意：
 * 当内部类中定义了静态成员，该内部类必须是static的
 * 当外部类中静态方法访问内部类时，内部类也必须是静态的？？？不一定new Outer().new Inter().show();
 * 
 * 
 * 当描述事物时，事物的内部还有事物，该事物用内部类来描述，
 * 因为内部类事物在使用外部类事物的内容
 * 
 * 
 * 
 */



class Outer{
	private int x= 3;
	
	class Inter{   //内部类
		int x = 4;
		void  function(){
			int x = 5;
			System.out.println("内部类："+x);
			System.out.println("内部类："+this.x);
			System.out.println("内部类："+Outer.this.x);
		}
		
		/*static void  function2(){  //当内部类中定义了静态成员，该内部类必须是static的
			int x = 5;
			System.out.println("内部类："+x);
		}*/
		
		void show(){
			System.out.println("内部类 show："+x);
		}
	}
	
	public static void function(){
		new Outer().new Inter().show();;
	}
	
	private class Inter1{   //内部类可以被私有修饰
		void  function(){
			System.out.println("私有内部类："+x);
		}
	}
	
	static class Inter2{   //静态内部类
		void  function(){
			//System.out.println("私有内部类："+x);  //静态内部类不能访问外部类的非静态成员变量
		}
		
		static void  function1(){
			//System.out.println("私有内部类："+x);  //静态内部类不能访问外部类的非静态成员变量
		}
	}
	
	void method(){
		System.out.println(x);
		Inter in = new Inter();
		in.function();
	}
}
public class InnerClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Outer outer = new Outer();
		//outer.method();
		//直接访问内部类的成员
		Outer.Inter inter = new Outer().new Inter();
		inter.function();
		//访问静态内部类的非静态成员
		Outer.Inter2 inter2 = new Outer.Inter2();
		inter2.function();
		//访问静态内部类的静态成员
		Outer.Inter2.function1();
		
		Outer.function();
	}

}
