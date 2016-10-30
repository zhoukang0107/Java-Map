package com.study.collection.list;
import java.util.LinkedList;

/*
 * 使用LinkedList模拟一个堆栈或者队列数据结构
 * 堆栈：后进先出
 * 队列：先进先出First in first out fifo
 */


class Queue<T>{
	private LinkedList<T> linkedList;
	public Queue() {
		// TODO Auto-generated constructor stub
		linkedList = new LinkedList<>();
	}
	
	public void push(T t){
		linkedList.addFirst(t);
	}
	
	public T pop(){
		return linkedList.removeLast();
	}
	
	public boolean isEmpty(){
		return linkedList.isEmpty();
	}
}
public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> queue = new Queue<String>();
		queue.push("linked01");
		queue.push("linked02");
		queue.push("linked03");
		queue.push("linked04");
		queue.push("linked05");
		while(!queue.isEmpty()){
			System.out.println(queue.pop());
		}
		
	}

}
