package com.study.collection.set;
import java.util.Comparator;
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
 * 当元素自身不具备比较性时，或者具备的比较性不是所需，这时需要让容器自身具备比较性
 * 定义了比较器，将比较器对象作为参数传入TreeSet的构造函数
 * 当两种比较都存在时，以比较器为准
 * 定义一个Comparator类，实现compare方法
 */


public class TreeSetTest2 {

	public static void main(String[] args) {
		
		
		TreeSet<Student> treeSetStu = new TreeSet<>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				int res = o1.getName().compareTo(o2.getName());
				System.out.println("o1:"+o1.getName()+":"+o1.getAge()+" o2:"+o2.getName()+":"+o2.getAge());
				if (res==0){
					return o1.getAge() - o2.getAge();
				}
				return res;
			}
		});
		
		treeSetStu.add(new Student("TreeSetStu4",28));
		treeSetStu.add(new Student("TreeSetStu5",14));
		treeSetStu.add(new Student("TreeSetStu1",18));
		treeSetStu.add(new Student("TreeSetStu3",30));
		treeSetStu.add(new Student("TreeSetStu2",20));
		treeSetStu.add(new Student("TreeSetStu0",20));
		Iterator<Student> itStu = treeSetStu.iterator();
		while(itStu.hasNext()){
			Student stu = itStu.next();
			System.out.println(stu.getName()+":"+stu.getAge());
		}
	}

}
