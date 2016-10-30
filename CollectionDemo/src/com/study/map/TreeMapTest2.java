package com.study.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * "asadbwieuqndkqsadnqiwdnbqw"获取该字符串中字母出现的次数
 * 希望打印结果：a(1)c(2)......
 * 通过结果发现每一个字母都有对应的次数
 * 说明字母和次数之间有映射关系
 * 发现有映射关系时，可以选择map集合
 * 因为map集合中存放的就是映射关系
 * 
 * 
 * 什么时候使用map集合呢？
 * 当数据之间存在映射关系的时候，就要先想map集合
 * 
 * 
 * 思路
 * 1、将字符串转换成字符串数据，因为要对每一个字符操作
 * 2、定义一个map集合，因为打印字母的结果有顺序，所以使用TreeMap
 * 3、遍历字符数组
 * 	将每一个字母作为键去查询map集合。
 * 	如果返回null,将该字母存入到map集合
 * 	如果返回不为null,说明字母在map集合中已经存在，并有对应的次数
 * 	那么就获取该次数，并进行自增，然后将该字母和自增后的次数存入到mao集合，覆盖调用键原来对应的次数
 * 	将map集合中的数据变成指定的字符串形式返回
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

public class TreeMapTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		charCount("asadbiaus,.,;/,,,.,uhdvnwndjofcuias");
	}
	
	public static String charCount(String str){
		char[] chs = str.toCharArray();
		TreeMap<Character,Integer> tmap = new TreeMap<>();
		for (int i=0;i<chs.length;i++){
			if (!((chs[i]>='a'&&chs[i]<='z')||(chs[i]>='A'&&chs[i]<='Z')))
				continue;
			
			Integer value = tmap.get(new Character(chs[i]));
			if (value==null){
				value=1;
			}else{
				value++;
			}
			tmap.put(new Character(chs[i]), value);
		}
		
		StringBuilder sb = new StringBuilder();
		Set<Map.Entry<Character, Integer>> entry = tmap.entrySet();
		Iterator<Map.Entry<Character, Integer>> it = entry.iterator();
		Map.Entry<Character, Integer> et = null;
		while(it.hasNext()){
			et = it.next();
			sb.append(et.getKey()+"("+et.getValue()+")");
		}
		
		System.out.println(sb);
		return sb.toString();
		
	}

}
