package com.study.collection.set;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * Set：无序不可重复元素
 * 		HashSet:数据结构是哈希表，线程是非同步的
 * 			保证元素唯一的原理：判断元素的hashCode值是否相同，如果相同还会继续判断元素的equals方法是否为true
 * 		HashTree:可以对set集合中的元素排序(强制元素实现Comparable接口),数据结构是有序二叉树
 * 			低层数据结构是二叉树;
 * 			保证元素唯一性的是compareTo返回0；
 * 			元素是否相同是根据compareTo比较的
 * 			
 * 			TreeSet排序的第一种方式：让元素自身具备比较性，元素需要实现Comparable接口，覆盖compareTo方法，这种方式也称为元素的自然顺序或者默认顺序
 * 			
 * 			TreeSet的第二种排序方式：当元素自身不具备比较性或者不是所需时，这时候需要让集合自身具备比较性
 * 					在集合一初始化就有了比较方式
 * 					
 * 				
 * 			
 * 			
 * 
 * 往集合中存储自定义对象学生，按照学生的年龄进行排序 	
 * (自定义对象不实现Comparable<T>接口，自定义对象不具有比较性，无法进行比较)
 * Exception in thread "main" java.lang.ClassCastException: Student cannot be cast to java.lang.Comparable
	at java.util.TreeMap.compare(Unknown Source)
	at java.util.TreeMap.put(Unknown Source)
	at java.util.TreeSet.add(Unknown Source)
	at TreeSetTest.main(TreeSetTest.java:56)
	
 * 排序时，当主要条件相等时，一定要判断次要条件
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
		System.out.println(name+":"+age+"<------>+"+o.getName()+":"+o.getAge());
		if (age>o.getAge()){
			return 1;
		}else if (age==o.getAge()){
			return name.compareTo(o.getName());
		}else{
			return -1;
		}
		//return age-o.getAge();
	}

	
}
public class TreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*TreeSet<String> treeset = new TreeSet<>();
		treeset.add("TreeSet4");
		treeset.add("TreeSet3");
		treeset.add("TreeSet1");
		treeset.add("TreeSet2");
		treeset.add("TreeSet5");
		
		Iterator<String> it = treeset.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
		
		TreeSet<Student> treeSetStu = new TreeSet<>();
		treeSetStu.add(new Student("TreeSetStu1",28));
		treeSetStu.add(new Student("TreeSetStu2",14));
		treeSetStu.add(new Student("TreeSetStu3",18));
		treeSetStu.add(new Student("TreeSetStu4",30));
		treeSetStu.add(new Student("TreeSetStu5",20));
		treeSetStu.add(new Student("TreeSetStu6",20));
		Iterator<Student> itStu = treeSetStu.iterator();
		while(itStu.hasNext()){
			Student stu = itStu.next();
			System.out.println(stu.getName()+":"+stu.getAge());
		}
	}

}
