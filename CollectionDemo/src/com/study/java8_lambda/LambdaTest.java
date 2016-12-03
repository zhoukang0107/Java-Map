package com.study.java8_lambda;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Lambda表达式
 * 替换了原有的匿名内部类的写法
 * 简化匿名内部类的方式
 * 但是并不会生成匿名内部类文件
 * 
 * 
 * 
 * Lambda表达式的语法结构
 * (参数1，参数2...)->{
 *     重写方法的内容，不定义方法名
 * }
 *
 *
 * 缺点：接口有多个方法的时候不可以使用Lambda表达式
 */
/**
 * 多线程开启的案例
 * 实现Runnable接口方式
 *
 */

class Demo implements Runnable {
	public void run() {
		for (int i =0;i<100;i++){
			System.out.println("run.."+i);
		}
	}
}

public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test1();
		//test2();
		//test3();
		
		for (int i=0;i<100;i++){
			System.out.println("main.."+i);
		}
		test4();
	}
	
	public static void test1(){
		Thread t = new Thread(new Demo());
		t.start();	
	}

	/*
	 * 开启多线程，采用匿名内部类实现
	 */
	public static void test2(){
		//直接new Runnable接口
		 Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i =0;i<100;i++){
					System.out.println("run.."+i);
				}
			}
		});
		t.start();
	}
	
	/*
	 * 开启多线程，使用Lambda简化匿名内部类
	 */
	public static void test3(){
		//Runnable r = new Runnable{};
		//Lambda表达式改变上述程序
		/*Runnable r = ()->{
			for (int i =0;i<100;i++){
				System.out.println("run.."+i);
			}
		};
		
		Thread t = new Thread(r);
		t.start();*/
		
		Thread t = new Thread(()->{
			for (int i =0;i<100;i++){
				System.out.println("run.."+i);
			}
		});
		t.start();
	}
	
	/*
	 * 利用TreeSet集合，实现对存储对象的顺序，排序
	 * 匿名内部类替代比较器
	 */
	public static void test4(){
		/*Set<String> set  = new TreeSet<>(new StringLength());
		set.add("assdsd");
		set.add("wessdss");
		set.add("asx");
		set.add("zs");
		set.add("eaasdsdqa");
		set.add("fgdsh");
		System.out.println(set);*/
		
		/*Set<String> set  = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length()-o2.length();
			}
		});*/
		/*Set<String> set = new TreeSet<>((String s1,String s2)->{
			return s1.length() - s2.length();
		});*/
		Set<String> set = new TreeSet<>((s1,s2)->{
			return s1.length() - s2.length();
		});
		
		set.add("assdsd");
		set.add("wessdss");
		set.add("asx");
		set.add("zs");
		set.add("eaasdsdqa");
		set.add("fgdsh");
		System.out.println(set);
		
	}
	
}

class StringLength implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.length()-o2.length();
	}
	
}
