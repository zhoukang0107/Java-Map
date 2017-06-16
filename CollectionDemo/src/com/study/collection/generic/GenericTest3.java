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

/*
 * 泛型类（引用数据类型）：
 * 设什么时候定义泛型类
 * 当类中要操作的引用数据类型不确定时，
 * 早期定义Object完成扩展
 * 现在定义泛型来完成扩展
 */
class Worker{
	
}

class Student{
	
}


/*class Tool{
	private Worker worker;
	public void setWorker(Worker worker){
		this.worker = worker;
	}
	public Worker getWorker() {
		return worker;
	}
}*/

/*class Tool{
	private Object object;
	public void setObject(Object object){
		this.object = object;
	}
	public Object getObject() {
		return object;
	}
}*/

//泛型类
class Utils<T>{
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}




public class GenericTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Tool t = new Tool();
		t.setWorker(new Worker());
		t.getWorker();*/
		
		/*Tool t = new Tool();
		t.setObject(new Worker());
		Worker worker = (Worker)t.getObject();*/
		
		Utils<Worker> u = new Utils<Worker>();
		u.setT(new Worker());
		Worker worker = u.getT();
	}

}
