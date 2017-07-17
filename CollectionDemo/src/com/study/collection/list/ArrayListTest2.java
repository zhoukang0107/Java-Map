package com.study.collection.list;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 将自定义对象作为元素集合放入ArrayList中，并去除重复元素
 * 比如：存入对象，同姓名，通手机号视为同一个人，为重复元素
 *
 *1、定义类
 *2、创建list,创建类对象并存入list
 *3、遍历，并比较重复元素
 *
 *List集合判断元素是否相同依据的是元素的equals方法
 */

class Person{
	private String name;
	private String tel;
	public Person(String name) {
		super();
		this.name = name;
	}

	public Person(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Person){
			Person p = (Person)obj; 
			System.out.println(name+":"+tel+"<---->"+p.getName()+":"+p.getTel());
			if (p.getName().equals(name)&&p.getTel().equals(tel)){
				return true;
			}
		}
		return false;
	}
	
}

public class ArrayListTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//去除重复对象
		ArrayList<Person> list1 = new ArrayList<>();
		list1.add(new Person("java01","110"));
		list1.add(new Person("java02","110"));
		list1.add(new Person("java01","110"));
		list1.add(new Person("java02","110"));
		list1.add(new Person("java03","110"));
		list1.add(new Person("java04","110"));
		list1.add(new Person("java01","110"));
		list1.remove(new Person("java04","110"));
		List<Person> newlist1 = singleArrayList(list1);
		Iterator<Person> it = newlist1.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getName());
		}
		
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
