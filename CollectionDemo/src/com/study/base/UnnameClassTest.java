package com.study.base;
/**
 * 
 * @author kang
 *
 */

class Car{
	public int num;
	
	public void run(){
		
	}
}
public class UnnameClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//匿名对象，调用属性无意义，执行完毕就变成垃圾了
		new Car().num = 5;
		//匿名对象，调用方法有意义
		new Car().run();
		
		//匿名对象使用方法一：当对对象的只调用一次时，可以使用匿名对象来完成，这样写比较简化
		//如果一个对象进行多个成员调用，必须给这个对象起个名字
		
		//匿名对象使用二：可以将匿名对象作为实际参数进行传递
	}

}
