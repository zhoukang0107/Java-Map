package com.study.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 需求 ：对学生对象按照年龄进行升序排序
 * 
 * 因为数据是以键值对形式存在的，所以要使用可以排序的Map集合：TreeMap
 * 
 * 
 *
 */

class Student implements Comparable<Student>{
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		int dif = age - o.getAge();
		if (dif==0){
			dif = name.compareTo(o.getName());
		}
		return dif;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
}

class StuComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		int dif = o1.getName().compareTo(o2.getName());
		if (dif==0){
			dif = o1.getAge() - o2.getAge();
		}
		return dif;
	}
	
}

public class TreeMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Student,String> tm = new TreeMap<>();
		
		tm.put(new Student("treemap1",12), "beijing");
		tm.put(new Student("treemap2",13), "shanghai");
		tm.put(new Student("treemap2",13), "shanghai");
		tm.put(new Student("treemap3",15), "guangzhou");
		tm.put(new Student("treemap4",11), "shengzheng");
		tm.put(new Student("treemap5",10), "xian");
		
		
		Set<Map.Entry<Student,String>> entrySet = tm.entrySet();
		Iterator<Map.Entry<Student, String>> it = entrySet.iterator();
		while(it.hasNext()){
			Map.Entry<Student, String>  entry = it.next();
			
			System.out.println(entry.getKey().toString()+"--"+entry.getValue());
		}
		System.out.println("\n");
		TreeMap<Student,String> tm2 = new TreeMap<>(new StuComparator());
		tm2.put(new Student("treemap4",12), "beijing");
		tm2.put(new Student("treemap1",13), "shanghai");
		tm2.put(new Student("treemap2",15), "guangzhou");
		tm2.put(new Student("treemap3",11), "shengzheng");
		tm2.put(new Student("treemap0",10), "xian");
		
		
		Set<Map.Entry<Student,String>> entrySet2 = tm2.entrySet();
		Iterator<Map.Entry<Student, String>> it2 = entrySet2.iterator();
		while(it2.hasNext()){
			Map.Entry<Student, String>  entry = it2.next();
			
			System.out.println(entry.getKey().toString()+"--"+entry.getValue());
		}

	}

}
