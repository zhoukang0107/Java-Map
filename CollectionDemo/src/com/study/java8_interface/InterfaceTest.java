package com.study.java8_interface;

/**
 * JDK8接口:
 * JDK7版本，包含以前版本中的接口
 * 定义方式：
 *    interface 定义接口
 *    方法：public abstract 返回值    方法名字(参数);
 *    使用：定义一个子类，实现接口，重新接口中的全部抽象方法
 *    建立之类的对象
 * JDK8接口比起以前的版本，很大的变化
 * 初次接触8版本的程序人员，不习惯
 *     JDK8中的接口可以写方法体了！！！
 *     
 *     可以定义静态的方法，不是抽象，具体实现的
 *     直接使用接口名调用
 *     
 *     接口中不但定义静态的方法，还可以定义普通的方法，不是抽象的
 *     JDK8接口中允许使用关键字default
 *     default定义的默认方法是一个非静态的方法
 *     静态方法，直接接口名调用
 *     对于非静态方法，只能是对象调用
 *     可是接口不能建立对象
 *     
 *     需要子类实现这个接口，利用子类的对象调用接口中的默认方法
 *     
 *     面向对象中，java中的程序只能支持单继承
 *     一个类，只能继承一个类
 *     接口和类，是可以多实现的
 *     多继承类是会有安全隐患的，多实现类，没有安全隐患
 *     class A{
 *       void a(){}
 *     }
 *     class B{
 *       void a(){}
 *     }
 *     class C extends A,B{
 *     }
 *     new C().a();   //不知道调用的是哪个父类的方法
 *     
 *     interface A{
 *         void a();
 *     }
 *     interface B{
 *         void a();
 *     }
 *     class C implements A,B{
 *       void a(){}
 *     }
 *     new C().a();  //虽然接口A和B都有a()方法，但是实现主体子类只实现了一次
 *     
 *     JDK8子类实现多个接口，意思是不是Java8支持多继承了呢？？
 *    
 *     如果多个接口中定义了同样的静态方法，
 *     即是有实现类同时实现了多个接口，不允许使用实现类名调用接口的方法
 *     
 *     如果多个接口中定义了同样的默认方法
 *     实现类实现多个接口时，必须重写掉默认方法，否则编译失败
 *     
 *     JDK8不支持多继承
 *     尽量不要让实现类实现多个接口中带有相同的默认方法
 *     
 *     接口中的静态方法是否可以被实现类重写，
 *     重写没有问题，但是重写后，实现类的 类名.方法 
 *     调用的是实现类的方法
 *     如果你不重写，实现. 不能调用接口中的静态方法
 *     
 *     
 * 
 * 
 * 
 *
 */
/**
 * JDK8中的接口
 * 
 *
 */

interface Inter8{
	
	public static final int i = 0;
	//定义一个静态的带有方法体的方法
	//接口不能建立对象，静态方法，不需要对象
	//接口名调用
	public static void medth(){
		System.out.println("接口中的static方法");
		//Inter8 i = new Inter8();  //接口不可以定义对象
	}
	
	//定义接口中的默认方法,必须要有default关键字
	//这个方法是非静态的，不能类名调用，需要之类的对象
	public default void medthDefault(){
		System.out.println("接口中的default方法");
	}
}

//定义类实现Inter8接口
class Inter8Impl implements Inter8{
	//重写接口中的默认方法，不能带有关键字default
	public void medthDefault(){
		System.out.println("实现类重写接口中的default方法");
	}
}


interface Inter8A{
	public static void a(){
		System.out.println("接口A的静态方法a");
	}
	
	//定义A接口的默认方法
	public default void defaultMedth(){
		System.out.println("接口A的默认方法defaultMedth");
	}
}

interface Inter8B{
	public static void a(){
		System.out.println("接口B的静态方法a");
	}
	
	//定义B接口的默认方法,和A接口保持一致
	public default void defaultMedth(){
		System.out.println("接口B的默认方法defaultMedth");
	}
}

//同时实现接口A和B
class CClass implements Inter8A, Inter8B{

	//实现类强制覆盖父类冲突方法
	@Override
	public void defaultMedth() {
		// TODO Auto-generated method stub
		Inter8B.super.defaultMedth();
	}
}


public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//接口中方法调用
		Inter8.medth();
		//使用子类对象，调用接口中的默认方法
		Inter8Impl inter8Impl = new Inter8Impl();
		inter8Impl.medthDefault();
		//实现类不能调用接口类中的静态方法
		//inter8Impl.medth();
		//调用接口中的静态变量（常量）
		int i =inter8Impl.i;
		//使用多态的特点，接口指向自己的实现类，调用方法
		Inter8 inter8 = new Inter8Impl();
		inter8.medthDefault();
		
		//实现类的类名调用接口中的静态方法
		//实现类的类名不能调用接口中的静态方法a();
		//CClass.a();
		CClass c = new CClass();
		c.defaultMedth();
	}

}
