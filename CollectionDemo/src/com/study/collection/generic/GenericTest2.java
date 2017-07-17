package com.study.collection.generic;

/**
 * 泛型：1.5以后的新特性，用于解决安全问题，是一个安全机制
 * 好处：
 * 1、将运行时出现的ClassCastException转移到了编译时期，方便了程序员解决问题，让运行事情问题减少，安全
 * 2、避免了强制类型转换的麻烦
 * 
 *
 * 泛型格式：通过<>来定义要操作的引用数据类型
 * 在使用java提供的对象时，什么时候使用反省呢？
 * 通常在集合框架中很常见，只要见到<>就要定义泛型
 * 
 * 其实<>就是用来接收类型的
 * 
 * 当使用集合时，将集合中要存储的数据类型作为参数传递到<>中即可
 */

/**
 * 泛型类（引用数据类型）：
 * 设什么时候定义泛型类
 * 当类中要操作的引用数据类型不确定时，
 * 早期定义Object完成扩展
 * 现在定义泛型来完成扩展
 */

/**
 * 泛型方法
 * 泛型类定义的泛型在整个类中有效，如果被方法使用，那么泛型类明确要操作具体的类型后，所有要操作的类型都已经确定了
 * 为了让不同的方法可以操作不同的类型，而且类型还不确定，那么可以将泛型定义在方法上
 * 
 */

/**
 * 泛型静态方法
 * 静态方法不可以访问类上定义的泛型
 * 如果静态方法操作的应用数据类型不确定，可以将泛型定义在方法上
 */

/**
 * 泛型接口
 * 
 * 
 */

//泛型类
class Print<T>{
	public void println(T t){
		System.out.println("print:"+t);
	}
	
	public void show(T t){
		System.out.println("show:"+t);
	}
}

//泛型方法
class Show{
	public <T> void println(T t){
		System.out.println("print:"+t);
	}
	
	public <T> void show(T t){
		System.out.println("show:"+t);
	}
}

//泛型类和泛型方法
class PShow<P>{
	public void println(P p){
		System.out.println("print:"+p);
	}
	
	//泛型方法
	public <T> void show(T t){
		System.out.println("show:"+t);
	}
	
	/*public static void method(P p){
		System.out.println("show:"+p);
	}*/
	
	//静态方法
	public static <W> void method(W w){
		System.out.println("show:"+w);
	}
}

interface Inter<T>{
	void show(T t);
}

/*class InterImp implements Inter<String>{
	@Override
	public void show(String t) {
		// TODO Auto-generated method stub
		System.out.println("show:"+t);
	}
}*/

class InterImp<T> implements Inter<T>{
	@Override
	public void show(T t) {
		// TODO Auto-generated method stub
		System.out.println("show:"+t);
	}
}

public class GenericTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Print<String> p = new Print();
		//p.show(new Integer(4));
		p.println("haha");*/
		
		/*Show s = new Show();
		s.show("haha");
		s.println(new Integer(6));*/
		
		/*PShow<String> ps = new PShow<String>();
		ps.show(new Integer(6));
		ps.println("haha");
		//ps.println(new Integer(5));
		*/
		
		/*PShow<String> ps = new PShow<String>();
		ps.show(new Integer(6));
		ps.println("haha");
		PShow.method("hehe");*/
		
		/*InterImp i =new InterImp();
		i.show("hehe");*/
		
		InterImp<String> i = new InterImp();
		i.show("haha")
		;
	}

}
