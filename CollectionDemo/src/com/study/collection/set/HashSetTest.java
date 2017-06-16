package com.study.collection.set;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

/**
 * Set元素是无序的（存入和取出的顺序不一定一致），元素不可以重复
 * 		HashSet:底层数据结构是哈希表
 * 				HashSet是如何保证元素的唯一的呢：
 * 					是通过元素的两个方法，hashCode和equals来完成
 * 					如果元素的hashCode相同，才会判断equals是否为true，
 * 					如果元素的hashCode不同才会调用equals
 * 				注意：对于判断元素是否存在以及删除等操作，依赖的方法是元素的hashCode和equals（如果hashCode不同则不调用equals）
 * 		TreeSet:
 * Set功能和Collection的功能一致
 * HashSet保证元素唯一性:先比较hashCode，当hashCode相同时才去使用equals比较
 *
 */

class SetPerson{
	private String name;
	private String tel;
	public SetPerson(String name) {
		super();
		this.name = name;
	}

	public SetPerson(String name, String tel) {
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
	public int hashCode() {
		// TODO Auto-generated method stub
		System.out.println("hashCode<---->"+66);
		//return 66;
		return name.hashCode() + tel.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof SetPerson){
			SetPerson p = (SetPerson)obj; 
			System.out.println(name+":"+tel+"<--equal-->"+p.getName()+":"+p.getTel());
			if (p.getName().equals(name)&&p.getTel().equals(tel)){
				return true;
			}
		}
		return false;
	}
	
}

public class HashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	
	public static void test() {
		
		/*HashSet<String> hashSetStr = new HashSet<>();
		System.out.println(hashSetStr.add("set"));
		System.out.println(hashSetStr.add("set"));
		System.out.println(hashSetStr.add("set1"));*/
		
		HashSet<SetPerson> hashSet = new HashSet<>();
		System.out.println(hashSet.add(new SetPerson("set1", "tel")));
		System.out.println(hashSet.add(new SetPerson("set2", "tel")));
		System.out.println(hashSet.add(new SetPerson("set3", "tel")));
		System.out.println(hashSet.add(new SetPerson("set2", "tel")));
		
		System.out.println("contains:"+hashSet.contains(new SetPerson("set4", "tel")));
		System.out.println("contains:"+hashSet.contains(new SetPerson("set2", "tel")));
		System.out.println("remove:"+hashSet.remove(new SetPerson("set5", "tel")));
		System.out.println("remove:"+hashSet.remove(new SetPerson("set2", "tel")));
		
		Iterator<SetPerson> iter = hashSet.iterator();
		while(iter.hasNext()){
			SetPerson person = iter.next();
			System.out.println(person.getName()+":"+person.getTel());
	
			System.out.println(person);	
		}
		
		
		
	}
}
