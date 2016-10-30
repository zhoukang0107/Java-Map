package com.study.base;

/**
 * 内部类定义在局部时：
 * 1、内部类定义在局部时不可以被成员修饰符修饰
 * 2、可以直接访问外部类中的成员，因为持有外部类的引用，
 *    但是不可以访问他所在局部中的变量，只能访问被final修饰的局部变量??????
 * 
 * 
 * 
 *
 */


class OuterClass{
	int x = 3;
	void method(final int a){ 
		//a++;
		final int y = 4;
		/* int y = 4;
		y++;*/
		class Inner{  //内部类定义在局部，不能被static修饰，也不能定义静态成员
			void function(){
				System.out.println("Inner:"+x+" y="+y+" a="+a);
			}
		}
		
		Inner inner = new Inner();
		inner.function();
	}
}



public class InterClassTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterClass outer = new OuterClass();
		outer.method(5);
		outer.method(6);
	}

}
