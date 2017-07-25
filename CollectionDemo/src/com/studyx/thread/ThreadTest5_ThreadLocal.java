package com.studyx.thread;

import java.util.Random;

public class ThreadTest5_ThreadLocal {

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
					ThreadScopeData scope = ThreadScopeData.getThreadInstance();
					scope.setName(Thread.currentThread().getName());
					scope.setAge(data);
					new A().get();
					new B().get();
					
				}
			}).start();
		}
		
	}
	
	static class A {
		public void get(){
			
			System.out.println("ScopeData: " + ThreadScopeData.getThreadInstance().toString());
		}
	}
	
	static class B{
		public void get(){
			System.out.println("ScopeData: " + ThreadScopeData.getThreadInstance().toString());
		}
	}
}

class ThreadScopeData{
	private static ThreadLocal<ThreadScopeData> map = new ThreadLocal<>();
	
	public static ThreadScopeData getThreadInstance(){
		ThreadScopeData instance = map.get();
		if (instance==null){
			instance = new ThreadScopeData();
			map.set(instance);
		}
		return instance;
		
	}
	
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
		return "ThreadScopeData [name=" + name + ", age=" + age + "]";
	}
	
	
}
