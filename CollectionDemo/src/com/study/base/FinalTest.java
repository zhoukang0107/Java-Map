package com.study.base;
/**
 * final：作为一个修饰符
 * 1、可以修饰类、变量、函数
 * 2、被final修饰的类不可以被继承（继承有一个弊端，他打破了封装性），为了避免被子类覆盖复写功能，
 * 3、被final修饰的方法不能被复写
 * 4、被final修饰的变量是一个常量，只能赋值一次，既可以修饰成员变量，又可以修饰局部变量
 *    在描述事物时，一些数据的出现值是固定的，那么这时为了增强阅读性，都给这些值取个名字方便于阅读
 *    而这个值不需要改变，方便于应用,作为常量：常量的书写规范所有的字母都大写，如果有多个单词组成，每个单词间通过下划线连接
 * 5、内部类定义在类中的局部位置时，只能访问该局部被final修饰的局部变量
 *
 */
//不能被复写final类
/*final class Demo{
	
}

class SubDemo extends Demo{
	
}*/

//不能复写final方法
/*class Demo{
	void show1(){
		
	}
	
	final void show2(){
		
	}
}

class SubDemo extends Demo{
	void show2(){
	}
}*/

/*class Demo{
	final int x = 3;
	final double PI = 3.1425926;
	void show1(){
		x = 4;
	}
	
	void show2(){
		final int y = 5;
		y = 6;
	}
}

class SubDemo extends Demo{
	void show2(){
	}
}*/

public class FinalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
