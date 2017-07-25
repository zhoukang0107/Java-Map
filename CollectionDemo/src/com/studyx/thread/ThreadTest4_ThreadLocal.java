package com.studyx.thread;

import java.util.Random;

public class ThreadTest4_ThreadLocal {
	
private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
private static ThreadLocal<MyThreadScopeData> threadLocalObj = new ThreadLocal<>();

public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i=0;i<3;i++){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()+" " + data);
					//threadLocal.set(data);
					MyThreadScopeData scope = new MyThreadScopeData();
					scope.setName(Thread.currentThread().getName());
					scope.setAge(data);
					threadLocalObj.set(scope);
					new A().get();
					new B().get();
					
				}
			}).start();
		}
		
	}
	
	static class A {
		public void get(){
			
			System.out.println("MyScopeData: " + threadLocalObj.get().toString());
			//System.out.println(Thread.currentThread().getName()+" " + threadLocal.get());
		}
	}
	
	static class B{
		public void get(){
			System.out.println("MyScopeData: " + threadLocalObj.get().toString());
			//System.out.println(Thread.currentThread().getName()+" " + threadLocal.get());
		}
	}
}

class MyThreadScopeData{
	String name;
	Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "MyThreadScopeData [name=" + name + ", age=" + age + "]";
	}
	
	
}
