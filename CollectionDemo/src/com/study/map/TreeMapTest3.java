package com.study.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * map扩展知识
 * map集合被使用是因为有映射关系
 * 
 * 
 */

/*class Student implements Comparable<Student>{
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
*/

public class TreeMapTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,HashMap<String,String>> hclass = new HashMap<>();
		HashMap<String,String> yiban = new HashMap<>();
		yiban.put("01", "gaoyue1");
		yiban.put("02", "gaoyue2");
		yiban.put("03", "gaoyue3");
		yiban.put("04", "gaoyue4");
		HashMap<String,String> erban = new HashMap<>();
		erban.put("01", "zhoukang1");
		erban.put("02", "zhoukang2");
		erban.put("03", "zhoukang3");
		erban.put("04", "zhoukang4");
		hclass.put("yiban", yiban);
		hclass.put("erban", erban);
		
		
	}

}
