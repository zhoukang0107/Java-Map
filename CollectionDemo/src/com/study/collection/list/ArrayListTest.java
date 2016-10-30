package com.study.collection.list;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 去除arraylist中重复元素
 * @author kang
 *
 */



public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//去除arraylist中重复字符串元素
		ArrayList<String> list = new ArrayList<>();
		list.add("java01");
		list.add("java02");
		list.add("java01");
		list.add("java02");
		list.add("java03");
		list.add("java04");
		list.add("java01");
		List<String> newlist = singleArrayList(list);
		System.out.println(newlist);
		//去除重复对象
		ArrayList<Person> list1 = new ArrayList<>();
		list1.add(new Person("java01"));
		list1.add(new Person("java02"));
		list1.add(new Person("java01"));
		list1.add(new Person("java02"));
		list1.add(new Person("java03"));
		list1.add(new Person("java04"));
		list1.add(new Person("java01"));
		List<Person> newlist1 = singleArrayList(list1);
		Iterator<Person> it = newlist1.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getName());
		}
		//去除arraylist中重复字符串元素
				ArrayList<String> list2 = new ArrayList<>();
				list2.add(new String("java01"));
				list2.add(new String("java02"));
				list2.add(new String("java01"));
				list2.add(new String("java02"));
				list2.add(new String("java03"));
				list2.add(new String("java04"));
				list2.add(new String("java01"));
				List<String> newlist2 = singleArrayList(list2);
				System.out.println(newlist2);
	}
	
	public static <T> List<T> singleArrayList(List<T> list){
		
		ArrayList<T> newList = new ArrayList<T>();
		Iterator<T> it = list.iterator();
		while( it.hasNext()){
			T obj = it.next();
			if (!newList.contains(obj)){
				newList.add(obj);
			}
		}
		return newList;
	}

}
