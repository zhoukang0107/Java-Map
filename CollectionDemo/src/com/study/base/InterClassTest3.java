package com.study.base;

/**
 * 匿名内部类：
 * 1、匿名内部类其实就是内部类的简写形式
 * 2、定义匿名内部类的前提：
 *    内部类必须继承一个或者实现接口
 * 3、匿名内部类的格式：
 *    new 父类或者接口(){定义子类的内容}
 * 4、其实匿名内部类就是一个匿名子类对象，可以理解为带内容的对象
 * 5、匿名内部类中定义的方法最好不要超过3个
 * 
 *
 */

abstract class AbsInner{
	abstract void show();
}

class OuterClass1{
	int x = 3;
	class Inner extends AbsInner{  //内部类定义在局部，不能被static修饰，也不能定义静态成员
		void function(){
			System.out.println("Inner:"+x);
		}

		@Override
		void show() {
			// TODO Auto-generated method stub
			System.out.println("Inner show:"+x);
		}
	}
	
	public void function(){ 
		new Inner().show();  //匿名对象
	}
	
	public void function1(){ //匿名内部类
		new AbsInner() {
			@Override
			void show() {
				// TODO Auto-generated method stub
				System.out.println("匿名内部类 show："+x);
			}
		}.show();
		
        new AbsInner() {
			
			@Override
			void show() {
				// TODO Auto-generated method stub
				System.out.println("匿名内部类 show："+x);
			}
			
			void show1(){
				System.out.println("匿名内部类子类show："+x);
			}
		}.show1();
		
		AbsInner absinner = new AbsInner() {		
			@Override
			void show() {
				// TODO Auto-generated method stub
				System.out.println("匿名内部类 show："+x);
			}
		};
		absinner.show();
	}
}



public class InterClassTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterClass1 outer = new OuterClass1();
		outer.function();
		outer.function1();
		
		Test2.function().method();
	}

}

//练习
interface IInner{
	void method();
}

class Test2{
	//补全代码，通过匿名内部类
	
	static IInner function(){
		return new IInner(){
			@Override
			public void method() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
