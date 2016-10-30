package com.study.collection.generic;

import java.util.ArrayList;
import java.util.Iterator;

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
 * 泛型限定符：
 * ？通配符，也可以理解为占位符
 * 泛型限定：
 * ？ extends E:可以接受E类型或者E的子类，上限
 * ？ super E:可以接受E类型或者E的父类型，下限
 * 
 *
 */



public class GenericTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ArrayList<String> al1 = new ArrayList<>();
		al1.add("list1");
		al1.add("list2");
		al1.add("list3");
		al1.add("list4");
		println(al1);
		
		ArrayList<Integer> al2 = new  ArrayList<>();
		al2.add(1);
		al2.add(2);
		al2.add(3);
		al2.add(4);
		println(al2);*/
		
		ArrayList<P> plist = new ArrayList<>();
		plist.add(new  P("persion1"));
		plist.add(new  P("persion2"));
		plist.add(new  P("persion3"));
		plist.add(new  P("persion4"));
		printP(plist);
		
		ArrayList<S> slist = new ArrayList<>();
		slist.add(new  S("student1"));
		slist.add(new  S("student2"));
		slist.add(new  S("student3"));
		slist.add(new  S("student4"));
		//printP(slist);   error
		printPS(slist);
		
	}
	
	public static void printP(ArrayList<P> al){
		Iterator<P> it = al.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getName());
		}
	}
	
	public static void printPS(ArrayList<? extends P> al){
		Iterator<? extends P> it = al.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getName());
		}
	}
	
	/*public static void println(ArrayList<?> al){
		Iterator<?> it = al.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public static <T> void println2(ArrayList<T> al){
		Iterator<T> it = al.iterator();
		while(it.hasNext()){
			T t = it.next();
			System.out.println(t);
		}
	}*/
	
	
}

class P{
	
	private String name;

	public P(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class S extends P{

	public S(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	//private String 
}
