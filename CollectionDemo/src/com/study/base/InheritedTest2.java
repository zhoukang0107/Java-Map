package com.study.base;
/**
 * 子父类出现后，类中成员的特点
 * 类中成员：
 * 1、变量
 * 2、函数
 * 3、构造函数
 * 
 * 变量：
 * 如果子父类中出现了非私有的同名成员变量时，
 * 子类要访问本类中的变量，用this
 * 子类要访问父类中的同名变量，使用super
 * 
 * super的使用基本和this一样
 * this代表的是本类对象的引用
 * super代表的是父类对象的引用
 * 
 * 函数：
 * 子父类中函数
 * 当子类出现和父类一样的函数时，会运行子类函数中的内容
 * 如同父类的函数被覆盖一样
 * 这种情况是函数另一个特性：重写（覆盖）
 * 
 * 
 * 当子类继承了父类，沿袭了父类的功能，到子类中，
 * 但是子类虽然具有该功能，但是功能的内容和父类不一样，
 * 这时没有必要定义新功能，而是使用覆盖特殊，保留父类的功能定义，并重写功能内容
 * 
 * 覆盖：
 * 1、子类覆盖父类必须保证子类权限大于等于父类权限，才可以覆盖，否则编译失败
 * 2、静态只能覆盖静态
 *
 *
 * 记住：
 * 重载：只看同名函数的参数类别
 * 重写：子父类方法一模一样，包括返回值类型
 */


class A{
	int num=5;
	void show(){
		System.out.println("num="+num);
	}
	void showB(){
		System.out.println("num="+num);
	}
	
	void speck(){
		System.out.println("vb");
	}
}

class B extends A{
	int num=6;
	
	void show(){   //覆盖、重写
		System.out.println("num="+num+" this.num="+this.num+" super.num="+super.num);
	}
	
	void speck(){  //重写父类功能定义
		System.out.println("java");
	}
}

//子类堆空间  加载子类class文件时会先加载父类class文件
/**堆**
 * new B()
 * 
 * num B
 * num A
 * 
 * 
 *
 */


public class InheritedTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		B b = new B();
		b.show();
		b.showB();
	}

}


class Tel{
	void show(){
		System.out.println("number");
	}
	
	private void show11(){
		System.out.println("number");
	}
}

class NewTel extends Tel{
	/*private void show(){  子类权限大于等于父类
		//System.out.println("number");
		super.show();
		System.out.println("name");
		System.out.println("pic");
	}*/
	
	void show(){
		//System.out.println("number");
		super.show();
		System.out.println("name");
		System.out.println("pic");
	}
	
	void show11(){   //不是覆盖，子类都不知道父类有次功能
		System.out.println("number");
	}
	
	/*int show11(){  //错误
		System.out.println("number");
	}*/
}
